package net.msk.dartscoreValidation.service;

import net.msk.dartscoreValidation.model.Throw;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ThrowValidatorTest {

    @Test
    void isValidateThrow() {
        Assertions.assertTrue(ThrowValidator.isValidateThrow(new Throw(0)));
        Assertions.assertTrue(ThrowValidator.isValidateThrow(new Throw(1)));
        Assertions.assertTrue(ThrowValidator.isValidateThrow(new Throw(18)));
        Assertions.assertTrue(ThrowValidator.isValidateThrow(new Throw(21)));
        Assertions.assertTrue(ThrowValidator.isValidateThrow(new Throw(22)));
        Assertions.assertTrue(ThrowValidator.isValidateThrow(new Throw(25)));
        Assertions.assertTrue(ThrowValidator.isValidateThrow(new Throw(36)));
        Assertions.assertTrue(ThrowValidator.isValidateThrow(new Throw(39)));
        Assertions.assertTrue(ThrowValidator.isValidateThrow(new Throw(40)));
        Assertions.assertTrue(ThrowValidator.isValidateThrow(new Throw(50)));
        Assertions.assertTrue(ThrowValidator.isValidateThrow(new Throw(60)));

        Assertions.assertFalse(ThrowValidator.isValidateThrow(new Throw(-1)));
        Assertions.assertFalse(ThrowValidator.isValidateThrow(new Throw(29)));
        Assertions.assertFalse(ThrowValidator.isValidateThrow(new Throw(31)));
        Assertions.assertFalse(ThrowValidator.isValidateThrow(new Throw(49)));
        Assertions.assertFalse(ThrowValidator.isValidateThrow(new Throw(61)));
        Assertions.assertFalse(ThrowValidator.isValidateThrow(new Throw(70)));
        Assertions.assertFalse(ThrowValidator.isValidateThrow(new Throw(100)));
    }
}