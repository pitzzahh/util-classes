package com.github.pitzzahh.utilities.validation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.function.Executable;
import com.github.pitzzahh.utilities.classes.enums.Gender;

class ValidatorTest {

    @Test
    void shouldPassIfIdIsValid() {
        // given
        var id = "122021";
        // when
        var result = Validator.isIdValid().test(id);
        // then
        assertTrue(result);
    }

    @Test
    void shouldPassIfIdIsInvalid() {
        // given
        var id = "123";
        // when
        var result = Validator.isIdValid().test(id);
        // then
        assertFalse(result);
    }

    @Test
    void shouldPassIfIdIsStringAndInvalid() {
        // given
        var id = "pizza";
        // when
        var result = Validator.isIdValid().test(id);
        // then
        assertFalse(result);
    }

    @Test
    void shouldPassIfAgeIsValid() {
        // given
        var age = "12";
        // when
        var result = Validator.isAgeValid().test(age);
        // then
        assertTrue(result);
    }

    @Test
    void shouldPassIfAgeIsZeroAndInvalid() {
        // given
        var age = "0";
        // when
        var result = Validator.isAgeValid().test(age);
        // then
        assertFalse(result);
    }

    @Test
    void shouldPassIfAgeIsAStringAndInvalidAndThrowsNumberFormatException() {
        // given
        var age = "pizza";
        // then
        assertThrows(NumberFormatException.class, new Executable() {
            @Override
            public void execute() throws NumberFormatException {
                var result = Validator.isAgeValid().test(age);
                assertFalse(result);
            }
        });
    }

    @Test
    void shouldPassIfGenderIsValidMale() {
        // given
        var gender = Gender.MALE.toString();
        // when
        var result = Validator.isGenderValid().test(gender);
        // then
        assertTrue(result);
    }

    @Test
    void shouldPassIfGenderIsValidFemale() {
        // given
        var gender = Gender.FEMALE;
        // when
        var result = Validator.isGenderValid().test(gender.name());
        // then
        assertTrue(result);
    }

    @Test
    void shouldPassIfGenderIsValidLGBT() {
        // given
        var gender = Gender.LGBT;
        // when
        var result = Validator.isGenderValid().test(gender.name());
        // then
        assertTrue(result);
    }

    @Test
    void shouldPassIfGenderIsValidAndPreferedNotToSay() {
        // given
        var gender = Gender.PREFER_NOT_TO_SAY;
        // when
        var result = Validator.isGenderValid().test(gender.name());
        // then
        assertTrue(result);
    }

