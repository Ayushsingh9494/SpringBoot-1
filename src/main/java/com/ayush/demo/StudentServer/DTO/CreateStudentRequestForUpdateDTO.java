package com.ayush.demo.StudentServer.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateStudentRequestForUpdateDTO {
    String name;
    @NotNull
    int age;
}
