import spock.lang.Specification

class TestSpecification extends Specification {
    def "one plus one should equal two"() {
        expect:
        1 + 1 == 2
    }

    def "Should be able to remove from list"() {
        given:
        def list = [1, 2, 3, 4]

        when:
        list.remove(0)

        then:
        list == [2, 3, 4]
    }

    def "Should get an index out of bounds when removing a non-existent item"() {
        given:
        def list = [1, 2, 3, 4]

        when:
        list.remove(20)

        then:
        thrown(IndexOutOfBoundsException)
        list.size() == 4
    }

    def "numbers to the power of two"(int a, int b, int c) {
        expect:
        a**b == c

        where:
        a | b | c
        1 | 2 | 1
        2 | 2 | 4
        3 | 2 | 9
    }
}
