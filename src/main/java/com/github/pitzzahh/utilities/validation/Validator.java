package com.github.pitzzahh.utilities.validation;

import java.util.List;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.function.Function;
import java.util.function.Predicate;
import com.github.pitzzahh.utilities.classes.enums.Gender;

/**
 * Interface used for various input validation.
 * It extends the {@code Function<T, R>} interface.
 * <p>T - the String to be tested for validation.</p>
 * <p>R - the result of the validation, either true or false.</p>
 */
public interface Validator extends Predicate<String> {

    /**
     * Checks if an ID is valid.
     * Minimum of 6 characters, maximum of 11 characters
     * @return a {@code Validator} object.
     */
    static Validator isIdValid() {
        return id -> Pattern.compile("^\\d{6,9}$").matcher(String.valueOf(id)).matches();
    }

    /**
     * Checks if age is valid.
     * @throws NumberFormatException if the {@code String} representation of age is not an {@code Integer}.
     * @return a {@code Validator} object.
     */
    static Validator isAgeValid() throws NumberFormatException {
        return age -> (Integer.parseInt(age) > 0 && Integer.parseInt(age) <= 130);
    }

    /**
     * Checks if a gender is valid.
     * There is an enum called {@code Gender} that contains the list of genders.
     * @see Gender
     * @return a {@code Validator} object.
     */
    static Validator isGenderValid() {
        return gender -> Arrays.stream(Gender.values()).anyMatch(e -> e.toString().equals(gender.toUpperCase()));
    }

    /**
     * Checks if an input is a letter, or a character. Uppercase or Lowercase.
     * @return a {@code Validator} object.
     */
    static Validator isLetter() {
        return input -> Pattern.compile("^[a-z|A-Z]$").matcher(input).matches();
    }

    /**
     * Checks if an input is yes, Uppercase Y or Lowercase y.
     * @return a {@code Validator} object.
     */
    static Validator isYes() {
        return input -> Pattern.compile("^[Y|y]$").matcher(input).matches();
    }

    /**
     * Checks if an input is no, Uppercase N or Lowercase n.
     * @return a {@code Validator} object.
     */
    static Validator isNo() {
        return input -> Pattern.compile("^[N|n]$").matcher(input).matches();
    }

    /**
     * Checks if an input is a whole number.
     * @return a {@code Validator} object.
     */
    static Validator isWholeNumber() {
        return input -> Pattern.compile("^\\d+$").matcher(input).find();
    }

    /**
     * Checks if an input is a decimal number.
     * @return a {@code Validator} object.
     */
    static Validator isDecimalNumber() {
        return input -> Pattern.compile("^\\d+\\.\\d+$").matcher(input).find();
    }

    /**
     * Checks if an input is a valid birthdate.
     * <p>Valid birthdate: </p>
     * <p>YYYY-MM-dd</p>
     * <p>example: 2002-08-24  or  20002-8-24  or  2000-1-1  or  20002-01-1</p>
     * @throws IllegalArgumentException if a month or day is invalid.
     * @return a {@code Validator} object.
     */
    static Validator isBirthDateValid() throws IllegalArgumentException {
        return input -> {
            try {
                List<String> birthDate = Arrays.stream(input.split("-")).toList();
                int day = Integer.parseInt(birthDate.get(2));
                int month = Integer.parseInt(birthDate.get(1));
                if (month <= 0 || month > 12) throw new IllegalArgumentException("Invalid month: " + month);
                if (day <= 0 || day > 30) throw new IllegalArgumentException("Invalid day: " + day);
            } catch (RuntimeException ignored) {
                return false;
            }
            return Pattern.compile("^\\d{4}-\\d{1,2}-\\d{1,2}$").matcher(input).matches();
        };
    }

    /**
     * Password must contain:
     * <p> - Any number,</p>
     * <p> - lower-case letters,</p>
     * <p> - upper-case letters,</p>
     * <p> - any special characters,</p>
     * <p> - no space,</p>
     * <p> - minimum of 6 characters.</p>
     * @return {@code validation.InputValidation} object.
     */
    static Validator isPasswordValid() {
        return input -> Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}$").matcher(input).matches();
    }

    /**
     * Test to validation if both are valid.
     * @param otherValidation the other {@code Validator} object.
     * @return {@code validation.InputValidation} object.
     */
    default Validator and(Validator otherValidation) {
        return s -> this.test(s) == (true) ? otherValidation.test(s) : this.test(s);
    }

    /**
     * Test to validation if either one of them are valid.
     * @param otherValidation the other {@code Validator} object.
     * @return {@code validation.InputValidation} object.
     */
    default Validator or(Validator otherValidation) {
        return s -> this.test(s) == (false) ? otherValidation.test(s) : this.test(s);
    }
}
