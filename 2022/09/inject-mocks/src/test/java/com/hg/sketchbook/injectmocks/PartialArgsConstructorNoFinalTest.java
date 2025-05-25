package com.hg.sketchbook.injectmocks;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.when;

@ExtendWith(MockitoExtension.class)
public class PartialArgsConstructorNoFinalTest {
    @Mock(strictness = Mock.Strictness.LENIENT)
    private CountryProvider countryProvider;

    @Mock(strictness = Mock.Strictness.LENIENT)
    private GreetingProvider greetingProvider;

    @InjectMocks
    private ClassUnderTest classUnderTest;

    @Test
    void returns_mixed_values() {
        when(greetingProvider.provide()).thenReturn("Hallöle");
        when(countryProvider.provide()).thenReturn("Deutschland");

        // Ignoring the stub, using the constructor
        Assertions.assertThat(classUnderTest.greet()).isEqualTo("Hello Deutschland.");
    }

    private static class ClassUnderTest {
        private CountryProvider countryProvider;
        private GreetingProvider greetingProvider;

        public ClassUnderTest(CountryProvider countryProvider) {
            this.countryProvider = countryProvider;
            this.greetingProvider = new GreetingProvider();
        }

        String greet() {
            return String.format("%s %s.", greetingProvider.provide(), countryProvider.provide());
        }
    }
}
