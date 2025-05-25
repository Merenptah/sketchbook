import net.javacrumbs.jsonunit.assertj.JsonAssertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;

public class JsonUnitTest {

    @Test
    void equality_with_ignoring_paths() {
        assertThatJson("{\"fields\":[" +
                "{\"key\":1, \"name\":\"AA\"}," +
                "{\"key\":2, \"name\":\"AB\"}," +
                "{\"key\":3, \"name\":\"AC\"}" +
                "]}")
                .whenIgnoringPaths("$.fields[?(@.name=='AA')].key")
                .isEqualTo("{\"fields\":[" +
                        "{\"key\":2, \"name\":\"AA\"}," +
                        "{\"key\":2, \"name\":\"AB\"}," +
                        "{\"key\":3, \"name\":\"AC\"}" +
                        "]}");
    }

    @Test
    void equality_with_simple_array_filter() {
        assertThatJson("{\"fields\":[" +
                "{\"key\":1, \"name\":\"AA\"}," +
                "{\"key\":2, \"name\":\"AB\"}," +
                "{\"key\":3, \"name\":\"AC\"}" +
                "]}", json -> json.inPath("fields[0].name").isEqualTo("AA"));
    }

    @Test
    void equality_with_subfield_array_filter() {
        assertThatJson("{\"fields\":[" +
                "{\"key\":1, \"name\":\"AA\"}," +
                "{\"key\":2, \"name\":\"AB\"}," +
                "{\"key\":3, \"name\":\"AC\"}" +
                "]}", json -> json.inPath("fields[?(@.key == 1)].name").isEqualTo(List.of("AA")));
    }

    @Test
    void static_multiple_assertions() {
        assertThatJson("{\"fields\":[" +
                        "{\"key\":1, \"name\":\"AA\"}," +
                        "{\"key\":2, \"name\":\"AB\"}," +
                        "{\"key\":3, \"name\":\"AC\"}" +
                        "]}",
                json -> json.inPath("fields[?(@.key == 1)].name").isEqualTo(List.of("AA")),
                json -> json.inPath("fields[?(@.key == 2)].name").isEqualTo(List.of("AB")));
    }

    @Test
    void dynamic_multiple_assertions_by_input() {
        List<JsonAssertions.JsonAssertionCallback> assertions = Stream.of(new Matches("1", "AA"),
                        new Matches("2", "AB"))
                .map(this::callback)
                .toList();

        assertThatJson("{\"fields\":[" +
                        "{\"key\":1, \"name\":\"AA\"}," +
                        "{\"key\":2, \"name\":\"AB\"}," +
                        "{\"key\":3, \"name\":\"AC\"}" +
                        "]}",
                assertions.toArray(new JsonAssertions.JsonAssertionCallback[]{}));
    }


    private JsonAssertions.JsonAssertionCallback callback(Matches matches) {
        return json -> json.inPath("fields[?(@.key == " + matches.key + ")].name")
                .isEqualTo(List.of(matches.value));
    }

    private record Matches(String key, String value) {
    }

}
