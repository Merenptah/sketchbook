package com.hg.sketchbock.spockdiamond;

import java.util.List;

public class Diamond {
    public List<String> apply(Character c) {
        throw new IllegalArgumentException(c + " is outside the valid range A..Z");
    }
}
