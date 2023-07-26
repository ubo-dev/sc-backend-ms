package com.ubo.scmicroservices.userservice.model.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "user_details")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User extends BaseEntity
{
     /*
    * @NotNull: Checks if a given field is not null but allows empty values & zero elements inside collections.
      @NotEmpty: Checks if a given field is not null and its size/length is greater than zero.
      @NotBlank: Checks if a given field is not null and trimmed length is greater than zero.
    * */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstName")
    private String name;

    @Column(name = "lastName")
    private String lastName;

    @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
    @Column(name = "phoneNumber")
    private String phoneNumber;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Past(message = "Enter valid date.")
    private Date birthDate;

    @Column(name = "email")
    @Email(message = "Enter a valid email.")
    private String email;

}
