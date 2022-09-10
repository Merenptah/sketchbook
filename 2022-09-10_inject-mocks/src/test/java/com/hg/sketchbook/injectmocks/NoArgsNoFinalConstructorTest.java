package com.hg.sketchbook.injectmocks;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.when;

@ExtendWith(MockitoExtension.class)
public class NoArgsNoFinalConstructorTest {
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

        // Yes, will stub out non-final fields
        Assertions.assertThat(classUnderTest.greet()).isEqualTo("Hallöle Deutschland.");
    }

    private static class ClassUnderTest {
        private CountryProvider countryProvider;
        private GreetingProvider greetingProvider;

        public ClassUnderTest() {
            this.countryProvider = new CountryProvider();
            this.greetingProvider = new GreetingProvider();
        }

        String greet() {
            return String.format("%s %s.", greetingProvider.provide(), countryProvider.provide());
        }
    }
}
