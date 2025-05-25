package com.hg.sketchbook.injectmocks;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.when;

@ExtendWith(MockitoExtension.class)
public class NoArgsConstructorTest {
    @Mock(strictness = Mock.Strictness.LENIENT)
    private CountryProvider countryProvider;

    @Mock(strictness = Mock.Strictness.LENIENT)
    private GreetingProvider greetingProvider;

    @InjectMocks
    private ClassUnderTest classUnderTest;

    @Test
    void returns_original_values() {
        when(greetingProvider.provide()).thenReturn("Hallöle");
        when(countryProvider.provide()).thenReturn("Deutschland");

        // Nope, will not stub out final fields
        Assertions.assertThat(classUnderTest.greet()).isEqualTo("Hello Germany.");
    }

    private static class ClassUnderTest {
        private final CountryProvider countryProvider;
        private final GreetingProvider greetingProvider;

        public ClassUnderTest() {
            this.countryProvider = new CountryProvider();
            this.greetingProvider = new GreetingProvider();
        }

        String greet() {
            return String.format("%s %s.", greetingProvider.provide(), countryProvider.provide());
        }
    }
}
