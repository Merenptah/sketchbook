package com.hg.sketchbook.dataaggregation.mutable;

import lombok.AllArgsConstructor;

import java.util.Collection;

@AllArgsConstructor
public class CollectionOrchestrator {
    Collection<Collector> collectors;

    public void collect(DomainData domainData) {
        collectors.forEach(c -> c.collect(domainData));
    }
}
