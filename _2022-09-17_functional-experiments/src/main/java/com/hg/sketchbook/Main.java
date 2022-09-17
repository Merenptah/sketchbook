package com.hg.sketchbook;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        var initialList = List.of(
                Map.of("key", 1, "value", "value1"),
                Map.of("key", 2, "value", "value2"),
                Map.of("key", 3, "value", "value3"));

        var newList = initialList
                .stream()
                .map(replaceConditionally(
                        el -> (Integer) el.get("key") == 2,
                        el -> Map.of("key", el.get("key"), "value", "replacedValue")))
                .toList();

        var otherNewList = replaceConditionally(
                initialList,
                el -> (Integer) el.get("key") == 2,
                el -> Map.of("key", el.get("key"), "value", "replacedValue"));

        System.out.println(initialList);
        System.out.println(newList);
        System.out.println(otherNewList);
    }

    /**
     * First try, interesting but somehow confusing
     */
    private static <T> Function<T, T> replaceConditionally(Predicate<T> ifMatches,
                                                           Function<T, T> replaceWith) {
        return el -> ifMatches.test(el) ? replaceWith.apply(el) : el;
    }

    /**
     * Much better, this is the equivalent of a Kotlin extension function and adds the missing
     * functionality in Java to replace/update an element of a list without changing the list.
     *
     * We could think of other replaceWith functions, the one used here is useful if you need
     * the original element to perform the update. Yes, you can abuse this to actually change
     * the original element, if the element is mutable (which of course it should not be).
     *
     * This is an example of a copy-on-write primitive. In Java we could put this into a
     * class like ListUtils or Lists.
     */
    private static <T> List<T> replaceConditionally(List<T> list, Predicate<T> ifMatches,
                                                           Function<T, T> replaceWith) {
        return list.stream()
                .map(el -> ifMatches.test(el) ? replaceWith.apply(el) : el)
                .toList();
    }
}