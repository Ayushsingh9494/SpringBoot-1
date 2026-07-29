package com.ayush.demo.StudentServer.Controller;

import com.ayush.demo.StudentServer.DTO.CreateStudentRequestDTO;
import com.ayush.demo.StudentServer.DTO.CreateStudentRequestForUpdateDTO;
import com.ayush.demo.StudentServer.DTO.CreateStudentResponseDTO;
import com.ayush.demo.StudentServer.DTO.CreateStudentResponseForUpdateDTO;
import com.ayush.demo.StudentServer.Entity.Student;
import com.ayush.demo.StudentServer.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<CreateStudentResponseDTO> storeStudent(@RequestBody CreateStudentRequestDTO createStudentRequestDTO) {
        CreateStudentResponseDTO result = studentService.studentValidate(createStudentRequestDTO);

        if(result == null)
        {
            return ResponseEntity.status(400).body(result);
        }
        return  ResponseEntity.status(201).body(result);
    }
    @GetMapping("/getStudent/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable int id){

        Student student = studentService.getStudentById(id);

        if(student == null){
            return ResponseEntity.status(404).body("Student not found");
        }

        return ResponseEntity.ok(student);
    }

    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable int id, @RequestBody CreateStudentRequestForUpdateDTO createStudentRequestForUpdateDTO){
        CreateStudentResponseForUpdateDTO result = studentService.studentUpdate(id, createStudentRequestForUpdateDTO);
        if(result == null)
        {
            return ResponseEntity.status(400).body("Invalid input");
        }
        return ResponseEntity.status(200).body(result);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable int id){
        Student student = studentService.deleteStudent(id);
        if(student == null) {
            return ResponseEntity.status(400).body("Invalid input");
        }
        return ResponseEntity.status(200).body("Student deleted");
    }
}
