package com.hg.sketchbook.spock.api;

public class Response {
    private ResponseData data;

    public Response(ResponseData data) {
        this.data = data;
    }

    public ResponseData getData() {
        return data;
    }

    static class ResponseData {
        private String name;
        private String address;
        public ResponseData(String name, String address) {
            this.name = name;
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public String getAddress() {
            return address;
        }
    }
}
