package com.ayush.demo.StudentServer.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateStudentResponseForUpdateDTO {
    int id;
    String name;
    int age;
    String department;
    String message = "Updated";
}
