package org.example.lab7.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.lab7.Api.ApiMessage;
import org.example.lab7.Model.Student;
import org.example.lab7.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

 private final UserService userService;



    @GetMapping("/get")
    public ResponseEntity getUser(){
        ArrayList<Student> user=userService.getUser();
        return ResponseEntity.status(200).body(user);
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody Student user , Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiMessage("Student added successfully "));

    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable int id ,@RequestBody @Valid Student user,Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated=userService.updateUser(id,user);
        if (isUpdated){
            return ResponseEntity.status(200).body(new ApiMessage("Student updated"));
        }
        return ResponseEntity.status(400).body(new ApiMessage("Not found id "));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable int id){
        boolean isDeleted = userService.deleteUser(id);
        if (isDeleted){
            return ResponseEntity.status(200).body(new ApiMessage("Deleted"));
        }
        return ResponseEntity.status(400).body("Not found Id");
    }
//change status to graduated
@PutMapping("/change/grad/{id}")
    public ResponseEntity changeGrad(@PathVariable int id ){
        boolean isGrad=userService.changeGrad(id);
        if (isGrad){
            return ResponseEntity.status(200).body(new ApiMessage("change to Graduate"));
        }
    return ResponseEntity.status(400).body("cannot change ");
}

    //change status to training
    @PutMapping("/change/train/{id}")
    public ResponseEntity changeTraining(@PathVariable int id ){
        boolean isTrain=userService.changeTraining(id);
        if (isTrain){
            return ResponseEntity.status(200).body(new ApiMessage("change to training"));
        }
        return ResponseEntity.status(400).body("cannot change ");
    }
    //list of student have absence more than 5 times for example
@GetMapping("/abse/{day}")
public ResponseEntity calAttendance(@PathVariable int day){
        ArrayList<Student> list=userService.calAttendance(day);

        if (list.isEmpty()){
            return ResponseEntity.status(400).body(new ApiMessage("no inforamation found"));
        }
        return ResponseEntity.status(200).body(list);
}
    //list of student finish training and 65 hours..
    @GetMapping("/grad")
    public ResponseEntity gradStudent(){
        ArrayList<Student> list=userService.searchGrad();

        if (list.isEmpty()){
            return ResponseEntity.status(400).body(new ApiMessage("no inforamation found"));
        }
        return ResponseEntity.status(200).body(list);
    }
    //list of student finish 35 hours.
    @GetMapping("/train")
    public ResponseEntity trainStudent(){
        ArrayList<Student> list=userService.searchTraining();

        if (list.isEmpty()){
            return ResponseEntity.status(400).body(new ApiMessage("no inforamation found"));
        }
        return ResponseEntity.status(200).body(list);
    }



    //add subject to student
//    @PutMapping("add_subject/{sup_id}/{std_id}/{sub_id}")
//    public ResponseEntity addSubjet(@PathVariable int sup_id,@PathVariable int std_id,@PathVariable int sub_id ,@Valid @RequestBody Student student,Errors errors){
//        if (errors.hasErrors()){
//            String message=errors.getFieldError().getDefaultMessage();
//            return ResponseEntity.status(400).body(message);
//        }
//        boolean isAdded=userService.addSubject(id,user);
//        if (isAdded){
//            return ResponseEntity.status(200).body(new ApiMessage("Student updated"));
//        }
//        return ResponseEntity.status(400).body(new ApiMessage("Not found id "));
//    }




}
