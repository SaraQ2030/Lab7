package org.example.lab7.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.lab7.Api.ApiMessage;
import org.example.lab7.Model.Instructor;
import org.example.lab7.Model.Student;
import org.example.lab7.Service.InstructorService;
import org.example.lab7.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/inst")
public class InstructorController {

    private final InstructorService userService;


    @GetMapping("/get")
    public ResponseEntity getUser() {
        ArrayList<Instructor> user = userService.getUser();
        return ResponseEntity.status(200).body(user);
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody Instructor user, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiMessage("Instructor added successfully "));

    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable int id, @RequestBody @Valid Instructor user, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = userService.updateUser(id, user);
        if (isUpdated) {
            return ResponseEntity.status(200).body(new ApiMessage("Instructor updated"));
        }
        return ResponseEntity.status(400).body(new ApiMessage("Not found id "));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable int id) {
        boolean isDeleted = userService.deleteUser(id);
        if (isDeleted) {
            return ResponseEntity.status(200).body(new ApiMessage("Deleted"));
        }
        return ResponseEntity.status(400).body("Not found Id");
    }
    //بحث عدد الكلاسات
    @GetMapping("/search/class/{clas}")
    public ResponseEntity searchClass(@PathVariable int clas){
        ArrayList<Instructor> list=userService.searchNumClass(clas);
        if (list.isEmpty()){
            return ResponseEntity.status(400).body("No information found");
        }
        return ResponseEntity.status(200).body(list);
    }

    //اضافة supervisor كلاس لانستركتر محدد
@PutMapping("/add/class/{id_super}/{id_inst}")
    public ResponseEntity addClass(@PathVariable int id_super,@PathVariable int id_inst){
        boolean isAdd=userService.addClass(id_super,id_inst);
        if (isAdd){

            return ResponseEntity.status(200).body(new ApiMessage("Add class to instructor"));
        }
    return ResponseEntity.status(400).body("cannot add class");
    }

    //بحث عدد سنوات الخبرة
@GetMapping("/search/year/{exp}")
    public ResponseEntity searchYear(@PathVariable int exp){
        ArrayList<Instructor> list=userService.searchExperYear(exp);
        if (list.isEmpty()){
            return ResponseEntity.status(400).body("not found information");
        }
        return ResponseEntity.status(200).body(list);
}

//تعديل حالة الانستركتور الى سوبرفايزر
    @PutMapping("/status/{id_super}/{id_inst}")
    public ResponseEntity changeStatus(@PathVariable int id_super ,@PathVariable int id_inst){
        boolean isChange=userService.chngeStatus(id_super,id_inst);
        if (isChange){
            return ResponseEntity.status(200).body(new ApiMessage("Change successfully"));
        }
        return ResponseEntity.status(400).body(new ApiMessage("Cannot changed"));
    }

    //search salary
    @GetMapping("/search/salary/{sal}")
    public ResponseEntity searchSalary(@PathVariable int sal){
        ArrayList<Instructor> list=userService.searchSalary(sal);
        if (list.isEmpty()){
            return ResponseEntity.status(400).body(new ApiMessage("no information found"));
        }
        return ResponseEntity.status(200).body(list);
    }

    //set retire
    @PutMapping("/retire/{id}")
    public ResponseEntity changeRetire(@PathVariable int id ){
        boolean isRetire=userService.changeRetire(id);
        if (isRetire){
            return ResponseEntity.status(200).body(new ApiMessage("Change successfully"));
        }return ResponseEntity.status(400).body("no information found");
    }
//list retire
    @GetMapping("/search/retired")
    public ResponseEntity retireList(){
        ArrayList<Instructor> list=userService.retirList();
        if (list.isEmpty()){
            return ResponseEntity.status(400).body("no information found");
        }
        return  ResponseEntity.status(400).body(list);
    }

}

