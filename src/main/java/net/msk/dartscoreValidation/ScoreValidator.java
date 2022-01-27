package net.msk.dartscoreValidation;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ScoreValidator {

    private static final Set<Integer> validThrowValues = new HashSet<>();
    private static final Set<Integer> validVisitValues = new HashSet<>();
    private static final Set<Integer> validDoubleValues = new HashSet<>();
    private static final Set<Integer> validTripleValues = new HashSet<>();
    private static final Set<Integer> validFinishValues = new HashSet<>();

    private static boolean initialized = false;

    private static void init() {
        if(!initialized) {
            // Valid triples
            validTripleValues.addAll(IntStream.range(0, 21).map(v -> v * 3).boxed().collect(Collectors.toSet()));

            // Valid doubles
            validDoubleValues.addAll(IntStream.range(1, 21).map(v -> v * 2).boxed().collect(Collectors.toSet()));
            validDoubleValues.add(50);

            // Valid singles
            validThrowValues.addAll(IntStream.range(0, 21).boxed().collect(Collectors.toSet()));
            validThrowValues.add(25);
            validThrowValues.addAll(validDoubleValues);
            validThrowValues.addAll(validTripleValues);

            // Valid visits
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

            // Valid finishes
            // One throw
            validFinishValues.addAll(validDoubleValues);

            // Two throws
            final Set<Integer> twoThrowFinishes = new HashSet<>();
            for(final Integer v : validThrowValues) {
                for(final Integer d : validDoubleValues) {
                    twoThrowFinishes.add(v+d);
                }
            }

            // Three throws
            final Set<Integer> threeThrowFinishes = new HashSet<>();
            for(final Integer v : validThrowValues) {
                for(final Integer s : validThrowValues) {
                    for (final Integer d : validDoubleValues) {
                        threeThrowFinishes.add(v+s+d);
                    }
                }
            }
            validFinishValues.addAll(twoThrowFinishes);
            validFinishValues.addAll(threeThrowFinishes);

            initialized = true;
        }
    }

    public static boolean isValidThrow(final int throwValue) {
        init();
        return validThrowValues.contains(throwValue);
    }

    public static boolean isValidVisit(final int throw1, final int throw2, final int throw3) {
        // Init will be done inside
        return isValidThrow(throw1) &&
                isValidThrow(throw2) &&
                isValidThrow(throw3);
    }

    public static boolean isValidVisit(final int visitScore) {
        init();
        return validVisitValues.contains(visitScore);
    }

    public static boolean isValidFinish(final int highFinishScore) {
        init();
        return validFinishValues.contains(highFinishScore);
    }

    public static boolean isValidHighfinish(final int highFinishScore) {
        if(highFinishScore >= 100) {
            init();
            return validFinishValues.contains(highFinishScore);
        }
        return false;
    }

    public static boolean isValidShortgame(final int numberOfThrows) {
        return numberOfThrows >= 9 && numberOfThrows <= 18;
    }
}
