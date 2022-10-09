package io.github.pitzzahh.util.utilities.validation;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.function.Predicate;

import io.github.pitzzahh.util.utilities.classes.enums.Gender;

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
     * Checks if an input is a {@code String}, uppercase or lowercase, or both.
     * @return a {@code Validator} object.
     */
    static Validator isString() {
        return input -> Pattern.compile("^[A-z]+$").matcher(input).find();
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
        return input -> Pattern.compile("^(\\d+\\.\\d+|\\.\\d+|0\\.\\d+)$").matcher(input).find();
    }

    /**
     * Checks if an input is a valid birthdate.
     * <p>Valid birthdate: </p>
     * <p>YYYY-MM-dd</p>
     * <p>example: 2002-08-24  or  2002-8-24  or  2002-1-1  or  2002-01-1  or  2002-01-1</p>
     * <p>Valid range of birthday: 1850 - 2029</p>
     * <p>Pattern:</p>
     * <p>(1[8|9][5-9]\d|20[0-2]\d|19[\d]\d|)   year: between 1850-2029</p>
     * <p>([1-9]{1}|0[1-9]|1[0-2]|)             month: between 1-12</p>
     * <p>(\d{1}|0[\d]|[1-2]\d|[1-3][0-1])      day: between 1-31</p>
     * @return a {@code Validator} object.
     */
    static Validator isBirthDateValid() {
        return input -> Pattern.compile("^(1[8|9][5-9]\\d|20[0-2]\\d|19\\d\\d|)-([1-9]|0[1-9]|1[0-2])-(\\d|0\\d|[1-2]\\d|[1-3][0-1])$").matcher(input).matches();
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

}
