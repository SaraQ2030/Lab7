package org.example.lab7.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class Instructor {
    @NotNull(message = "id cannot be empty")
    private Integer id;
    @NotEmpty(message = "name cannot be empty")
    private String name;
    @NotNull(message = "age cannot be empty")
    private Integer age;
    @NotNull(message = "salary cannot be empty")
    private Integer salary;
//  @JsonFormat(pattern ="yyyy")
//    @PastOrPresent
//   private LocalDate hireDate;
@Pattern(regexp = "^05\\d{8}$"  , message = "Number should start with 05xxxxxxxx and contain 10 numbers")
private String phoneNumber;
    @NotNull(message = "number of classes cannot be empty")
    private Integer num_class;
    private Integer exper_year;

    @AssertFalse
    private boolean retired;
    @Pattern(regexp = "(instructor|supervisor)" , message = "the status should be instructor Or supervisor")
    private String status;
    @NotNull
    private Integer workYear;
}
