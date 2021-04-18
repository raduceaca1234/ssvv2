package org.example;

import org.example.domain.Nota;
import org.example.domain.Student;
import org.example.domain.Tema;
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
    Service service2;
    Service service3;
    @Before
    public void before() {
        testBuilder = new TestBuilder();
        service = testBuilder.getService();
        service2 = testBuilder.getServiceAssignment();
        service3 = testBuilder.getServiceGrade();
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

    @Test
    public void test5(){
        Tema tema = testBuilder.getAssignment();

        service2.addTema(tema);

        assertTrue(service2.findTema(tema.getID()).getID()
                .equals(tema.getID()));
    }

    @Test
    public void test6() {
        Tema tema = testBuilder.getFaultyAssignment();
        int count = getAssignmentsCount();
        try {
            service2.addTema(tema);
        } catch (Exception exception) {
            assertTrue(getAssignmentsCount().equals(count));
        }
    }

    @Test
    public void test7() {
//        testAssignmentWithNullId();
//        testAssignmentWithEmptyId();
//        testAssignmentWithEmptyDescription();
//        testAssignmentWithInvalidDeadline();
//        testAssignmentWithInvalidPrimire();
    }

    @Test
    public void test8(){
        Student student = testBuilder.getStudent();

        System.out.println(service3.addStudent(student));
        System.out.println(student.getID());
        assertTrue(service3.findStudent(student.getID()).getID()
                .equals(student.getID()));

        Tema tema = testBuilder.getAssignment();

        service3.addTema(tema);

        assertTrue(service3.findTema(tema.getID()).getID()
                .equals(tema.getID()));

        Nota nota = testBuilder.getGrade();

        service3.addNota(nota, "Good work!");

        assertTrue(service3.findNota(nota.getID()).getID()
                .equals(nota.getID()));
    }

    private void testAssignmentWithNullId() {
        try {
            service2.addTema(testBuilder.getAssignmentWithNullId());
        } catch (Exception exception) {
            assertTrue(getAssignmentsCount().equals(1));
        }
    }

    private void testAssignmentWithEmptyId() {
        try {
            service2.addTema(testBuilder.getAssignmentWithEmptyId());
        } catch (Exception exception) {
            assertTrue(getAssignmentsCount().equals(1));
        }
    }

    private void testAssignmentWithEmptyDescription() {
        try {
            service2.addTema(testBuilder.getAssignmentWithEmptyDescription());
        } catch (Exception exception) {
            assertTrue(getAssignmentsCount().equals(1));
        }
    }

    private void testAssignmentWithInvalidDeadline() {
        try {
            service2.addTema(testBuilder.getAssignmentWithInvalidDeadline());
        } catch (Exception exception) {
            assertTrue(getAssignmentsCount().equals(1));
        }
    }

    private void testAssignmentWithInvalidPrimire() {
        try {
            service2.addTema(testBuilder.getAssignmentWithInvalidPrimire());
        } catch (Exception exception) {
            assertTrue(getAssignmentsCount().equals(1));
        }
    }

    @After
    public void afterTest(){
        //service.deleteStudent(testBuilder.DEFAULT_ID);
        //service3.deleteStudent(testBuilder.DEFAULT_ID);
        //service3.deleteTema(testBuilder.nrTema);
        //service3.deleteNota(testBuilder.id);
    }

    private Integer getStudentsCount() {
        AtomicReference<Integer> count = new AtomicReference<>(0);

        service.getAllStudenti().forEach(stud -> {
            count.getAndSet(count.get() + 1);
        });

        return count.get();
    }

    private Integer getAssignmentsCount() {
        AtomicReference<Integer> count = new AtomicReference<>(0);

        service2.getAllTeme().forEach(stud -> {
            count.getAndSet(count.get() + 1);
        });

        return count.get();
    }

    private Integer getGradesCount() {
        AtomicReference<Integer> count = new AtomicReference<>(0);

        service2.getAllTeme().forEach(stud -> {
            count.getAndSet(count.get() + 1);
        });

        return count.get();
    }

}
