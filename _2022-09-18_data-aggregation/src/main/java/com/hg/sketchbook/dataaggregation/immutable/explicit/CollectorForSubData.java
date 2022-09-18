package com.hg.sketchbook.dataaggregation.immutable.explicit;

import com.hg.sketchbook.dataaggregation.immutable.InputData;

public class CollectorForSubData {
    public CollectedSubdata collect(InputData inputData) {
        return new CollectedSubdata("new data " + inputData.subDataId());
    }

    record CollectedSubdata(String info) {}
}
