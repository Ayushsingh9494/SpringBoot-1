package com.ayush.demo.StudentServer.Service;

import com.ayush.demo.StudentServer.DTO.CreateStudentRequestDTO;
import com.ayush.demo.StudentServer.DTO.CreateStudentRequestForUpdateDTO;
import com.ayush.demo.StudentServer.DTO.CreateStudentResponseDTO;
import com.ayush.demo.StudentServer.DTO.CreateStudentResponseForUpdateDTO;
import com.ayush.demo.StudentServer.Repository.StudentRepository;
import com.ayush.demo.StudentServer.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class StudentService {
    StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    public CreateStudentResponseForUpdateDTO studentUpdate(
            int id,
            CreateStudentRequestForUpdateDTO createStudentRequestForUpdateDTO) {

        Student student = studentRepository.findById(id).orElse(null);

        if (student == null) {
            return null;
        }
        student.setName(createStudentRequestForUpdateDTO.getName());
        student.setAge(createStudentRequestForUpdateDTO.getAge());
        student.setUpdatedAt(LocalDateTime.now());
        studentRepository.save(student);
        return mapToUpdateResponse(student);

    }

    private CreateStudentResponseForUpdateDTO mapToUpdateResponse(Student student) {
        CreateStudentResponseForUpdateDTO dto =
                new CreateStudentResponseForUpdateDTO();

        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setAge(student.getAge());
        dto.setDepartment(student.getDepartment());
        dto.setMessage("Updated");
        return dto;
    }

    public Student deleteStudent(int id) {
        Student result = studentRepository.findById(id).orElse(null);
        if(result == null) {
            return null;
        }
        studentRepository.delete(result);
        return result;
    }

    public CreateStudentResponseDTO studentValidate(CreateStudentRequestDTO createStudentRequestDTO) {
        Student student = mapToStudent(createStudentRequestDTO);
        studentRepository.save(student);
        return mapToResponseDTO(student);
    }


    public Student mapToStudent(CreateStudentRequestDTO createStudentRequestDTO){
        Student student = new Student();
        student.setName(createStudentRequestDTO.getName());
        student.setAge(createStudentRequestDTO.getAge());
        student.setDepartment(createStudentRequestDTO.getDepartment());
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());
        return student;
    }

    private CreateStudentResponseDTO mapToResponseDTO(Student student) {
        CreateStudentResponseDTO createStudentResponseDTO = new CreateStudentResponseDTO();
        createStudentResponseDTO.setId(student.getId());
        createStudentResponseDTO.setName(student.getName());
        createStudentResponseDTO.setAge(student.getAge());
        createStudentResponseDTO.setDepartment(student.getDepartment());
        return createStudentResponseDTO;
    }
}


