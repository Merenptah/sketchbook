import com.hg.sketchbook.spocknested.Request
import spock.lang.Shared
import spock.lang.Specification

class NestedRequestSpecification extends Specification {
    @Shared
    def request = new Request("firstField", "secondField", new Request.Nested("nestedFirstField"))

    def "allows setting the field '#desc'"() {
        given:
        var request = new Request(
                "firstField",
                "secondField",
                new Request.Nested("nestedFirstField"))
        when:
        fieldSetter(request, value)

        then:
        fieldGetter(request) == value

        where:
        desc | fieldSetter | fieldGetter | value;
        "first field" | { Request req, String val -> req.firstField = val } | { Request req -> req.firstField } | "dummy";
        "second field" | { Request req, String val -> req.secondField = val } | { Request req -> req.secondField } | "dummy";
        "nested first field" | { Request req, String val -> req.nested.nestedFirstField = val } | { Request req -> req.nested.nestedFirstField } | "dummy";
        "nested" | { Request req, Request.Nested val -> req.nested = val } | { Request req -> req.nested } | new Request.Nested("dummy");
    }

    def "allows setting the field '#desc' with accessors"() {
        when:
        fieldAccessor = value

        then:
        fieldAccessor == value

        where:
        desc | fieldAccessor  | value;
        "first field" | request.firstField | "dummy";
        "second field" | request.secondField | "dummy";
        "nested first field" | request.nested.nestedFirstField | "dummy";
    }
}