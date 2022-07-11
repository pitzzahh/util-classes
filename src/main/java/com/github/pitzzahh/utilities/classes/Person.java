package com.github.pitzzahh.utilities.classes;

import lombok.*;

import java.time.LocalDate;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private LocalDate birthDate;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;
    private byte age;

}
