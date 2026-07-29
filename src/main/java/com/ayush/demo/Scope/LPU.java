package com.ayush.demo.Scope;

import com.ayush.demo.StudentServer.Entity.Student;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class LPU {
    LPU(){
        System.out.println("LPU global rank 1");
    }
    public void admission(Student student){
        System.out.println("admission");
    }
    public void exams(Student student){
        System.out.println("exams");
    }
    public void prep(Student student){
        System.out.println("Prep classes");
    }
}
