import com.hg.sketchbock.spockdiamond.Diamond
import spock.genesis.Gen
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

class DiamondSpecification extends Specification {
    @Shared char aChar = 'A'
    @Shared char zChar = 'Z'
    @Shared Range<Character> validRange = aChar..zChar
    @Shared char bChar = 'B'
    @Shared Range<Character> testRange = bChar..zChar

    @Subject Diamond diamond = new Diamond()

    @Unroll("rejects '#c'")
    def "rejects characters outside the range A-Z"() {
        when:
        diamond.apply(c)

        then:
        thrown IllegalArgumentException

        where:
        c << Gen.character
                .filter { !validRange.contains(it) }
                .take(50)
    }

    def "The diamond of A is 'A'"() {
        expect:
        diamond.apply(aChar) == ["A"]
    }

    @Unroll
    def "diamond('#c') is square"() {
        given:
        def result = diamond.apply(c)

        expect:
        result.every {
            it.length() == result.size()
        }

        where:
        c << testRange
    }

    @Unroll("diamond(#c) should have #expectedHeight rows")
    def "a diamond's height is determined by the character argument"() {
        given:
        def result = diamond.apply(c)

        expect:
        result.size() == expectedHeight

        where:
        c << testRange
        expectedHeight = ((c - aChar) * 2) + 1
    }
}