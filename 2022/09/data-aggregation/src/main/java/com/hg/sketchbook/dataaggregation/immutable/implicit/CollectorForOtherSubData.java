package com.hg.sketchbook.dataaggregation.immutable.implicit;


import com.hg.sketchbook.dataaggregation.immutable.InputData;

public class CollectorForOtherSubData implements Collector {
    @Override
    public DomainData.DomainDataBuilder collect(InputData inputData, DomainData.DomainDataBuilder builder) {
        return builder.otherSubData(
                new DomainData.OtherSubData(
                        inputData.otherSubDataId(),
                        "new other data " + inputData.otherSubDataId()));
    }
}
