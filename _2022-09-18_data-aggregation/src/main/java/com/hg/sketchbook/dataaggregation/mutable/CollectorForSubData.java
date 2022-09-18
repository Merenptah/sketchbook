package com.hg.sketchbook.dataaggregation.mutable;

public class CollectorForSubData implements Collector {
    @Override
    public void collect(DomainData domainData) {
        domainData.getSubdata().info("new data " + domainData.getSubdata().getId());
    }
}
