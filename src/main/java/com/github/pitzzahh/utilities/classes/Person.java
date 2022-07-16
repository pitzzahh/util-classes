package com.github.pitzzahh.utilities.classes;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.time.Period;
import java.time.LocalDate;
import lombok.NoArgsConstructor;
import com.github.pitzzahh.utilities.classes.enums.Gender;

/**
 * Template class used to create a person object.
 * The age field is automatically calculated when an object is not null.
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Person {

    private String firstName;
    private String lastName;
    private Integer age;
    private Gender gender;
    private String address;
    private LocalDate birthDate;

    /**
     * Constructor for making a {@code Person} object.
     * There is no need to provide the age argument because it is automatically calculated.
     * @param firstName the first name of a person.
     * @param lastName the last name of a person.
     * @param gender the gender of a person using {@code Gender} enum.
     * @param address the address of a person.
     * @param birthDate the birthdate of a person in {@code LocalDate}
     * @see Gender
     * @see LocalDate
     */
    public Person(String firstName, String lastName, Gender gender, String address, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.address = address;
        this.birthDate = birthDate;
    }

    /**
     * Person builder.
     * @return a {@code PersonBuilder} object.
     */
    public static PersonBuilder builder() {
        return new PersonBuilder();
    }

    /**
     * Gets the exact age of the person/
     * @return the calculated age based on the current year.
     */
    public Integer getAge() {
        return this.age != null ? Period.between(birthDate, LocalDate.now()).getYears() : 0;
    }

    /**
     * Class used for builder pattern.
     */
    public static class PersonBuilder {
        private String firstName;
        private String lastName;
        private Integer age;
        private Gender gender;
        private String address;
        private LocalDate birthDate;

        /**
         * Empty {@code PersonBuilder}
         */
        PersonBuilder() {
        }

        /**
         * Sets the firstName of the current {@code Person} object.
         * @param firstName the first name to be set.
         * @return {@code PersonBuilder} object.
         */
        public PersonBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        /**
         * Sets the lastName of the current {@code Person} object.
         * @param lastName the last name to be set.
         * @return {@code PersonBuilder} object.
         */
        public PersonBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        /**
         * Sets the gender of the current {@code Person} object.
         * @param gender the gender to be set.
         * @see Gender
         * @return {@code PersonBuilder} object.
         */
        public PersonBuilder gender(Gender gender) {
            this.gender = gender;
            return this;
        }

        /**
         * Sets the address of the current {@code Person} object.
         * @param address the address to be set.
         * @return {@code PersonBuilder} object.
         */
        public PersonBuilder address(String address) {
            this.address = address;
            return this;
        }

        /**
         * Sets the birthDate of the current {@code Person} object.
         * @param birthDate the birthDate to be set.
         * @see LocalDate
         * @return {@code PersonBuilder} object.
         */
        public PersonBuilder birthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        /**
         * Builds the {@code PersonBuilder} object to a {@code Person} object.
         * @return a {@code Person} object.
         */
        public Person build() {
            return new Person(firstName, lastName, gender, address, birthDate);
        }

        /**
         * Prints the {@code Person} object as a {@code String} representation.
         * @return {@code String} representation of the current {@code Person} object.
         */
        public String toString() {
            return "Person.PersonBuilder(firstName=" + this.firstName + ", lastName=" + this.lastName + ", age=" + this.age + ", gender=" + this.gender + ", address=" + this.address + ", birthDate=" + this.birthDate + ")";
        }
    }
}
