package com.tranhieu.restapichinhnguyendong.controller;


import com.tranhieu.restapichinhnguyendong.model.Student;
import com.tranhieu.restapichinhnguyendong.response.ResponseMessage;
import com.tranhieu.restapichinhnguyendong.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("student")
public class StudentController {
   @Autowired
   private IStudentService studentService;

    @PostMapping
    public ResponseEntity<?> createStudent(@RequestBody Student student){
        if(student.getName().trim().isEmpty()){
            return new ResponseEntity<>(new ResponseMessage("The name is required"),HttpStatus.OK);
        }
        studentService.save(student);
        return new ResponseEntity<>(new ResponseMessage("Create student success!"),HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<?> showListStudent(){
        List<Student> students=studentService.findAll();
        if(students.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(students,HttpStatus.OK);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<?> updateStudent(@PathVariable Long id,@RequestBody Student student){
        Optional<Student> student1 = studentService.findById(id);
        if(!student1.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if(student.getName().trim().isEmpty()){
            return new ResponseEntity<>(new ResponseMessage("the name is required"),HttpStatus.OK);
        }
        student1.get().setName(student.getName());
        studentService.save(student1.get());
        return new ResponseEntity<>(new ResponseMessage("Update is successed"),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> deatailsStudent(@PathVariable Long id){
        Optional<Student> student= studentService.findById(id);
        if(!student.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id){
        Optional<Student> student= studentService.findById(id);
        if(!student.isPresent()){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        studentService.delete(student.get().getId());
        return new ResponseEntity<>(new ResponseMessage("Delete Success"),HttpStatus.OK);
    }


}
