package net.msk.dartscoreValidation.service;

import net.msk.dartscoreValidation.ScoreValidator;
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

    @Test
    void isValidFinishScore() {
        Assertions.assertTrue(ScoreValidator.isValidFinish(2));
        Assertions.assertTrue(ScoreValidator.isValidFinish(8));
        Assertions.assertTrue(ScoreValidator.isValidFinish(16));
        Assertions.assertTrue(ScoreValidator.isValidFinish(40));
        Assertions.assertTrue(ScoreValidator.isValidFinish(120));
        Assertions.assertTrue(ScoreValidator.isValidFinish(170));

        Assertions.assertFalse(ScoreValidator.isValidFinish(-1));
        Assertions.assertFalse(ScoreValidator.isValidFinish(0));
        Assertions.assertFalse(ScoreValidator.isValidFinish(1));
        Assertions.assertFalse(ScoreValidator.isValidFinish(163));
        Assertions.assertFalse(ScoreValidator.isValidFinish(165));
        Assertions.assertFalse(ScoreValidator.isValidFinish(169));
        Assertions.assertFalse(ScoreValidator.isValidFinish(171));
        Assertions.assertFalse(ScoreValidator.isValidFinish(180));
        Assertions.assertFalse(ScoreValidator.isValidFinish(181));
    }

    @Test
    void isValidHighfinishScore() {
        Assertions.assertTrue(ScoreValidator.isValidHighfinish(100));
        Assertions.assertTrue(ScoreValidator.isValidHighfinish(120));
        Assertions.assertTrue(ScoreValidator.isValidHighfinish(140));
        Assertions.assertTrue(ScoreValidator.isValidHighfinish(167));
        Assertions.assertTrue(ScoreValidator.isValidHighfinish(170));

        Assertions.assertFalse(ScoreValidator.isValidHighfinish(-1));
        Assertions.assertFalse(ScoreValidator.isValidHighfinish(0));
        Assertions.assertFalse(ScoreValidator.isValidHighfinish(1));
        Assertions.assertFalse(ScoreValidator.isValidHighfinish(20));
        Assertions.assertFalse(ScoreValidator.isValidHighfinish(40));
        Assertions.assertFalse(ScoreValidator.isValidHighfinish(80));
        Assertions.assertFalse(ScoreValidator.isValidHighfinish(99));
        Assertions.assertFalse(ScoreValidator.isValidHighfinish(163));
        Assertions.assertFalse(ScoreValidator.isValidHighfinish(165));
        Assertions.assertFalse(ScoreValidator.isValidHighfinish(180));
    }

    @Test
    void isValidShortgame() {
        Assertions.assertTrue(ScoreValidator.isValidShortgame(9));
        Assertions.assertTrue(ScoreValidator.isValidShortgame(17));
        Assertions.assertTrue(ScoreValidator.isValidShortgame(18));

        Assertions.assertFalse(ScoreValidator.isValidShortgame(-1));
        Assertions.assertFalse(ScoreValidator.isValidShortgame(0));
        Assertions.assertFalse(ScoreValidator.isValidShortgame(8));
        Assertions.assertFalse(ScoreValidator.isValidShortgame(19));
    }
}