package com.hg.sketchbook.spocknested;

public class Request {
    private String firstField;
    private String secondField;
    private Nested nested;

    public Request(String firstField, String secondField, Nested nested) {
        this.firstField = firstField;
        this.secondField = secondField;
        this.nested = nested;
    }

    public String getFirstField() {
        return firstField;
    }

    public Request setFirstField(String firstField) {
        this.firstField = firstField;
        return this;
    }

    public String getSecondField() {
        return secondField;
    }

    public Request setSecondField(String secondField) {
        this.secondField = secondField;
        return this;
    }

    public Nested getNested() {
        return nested;
    }

    public Request setNested(Nested nested) {
        this.nested = nested;
        return this;
    }

    public static class Nested {
        private String nestedFirstField;

        public Nested(String nestedFirstField) {
            this.nestedFirstField = nestedFirstField;
        }

        public String getNestedFirstField() {
            return nestedFirstField;
        }

        public Nested setNestedFirstField(String nestedFirstField) {
            this.nestedFirstField = nestedFirstField;
            return this;
        }
    }
}
