package com.hg.sketchbook.dataaggregation.mutable;

public class CollectorForOtherSubData implements Collector {
    @Override
    public void collect(DomainData domainData) {
        domainData.getOtherSubData()
                .info("new other data " + domainData.getOtherSubData().getId());
    }
}
