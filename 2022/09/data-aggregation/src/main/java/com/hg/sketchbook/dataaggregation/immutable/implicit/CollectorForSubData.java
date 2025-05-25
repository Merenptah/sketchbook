package com.hg.sketchbook.dataaggregation.immutable.implicit;

import com.hg.sketchbook.dataaggregation.immutable.InputData;

public class CollectorForSubData implements Collector {
    @Override
    public DomainData.DomainDataBuilder collect(InputData inputData, DomainData.DomainDataBuilder builder) {
        return builder.subData(
                new DomainData.SubData(
                        inputData.subDataId(),
                        "new data " + inputData.subDataId()));
    }
}
