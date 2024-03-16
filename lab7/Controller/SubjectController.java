package org.example.lab7.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.lab7.Api.ApiMessage;
import org.example.lab7.Model.Instructor;
import org.example.lab7.Model.Student;
import org.example.lab7.Model.Subject;
import org.example.lab7.Service.SubjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/subject")
@RequiredArgsConstructor
public class SubjectController {
    private final SubjectService subjectService;


    @GetMapping("/get")
    public ResponseEntity getSubject(){
        ArrayList<Subject> sub=subjectService.getSubjects();
        return ResponseEntity.status(200).body(sub);
    }

    @PostMapping("/add")
    public ResponseEntity addSubject(@Valid @RequestBody Subject sub, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);}
        subjectService.addSubject(sub);
        return ResponseEntity.status(200).body(new ApiMessage("Subject added successfully "));

    }

   @PutMapping("/update/{sub_id}")
    public ResponseEntity updateSubject(@PathVariable int sub_id ,@RequestBody @Valid Subject subject,Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated=subjectService.updateSubject(sub_id,subject);
        if (isUpdated){
            return ResponseEntity.status(200).body(new ApiMessage("Subject updated"));
        }
        return ResponseEntity.status(400).body(new ApiMessage("Not found id "));
    }

    @DeleteMapping("/delete/{sub_id}")
    public ResponseEntity deleteSubject(@PathVariable int sub_id){
        boolean isDeleted = subjectService.deleteSubject(sub_id);
        if (isDeleted){
            return ResponseEntity.status(200).body(new ApiMessage("Deleted"));
        }
        return ResponseEntity.status(400).body("Not found Id");
    }

    @GetMapping("/search/full_subject")
    public ResponseEntity retireList(){

        ArrayList<Subject> list=subjectService.fullSubjects();
        if (list.isEmpty()){
            return ResponseEntity.status(400).body("no information found");
        }
        return  ResponseEntity.status(400).body(list);
    }


//    @PutMapping("student/add_subject/{std_id}/{subj_id}")
//    public ResponseEntity addsubjectStudent(@PathVariable int std_id,@PathVariable int subj_id ,@Valid @RequestBody Student student ,Errors errors) {
//        if (errors.hasErrors()) {
//            String message = errors.getFieldError().getDefaultMessage();
//            return ResponseEntity.status(400).body(message);
//        }
//        boolean isAdded = subjectService.addSubjectToStudent(std_id, subj_id, student);
//        if (isAdded) {
//            return ResponseEntity.status(200).body(new ApiMessage("Subject added to student successfully "));
//        }
//  return ResponseEntity.status(400).body(new ApiMessage(" fail to add"));
//    }

}
