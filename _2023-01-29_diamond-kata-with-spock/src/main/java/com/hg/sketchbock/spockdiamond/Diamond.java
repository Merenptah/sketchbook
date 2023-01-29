package com.hg.sketchbock.spockdiamond;

import java.util.Collections;
import java.util.List;

public class Diamond {
    public List<String> apply(Character c) {
        if (c < 'A' || c > 'Z') {
            throw new IllegalArgumentException(c + " is outside the valid range A..Z");
        }
        return Collections.singletonList("A");
    }
}
