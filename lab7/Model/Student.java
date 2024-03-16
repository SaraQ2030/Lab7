package org.example.lab7.Model;

import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Student {
    @NotNull(message = "id cannot be empty")
private Integer id;
    @NotEmpty (message = "name cannot be empty")
private String name;
    @NotNull(message = "age cannot be empty")
private Integer age;
    @NotNull(message = "level cannot be empty")
private Integer level;

 @NotNull(message = "phone number cannot be empty")
 @Pattern(regexp = "^05\\d{8}$"  , message = "Number should start with 05xxxxxxxx and contain 10 numbers")
private String phoneNumber;
@NotNull(message = "hours cannot be empty")
private Integer hours;
@AssertFalse
private boolean training;
@AssertFalse
private boolean graduated;

   private Integer attendance;

}
