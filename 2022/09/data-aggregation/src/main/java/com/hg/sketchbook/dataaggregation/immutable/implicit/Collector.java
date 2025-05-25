package com.hg.sketchbook.dataaggregation.immutable.implicit;

import com.hg.sketchbook.dataaggregation.immutable.InputData;

public interface Collector {
    DomainData.DomainDataBuilder collect(InputData inputData, DomainData.DomainDataBuilder builder);
}
