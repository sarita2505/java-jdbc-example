package com.spring.utils;

import com.spring.model.Student;
import com.spring.repository.impl.StudentDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
        StudentDaoImpl dao=context.getBean("StudentDaoImpl",StudentDaoImpl.class);
        Student student=new Student();
        student.setName("aloka");
        student.setPresent("yes");
        dao.insert(student);
        System.out.println(dao.findAll());
    }
}
