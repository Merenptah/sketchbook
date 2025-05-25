package com.hg.sketchbook.dataaggregation.immutable.implicit;

import com.hg.sketchbook.dataaggregation.immutable.InputData;
import lombok.AllArgsConstructor;

import java.util.Collection;

@AllArgsConstructor
public class CollectionOrchestrator {
    Collection<Collector> collectors;

    public DomainData collect(InputData input) {
        var builder = new DomainData.DomainDataBuilder();

        collectors.forEach(coll -> coll.collect(input, builder));

        return builder.build();
    }
}