    @Test
    void shouldPassIfGenderIsInvalidAndThrowsIllegalArgumentException() {
        // when
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws IllegalArgumentException {
                // given
                var gender = Gender.valueOf("other gender");
                // then
                var result = Validator.isGenderValid().test(gender.name());
                // when
                assertFalse(result);
            }
        });
    }

    @Test
    void shouldPassIfStringIsASingleCharacterInTheAlphabetInLoweCase() {
        // given
        var letters = "abcdefghijklmnopqrstuvwxyz";
        // when
        for (int i = 0; i < letters.length(); i++) {
            // then
            var result = Validator.isLetter().test(String.valueOf(letters.charAt(i)));
            assertTrue(result);
        }
    }

    @Test
    void shouldPassIfStringIsASingleCharacterInTheAlphabetInUpperCase() {
        // given
        var letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        // when
        for (int i = 0; i < letters.length(); i++) {
            // then
            var result = Validator.isLetter().test(String.valueOf(letters.charAt(i)));
            assertTrue(result);
        }
    }

    @Test
    void shouldPassIfStringNotASingleCharacterInTheAlphabet() {
        // given
        var letters = "!@#$%^&*()_+-=:;\"\'<,>./?`~";
        // when
        for (int i = 0; i < letters.length(); i++) {
            // then
            var result = Validator.isLetter().test(String.valueOf(letters.charAt(i)));
            assertFalse(result);
        }
    }

    @Test
    void shouldPassIfStringIsUpperCaseOrLowerCaseY() {
        // given
        var letters = "Yy";
        // when
        for (int i = 0; i < letters.length(); i++) {
            // then
            var result = Validator.isYes().test(String.valueOf(letters.charAt(i)));
            assertTrue(result);
        }
    }

    @Test
    void shouldPassIfStringIsNotAnUpperCaseOrLowerCaseY() {
        // given
        var letters = "Pp";
        // when
        for (int i = 0; i < letters.length(); i++) {
            // then
            var result = Validator.isYes().test(String.valueOf(letters.charAt(i)));
            assertFalse(result);
        }
    }

    @Test
    void shouldPassIfStringIsUpperCaseOrLowerCaseN() {
        // given
        var letters = "Nn";
        // when
        for (int i = 0; i < letters.length(); i++) {
            // then
            var result = Validator.isNo().test(String.valueOf(letters.charAt(i)));
            assertTrue(result);
        }
    }

    @Test
    void shouldPassIfStringIsNotAnUpperCaseOrLowerCaseN() {
        // given
        var letters = "Aa";
        // when
        for (int i = 0; i < letters.length(); i++) {
            // then
            var result = Validator.isNo().test(String.valueOf(letters.charAt(i)));
            assertFalse(result);
        }
    }

    @Test
    void shouldPassIfNumberIsAWholeNumber() {
        // given
        var number = "123";
        // when
        var result = Validator.isWholeNumber().test(number);
        // then
        assertTrue(result);
    }

    @Test
    void shouldPassIfNumberIsNotAWholeNumber() {
        // given
        var number = "123.123";
        // when
        var result = Validator.isWholeNumber().test(number);
        // then
        assertFalse(result);
    }

    @Test
    void shouldPassIfNumberIsADecimalNumber() {
        // given
        var number = "123.123";
        // when
        var result = Validator.isDecimalNumber().test(number);
        // then
        assertTrue(result);
    }

    @Test
    void shouldPassIfNumberIsNotADecimalNumber() {
        // given
        var number = "123";
        // when
        var result = Validator.isDecimalNumber().test(number);
        // then
        assertFalse(result);
    }

    @Test
    void shouldPassIfBirthDateIsValid() {
        // given
        var year = "2002";
        var month = "8";
        var day = "24";
        // when
        var result = Validator.isBirthDateValid().test(year + "-" + month + "-" + day);
        // then
        assertTrue(result);
    }

    @Test
    void shouldPassIfBirthDateIsInValidBecauseYearIsOnlyThreeCharacters() {
        // given
        var year = "123";
        var month = "8";
        var day = "24";
        // when
        var result = Validator.isBirthDateValid().test(year + "-" + month + "-" + day);
        // then
        assertFalse(result);
    }

    @Test
    void shouldPassIfBirthDateIsInValidBecauseYearIsInvalid() {
        // given
        var year = "1010";
        var month = "8";
        var day = "24";
        // when
        var result = Validator.isBirthDateValid().test(year + "-" + month + "-" + day);
        // then
        assertFalse(result);
    }

    @Test
    void shouldPassIfBirthDateIsInValidBecauseMonthIsInvalid() {
        // given
        var year = "2002";
        var month = "0";
        var day = "24";
        // when
        var result = Validator.isBirthDateValid().test(year + "-" + month + "-" + day);
        // then
        assertFalse(result);
    }

    @Test
    void shouldPassIfBirthDateIsInValidBecauseDayIsInvalid() {
        // given
        var year = "2002";
        var month = "8";
        var day = "32";
        // when
        var result = Validator.isBirthDateValid().test(year + "-" + month + "-" + day);
        // then
        assertFalse(result);
    }

    @Test
    void shouldPassIfPasswordIsValid() {
        // given
        var password = "!Password@123";
        // when
        var result = Validator.isPasswordValid().test(password);
        // then
        assertTrue(result);
    }

    @Test
    void shouldPassIfPasswordIsInvalidBecauseNoSpecialCharacter() {
        // given
        var password = "Password123";
        // when
        var result = Validator.isPasswordValid().test(password);
        // then
        assertFalse(result);
    }

    @Test
    void shouldPassIfPasswordIsInvalidBecauseNoUpperCaseLetter() {
        // given
        var password = "!password@123";
        // when
        var result = Validator.isPasswordValid().test(password);
        // then
        assertFalse(result);
    }

    @Test
    void shouldPassIfPasswordIsInvalidBecauseNoNumber() {
        // given
        var password = "!Password@";
        // when
        var result = Validator.isPasswordValid().test(password);
        // then
        assertFalse(result);
    }

    @Test
    void shouldPassIfBothValidationIsTrue() {
        // given
        var yes = "Y";
        // when
        var result = Validator.isLetter().and(Validator.isYes()).test(yes);
        // then
        assertTrue(result);
    }

    @Test
    void shouldPassIfAtleastOneValidationIsTrue() {
        // given
        var yes = "K";
        // when
        var result = Validator.isLetter().or(Validator.isNo()).test(yes);
        // then
        assertTrue(result);
    }

    @Test
    void shouldPassIfBothValidationIsFalse() {
        // given
        var yes = "KN";
        // when
        var result = Validator.isLetter().or(Validator.isNo()).test(yes);
        // then
        assertFalse(result);
    }
}