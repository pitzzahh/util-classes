package com.github.pitzzahh.utilities.classes;

import java.time.Month;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import com.github.pitzzahh.utilities.classes.enums.Gender;

class PersonTest {

    @Test
    void canCreateEmptyPerson() {
        Person person = new Person(
                "Peter John",
                "Arao",
                Gender.MALE,
                "Buyoan",
                LocalDate.of(2002, Month.AUGUST, 24)
        );
        Person person1 = Person.builder()
                        .firstName("Peter John")
                        .lastName("Arao")
                        .gender(Gender.MALE)
                        .address("Buyoan")
                        .birthDate(LocalDate.of(2002, Month.AUGUST, 24)).build();

        Person person2 = Person.builder().build();
        System.out.println("person = " + person);
        System.out.println("person1 = " + person1);
        System.out.println("person2 = " + person2);
    }
}