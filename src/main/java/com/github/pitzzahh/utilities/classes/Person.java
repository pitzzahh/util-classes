package com.github.pitzzahh.utilities.classes;

import lombok.*;
import java.time.Period;
import java.time.LocalDate;
import com.github.pitzzahh.utilities.classes.enums.Gender;

@Data
@Getter
@Builder
@ToString
/**
 * Template class used to create a person object.
 */
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;
    private String address;
    private LocalDate birthDate;

    public int getAge() {
        return this.age != 0 ? Period.between(birthDate, LocalDate.now()).getYears() : this.age;
    }

}
