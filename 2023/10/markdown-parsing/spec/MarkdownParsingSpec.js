const parser = require('../src/parsing_markdown.js');

describe("Markdown parsing of inline fields", function() {
    it("does not find anything for an empty input", function() {

        let result = parser.parseInlineFields("");

        expect(result).toEqual([]);
    });
    it("finds a single field with one line value", function() {

        let result = parser.parseInlineFields("test:: This is the value");

        expect(result).toEqual([{key: "test", content:"This is the value"}]);
    });
    it("finds a single field with one line value, trimmed", function() {

        let result = parser.parseInlineFields("\t test::\t This is the value");

        expect(result).toEqual([{key: "test", content:"This is the value"}]);
    });
    it("finds a single field with one line value, removes trailing brackets", function() {

        let result = parser.parseInlineFields("test:: This is the value)]");

        expect(result).toEqual([{key: "test", content:"This is the value"}]);
    });
    it("finds a single field with one line value, not removing matching brackets", function() {

        let result = parser.parseInlineFields("test:: [[This is the value]]");

        expect(result).toEqual([{key: "test", content:"[[This is the value]]"}]);
    });
    it("finds a single field with one line value, not removing non-matching brackets if not in sequence", function() {

        let result = parser.parseInlineFields("test:: [This is the value]d]d]");

        expect(result).toEqual([{key: "test", content:"[This is the value]d]d"}]);
    });
    it("finds a single field with array value", function() {

        let result = parser.parseInlineFields("test::\n- This is the value");

        expect(result).toEqual([{key: "test", content:["This is the value"]}]);
    });
    it("finds a single field with several array values", function() {

        let result = parser.parseInlineFields("test::\n- This is the value\n- This is another value");

        expect(result).toEqual([{key: "test", content:["This is the value", "This is another value"]}]);
    });
    it("finds a single field with several array values, with separation to next array", function() {

        let result = parser.parseInlineFields("test::\n- This is the value\n- This is another value\nSomething else\n- Some other array");

        expect(result).toEqual([{key: "test", content:["This is the value", "This is another value"]}]);
    });
    it("finds several, mixed-type fields", function() {

        let result = parser.parseInlineFields("test::\n" +
            "- This is the value\n" +
            "- This is another value\n" +
            "Something else\n" +
            "- Some other array\n\n" +
            "test2::test value\n" +
            "test3::test3 value");

        expect(result).toEqual([
            {key: "test", content:["This is the value", "This is another value"]},
            {key: "test2", content:"test value"},
            {key: "test3", content:"test3 value"}
        ]);
    });
});