package net.msk.dartscoreValidation.service;

import net.msk.dartscoreValidation.model.Throw;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ThrowValidator {

    private static final Set<Integer> validThrowValues = new HashSet<>();
    private static boolean initialized;

    private static void init() {
        if(!initialized) {
            validThrowValues.addAll(IntStream.range(0, 21).boxed().collect(Collectors.toSet()));
            validThrowValues.addAll(IntStream.range(0, 21).map(v -> v * 2).boxed().collect(Collectors.toSet()));
            validThrowValues.addAll(IntStream.range(0, 21).map(v -> v * 3).boxed().collect(Collectors.toSet()));
            validThrowValues.add(25);
            validThrowValues.add(50);
        }
    }

    public static boolean isValidateThrow(final Throw throwValue) {
        init();
        return validThrowValues.contains(throwValue.score());
    }
}
