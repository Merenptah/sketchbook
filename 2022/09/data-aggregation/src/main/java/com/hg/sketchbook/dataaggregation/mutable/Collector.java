package com.hg.sketchbook.dataaggregation.mutable;

public interface Collector {
    void collect(DomainData domainData);
}
