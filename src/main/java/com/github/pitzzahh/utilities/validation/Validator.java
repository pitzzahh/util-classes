package com.github.pitzzahh.utilities.validation;

import java.util.List;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.function.Function;
import com.github.pitzzahh.utilities.classes.Gender;

public interface Validator extends Function<String, Boolean> {

    static Validator isIdValid() {
        return id -> Pattern.compile("^\\d{6}$").matcher(String.valueOf(id)).matches();
    }

    static Validator isAgeValid() {
        return age -> (Integer.parseInt(age) > 0 && Integer.parseInt(age) < 128);
    }

    static Validator isGenderValid() {
        return gender -> Arrays.stream(Gender.values()).anyMatch(e -> e.toString().equals(gender));
    }

    static Validator isLetter() {
        return input -> Pattern.compile("^[a-z|A-Z]$").matcher(input).matches();
    }

    static Validator isYes() {
        return input -> Pattern.compile("^[Y|y]$").matcher(input).matches();
    }

    static Validator isNo() {
        return input -> Pattern.compile("^[N|n]$").matcher(input).matches();
    }

    static Validator isWholeNumber() {
        return input -> Pattern.compile("^*\\d$").matcher(input).find();
    }

    static Validator isDecimalNumber() {
        return input -> Pattern.compile("^\\d+\\.\\d+$").matcher(input).find();
    }

    static Validator isBirthDateValid() {
        return input -> {
            List<String> birthDate = Arrays.stream(input.split("-")).toList();
            int day = Integer.parseInt(birthDate.get(2));
            int month = Integer.parseInt(birthDate.get(1));

            if (day <= 0 || day > 30) throw new IllegalStateException("Invalid day: " + day);
            if (month <= 0 || month > 12) throw new IllegalStateException("Invalid month: " + month);

            return Pattern.compile("^\\d{4}-\\d{1,2}-\\d{2}$").matcher(input).matches();
        };
    }

    /**
     * Password must contain:
     * Any number,
     * lower-case letters,
     * upper-case letters,
     * any special characters,
     * no space,
     * minimum of 6 characters.
     * @return {@code validation.InputValidation} object.
     */
    static Validator isPasswordValid() {
        return input -> Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}$").matcher(input).matches();
    }

    default Validator and(Validator otherValidation) {
        return s -> this.apply(s).equals(true) ? otherValidation.apply(s) : this.apply(s);
    }

    default Validator or(Validator otherValidation) {
        return s -> this.apply(s).equals(false) ? otherValidation.apply(s) : this.apply(s);
    }
}
