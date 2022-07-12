package com.github.pitzzahh.utilities.classes;

import com.github.pitzzahh.utilities.classes.enums.Gender;
import lombok.*;
import java.time.Period;
import java.time.LocalDate;

@Data
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
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
