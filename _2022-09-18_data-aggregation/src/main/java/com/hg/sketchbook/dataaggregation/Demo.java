package com.hg.sketchbook.dataaggregation;

import com.hg.sketchbook.dataaggregation.immutable.InputData;
import com.hg.sketchbook.dataaggregation.mutable.CollectionOrchestrator;
import com.hg.sketchbook.dataaggregation.mutable.CollectorForOtherSubData;
import com.hg.sketchbook.dataaggregation.mutable.CollectorForSubData;
import com.hg.sketchbook.dataaggregation.mutable.DomainData;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        // Mutable approach
        var mutableDomainData = new DomainData(
                new DomainData.SubData("idSubData"),
                new DomainData.OtherSubData("idOtherSubData"));

        var orchestrator = new CollectionOrchestrator(List.of(new CollectorForSubData(),
                new CollectorForOtherSubData()));

        orchestrator.collect(mutableDomainData);

        System.out.println(mutableDomainData);

        // Immutable approach, using explicit collectors
        var inputData = new InputData("idSubData", "idOtherSubData");

        var immutableOrchestrator = new com.hg.sketchbook.dataaggregation.immutable.explicit.CollectionOrchestrator(
                new com.hg.sketchbook.dataaggregation.immutable.explicit.CollectorForSubData(),
                new com.hg.sketchbook.dataaggregation.immutable.explicit.CollectorForOtherSubData());

        var immutableResult = immutableOrchestrator.collect(inputData);

        System.out.println(immutableResult);

        // Immutable approach, using implicit collectors
        var immutableImplicitOrchestrator =
                new com.hg.sketchbook.dataaggregation.immutable.implicit.CollectionOrchestrator(
                List.of(new com.hg.sketchbook.dataaggregation.immutable.implicit.CollectorForSubData(),
                new com.hg.sketchbook.dataaggregation.immutable.implicit.CollectorForOtherSubData()));

        var immutableImplicitResult = immutableImplicitOrchestrator.collect(inputData);

        System.out.println(immutableImplicitResult);
    }
}
