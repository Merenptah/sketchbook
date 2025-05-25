package com.hg.sketchbook.dataaggregation.immutable.explicit;

import com.hg.sketchbook.dataaggregation.immutable.InputData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
public class CollectionOrchestrator {
    CollectorForSubData collectorForSubData;
    CollectorForOtherSubData collectorForOtherSubData;

    public DomainData collect(InputData input) {
        var collectedSubdata = collectorForSubData.collect(input);
        var collectedOtherSubdata = collectorForOtherSubData.collect(input);

        return new DomainData(
                new DomainData.SubData(input.subDataId(), collectedSubdata.info()),
                new DomainData.OtherSubData(input.otherSubDataId(), collectedOtherSubdata.info()));
    }

    public DomainData collectInParallel(InputData input) {
        // Perform in parallel, build result at join time
        var builder = ResultCollector.builder();
        builder.collectedSubdata(collectorForSubData.collect(input));
        builder.collectedOtherSubdata(collectorForOtherSubData.collect(input));
        var result = builder.build();

        // use collected data
        return new DomainData(
                new DomainData.SubData(input.subDataId(), result.getCollectedSubdata().info()),
                new DomainData.OtherSubData(input.otherSubDataId(),
                        result.getCollectedOtherSubdata().info()));
    }

    @Builder
    @Getter
    private static class ResultCollector {
        private final CollectorForSubData.CollectedSubdata collectedSubdata;
        private final CollectorForOtherSubData.CollectedOtherSubdata collectedOtherSubdata;
    }
}
