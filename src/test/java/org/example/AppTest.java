package org.example;

import org.example.domain.Student;
import org.example.service.Service;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AppTest {

//    @org.junit.Test
//    public void test1(){
//        assertTrue(true);
//    }
//
//    @org.junit.Test
//    public void test2(){
//        assertFalse(false);
//    }

    TestBuilder testBuilder = new TestBuilder();
    Service service;
    @Before
    public void before() {
        testBuilder = new TestBuilder();
        service = testBuilder.getService();
    }

    @Test
    public void test1() {
        Student student = testBuilder.getStudent();

        service.addStudent(student);

        assertTrue(service.findStudent(student.getID()).getID()
                .equals(student.getID()));
    }

    @Test
    public void test2() {
        Student student = testBuilder.getStudent();
        Student studentClone = testBuilder.getStudent();

        service.addStudent(student);
        service.addStudent(studentClone);



        assertTrue(getStudentsCount().equals(1));
    }

    @Test
    public void test3() {
        Student student = testBuilder.getFaultyStudent();

        try {
            service.addStudent(student);
        } catch (Exception exception) {
            assertTrue(getStudentsCount().equals(0));
        }
    }



    @After
    public void afterTest(){
        service.deleteStudent(testBuilder.DEFAULT_ID);
    }

    private Integer getStudentsCount() {
        AtomicReference<Integer> count = new AtomicReference<>(0);

        service.getAllStudenti().forEach(stud -> {
            count.getAndSet(count.get() + 1);
        });

        return count.get();
    }

}
