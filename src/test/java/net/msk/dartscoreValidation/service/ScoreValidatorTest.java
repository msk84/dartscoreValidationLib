package net.msk.dartscoreValidation.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ScoreValidatorTest {

    @Test
    void isValidateThrow() {
        Assertions.assertTrue(ScoreValidator.isValidThrow(0));
        Assertions.assertTrue(ScoreValidator.isValidThrow(1));
        Assertions.assertTrue(ScoreValidator.isValidThrow(18));
        Assertions.assertTrue(ScoreValidator.isValidThrow(21));
        Assertions.assertTrue(ScoreValidator.isValidThrow(22));
        Assertions.assertTrue(ScoreValidator.isValidThrow(25));
        Assertions.assertTrue(ScoreValidator.isValidThrow(36));
        Assertions.assertTrue(ScoreValidator.isValidThrow(39));
        Assertions.assertTrue(ScoreValidator.isValidThrow(40));
        Assertions.assertTrue(ScoreValidator.isValidThrow(50));
        Assertions.assertTrue(ScoreValidator.isValidThrow(60));

        Assertions.assertFalse(ScoreValidator.isValidThrow(-1));
        Assertions.assertFalse(ScoreValidator.isValidThrow(29));
        Assertions.assertFalse(ScoreValidator.isValidThrow(31));
        Assertions.assertFalse(ScoreValidator.isValidThrow(49));
        Assertions.assertFalse(ScoreValidator.isValidThrow(61));
        Assertions.assertFalse(ScoreValidator.isValidThrow(70));
        Assertions.assertFalse(ScoreValidator.isValidThrow(100));
    }

    @Test
    void isValidVisit() {
        Assertions.assertTrue(ScoreValidator.isValidVisit(0,0,0));
        Assertions.assertTrue(ScoreValidator.isValidVisit(0,0,1));
        Assertions.assertTrue(ScoreValidator.isValidVisit(3,15,22));
        Assertions.assertTrue(ScoreValidator.isValidVisit(8,16,25));
        Assertions.assertTrue(ScoreValidator.isValidVisit(22,36,60));
        Assertions.assertTrue(ScoreValidator.isValidVisit(50,50,50));

        Assertions.assertFalse(ScoreValidator.isValidVisit(-1,0,0));
        Assertions.assertFalse(ScoreValidator.isValidVisit(0,70,0));
        Assertions.assertFalse(ScoreValidator.isValidVisit(41,27,29));
        Assertions.assertFalse(ScoreValidator.isValidVisit(100,27,29));
    }

    @Test
    void isValidVisitScore() {
        Assertions.assertTrue(ScoreValidator.isValidVisit(0));
        Assertions.assertTrue(ScoreValidator.isValidVisit(16));
        Assertions.assertTrue(ScoreValidator.isValidVisit(57));
        Assertions.assertTrue(ScoreValidator.isValidVisit(60));
        Assertions.assertTrue(ScoreValidator.isValidVisit(100));
        Assertions.assertTrue(ScoreValidator.isValidVisit(180));

        Assertions.assertFalse(ScoreValidator.isValidVisit(-1));
        Assertions.assertFalse(ScoreValidator.isValidVisit(179));
        Assertions.assertFalse(ScoreValidator.isValidVisit(181));
    }
}