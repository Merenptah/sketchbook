package com.hg.sketchbook.dataaggregation.immutable.explicit;

public record DomainData(SubData subData, OtherSubData otherSubData) {
    public record SubData (String id, String info) {
    }

    public record OtherSubData (String id, String info) {
    }
}
