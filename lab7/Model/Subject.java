package org.example.lab7.Model;

import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Subject {
    @NotNull(message = "id cannot be empty")
    private Integer sub_id;
    @NotEmpty(message = "name cannot be empty")
    private String sub_name;
    @NotNull(message = "hours cannot be empty")
    private Integer sub_hours;
    @NotNull(message = "capacity cannot be empty")
    private Integer capacity;
    @NotEmpty (message = "object cannot be empty")
    private Instructor instructor;
private Student student;
//    @NotEmpty  (message = "status cannot be empty")
//    @Pattern(regexp = "(done|not done)" ,message = "the status should be done or not done cannot be empty")
    @AssertFalse
    private boolean full;

}
