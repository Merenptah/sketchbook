package com.hg.sketchbook.injectmocks;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.when;

@ExtendWith(MockitoExtension.class)
public class AllArgsConstructorTest {
    @Mock
    private CountryProvider countryProvider;

    @Mock
    private GreetingProvider greetingProvider;

    @InjectMocks
    private ClassUnderTest classUnderTest;

    @Test
    void returns_stubbed_values() {
        when(greetingProvider.provide()).thenReturn("Hallöle");
        when(countryProvider.provide()).thenReturn("Deutschland");

        Assertions.assertThat(classUnderTest.greet()).isEqualTo("Hallöle Deutschland.");
    }

    private static class ClassUnderTest {
        private final CountryProvider countryProvider;
        private final GreetingProvider greetingProvider;

        public ClassUnderTest(CountryProvider countryProvider, GreetingProvider greetingProvider) {
            this.countryProvider = countryProvider;
            this.greetingProvider = greetingProvider;
        }

        String greet() {
            return String.format("%s %s.", greetingProvider.provide(), countryProvider.provide());
        }
    }
}
