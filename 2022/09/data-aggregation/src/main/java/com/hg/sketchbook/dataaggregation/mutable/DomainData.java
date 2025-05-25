package com.hg.sketchbook.dataaggregation.mutable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class DomainData {
    private SubData subdata;
    private OtherSubData otherSubData;

    @Getter
    @ToString
    public static class SubData {
        private final String id;
        private String info;

        public SubData(String id) {
            this.id = id;
        }

        public void info(String info) {
            this.info = info;

        }
    }

    @Getter
    @ToString
    public static class OtherSubData {
        private final String id;
        private String info;

        public OtherSubData(String id) {
            this.id = id;
        }

        public void info(String info) {
            this.info = info;

        }
    }
}
