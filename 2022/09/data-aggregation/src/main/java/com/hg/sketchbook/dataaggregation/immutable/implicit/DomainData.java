package com.hg.sketchbook.dataaggregation.immutable.implicit;

import lombok.Builder;
import lombok.NonNull;

import java.util.Objects;

@Builder
public final class DomainData {
    private final SubData subData;
    private final OtherSubData otherSubData;

    private DomainData(@NonNull SubData subData, @NonNull OtherSubData otherSubData) {
        this.subData = subData;
        this.otherSubData = otherSubData;
    }

    public SubData subData() {
        return subData;
    }

    public OtherSubData otherSubData() {
        return otherSubData;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (DomainData) obj;
        return Objects.equals(this.subData, that.subData) &&
                Objects.equals(this.otherSubData, that.otherSubData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subData, otherSubData);
    }

    @Override
    public String toString() {
        return "DomainData[" +
                "subData=" + subData + ", " +
                "otherSubData=" + otherSubData + ']';
    }

    public record SubData(String id, String info) {
    }

    public record OtherSubData(String id, String info) {
    }
}
