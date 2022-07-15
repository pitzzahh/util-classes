package com.github.pitzzahh.utilities.classes;

import lombok.*;
import java.time.Period;
import java.time.LocalDate;
import com.github.pitzzahh.utilities.classes.enums.Gender;

@Data
@Getter
@Builder
@ToString
public class Person {

    private String firstName;
    private String lastName;
    private byte age;
    private Gender gender;
    private String address;
    private LocalDate birthDate;

    public byte getAge() {
        return (byte) Period.between(birthDate, LocalDate.now()).getYears();
    }

}
