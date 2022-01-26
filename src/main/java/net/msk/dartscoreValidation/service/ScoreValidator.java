package net.msk.dartscoreValidation.service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ScoreValidator {

    private static final Set<Integer> validThrowValues = new HashSet<>();
    private static final Set<Integer> validVisitValues = new HashSet<>();
    private static boolean initialized;

    private static void init() {
        if(!initialized) {
            validThrowValues.addAll(IntStream.range(0, 21).boxed().collect(Collectors.toSet()));
            validThrowValues.addAll(IntStream.range(0, 21).map(v -> v * 2).boxed().collect(Collectors.toSet()));
            validThrowValues.addAll(IntStream.range(0, 21).map(v -> v * 3).boxed().collect(Collectors.toSet()));
            validThrowValues.add(25);
            validThrowValues.add(50);

            validVisitValues.addAll(validThrowValues);

            for(final Integer v : validThrowValues) {
                for(final Integer n : validThrowValues) {
                    validVisitValues.add(v+n);
                }
            }

            final Set<Integer> validVisitValuesCopy = new HashSet<>(validVisitValues);
            for(final Integer v : validVisitValuesCopy) {
                for(final Integer n : validThrowValues) {
                    validVisitValues.add(v+n);
                }
            }
        }
    }

    public static boolean isValidThrow(final int throwValue) {
        init();
        return validThrowValues.contains(throwValue);
    }

    public static boolean isValidVisit(final int throw1, final int throw2, final int throw3) {
        return isValidThrow(throw1) &&
                isValidThrow(throw2) &&
                isValidThrow(throw3);
    }
}
