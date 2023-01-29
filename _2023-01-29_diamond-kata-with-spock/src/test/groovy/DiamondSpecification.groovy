import com.hg.sketchbock.spockdiamond.Diamond
import spock.genesis.Gen
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll
import spock.util.matcher.HamcrestSupport

class DiamondSpecification extends Specification {
    @Shared char aChar = 'A'
    @Shared char zChar = 'Z'
    @Shared Range<Character> validRange = aChar..zChar

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
}