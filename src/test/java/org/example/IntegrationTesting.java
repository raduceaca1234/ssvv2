package org.example;

import org.example.domain.Nota;
import org.example.domain.Student;
import org.example.domain.Tema;
import org.example.service.Service;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.util.stream.StreamSupport;

import static org.junit.Assert.assertTrue;

public class IntegrationTesting {
    TestBuilder2 testBuilder;
    Service service;

    @Before
    public void before() {
        testBuilder = new TestBuilder2();
        service = testBuilder.getService();
    }

    @Test
    public void addStudent() {
        Student student = testBuilder.getStudent();

        service.addStudent(student);

        assertTrue(service.findStudent(student.getID()).getID()
                .equals(student.getID()));
    }

    @Test
    public void addAssignment() {

        Tema tema = testBuilder.getTema();

        service.addTema(tema);

        assertTrue(service.findTema(tema.getID()).getID()
                .equals(tema.getID()));
    }

    @Test
    public void addNota() {
        Nota nota = testBuilder.getNota();

        try {
            service.addNota(nota, TestBuilder2.DEFAULT_FEEDBACK);
        } catch (Exception exception) {
            assertTrue(StreamSupport.stream(service.getAllNote().spliterator(), false)
                    .count() == 1);
        }
    }


    @Test
    public void testIntegration() {
        Student student = testBuilder.getStudent();
        Tema tema = testBuilder.getTema();
        Nota nota = testBuilder.getNota();

        service.addStudent(student);
        service.addTema(tema);
        service.addNota(nota, TestBuilder2.DEFAULT_FEEDBACK);

        assertTrue(service.findStudent(student.getID()).getID()
                .equals(student.getID()));
        assertTrue(service.findTema(tema.getID()).getID()
                .equals(tema.getID()));
        assertTrue(StreamSupport.stream(service.getAllNote().spliterator(), false)
                .count() == 2);
    }

    @Test
    public void topDownIncremental() {
        Student student = testBuilder.getStudent();
        service.addStudent(student);
        assertTrue(service.findStudent(student.getID()).getID()
                .equals(student.getID()));

        Tema tema = testBuilder.getTema();
        service.addTema(tema);
        assertTrue(service.findTema(tema.getID()).getID()
                .equals(tema.getID()));

        Nota nota = testBuilder.getNota();
        service.addNota(nota, TestBuilder2.DEFAULT_FEEDBACK);
        assertTrue(StreamSupport.stream(service.getAllNote().spliterator(), false)
                .count() == 2);
    }

    @After
    public void afterTest(){
        service.deleteNota(TestBuilder2.DEFAULT_NOTA_ID);
        service.deleteStudent(testBuilder.DEFAULT_STUDENT_ID);
        service.deleteTema(TestBuilder2.DEFAULT_TEMA_ID);
    }
}