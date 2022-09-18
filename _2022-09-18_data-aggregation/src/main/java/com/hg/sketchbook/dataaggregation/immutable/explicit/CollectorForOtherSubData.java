package com.hg.sketchbook.dataaggregation.immutable.explicit;


import com.hg.sketchbook.dataaggregation.immutable.InputData;

public class CollectorForOtherSubData {

    public CollectedOtherSubdata collect(InputData inputData) {
        return new CollectedOtherSubdata("new other data " + inputData.otherSubDataId());
    }

    record CollectedOtherSubdata(String info) {}
}
