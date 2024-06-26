package com.agan.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
// ***
// default active (included) by @Data next annotations;
// @Getter, @Setter, @toStrong, @EqualsAndHashCode, @RequiredArgsConstructor
// ***
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

//    @NotNull(message = "Must be not null")
//    @Size(min = 3)
    private String firstName;

//    @NotNull(message = "Must be not null")
//    @Size(min = 3)
    private String lastName;

    @NotBlank(message = "Must be not blank")
    private String schoolName;

    @Email(message = "Email should be valid")
    private String email;

    @Min(value = 18, message = "Cannot be younger than 18 years old")
    private int age;

    @Pattern(regexp = "[0-9\\s]{12}")
    private String phoneNumber;


}
