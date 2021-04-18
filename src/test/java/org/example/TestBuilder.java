package org.example;


import org.example.domain.Nota;
import org.example.domain.Student;
import org.example.domain.Tema;
import org.example.repository.NotaXMLRepo;
import org.example.repository.StudentFileRepository;
import org.example.repository.StudentXMLRepo;
import org.example.repository.TemaXMLRepo;
import org.example.service.Service;
import org.example.validation.NotaValidator;
import org.example.validation.StudentValidator;
import org.example.validation.TemaValidator;
import sun.util.resources.LocaleData;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class TestBuilder {
    //student
    public static String DEFAULT_ID = "430";
    public static String DEFAULT_NAME = "nume";
    public static Integer DEFAULT_GROUP = 932;
    public static String DEFAULT_EMAIL = "aamjs@yahoo.com";
    public static String nrTema = "4";
    public static String descriere = "Lorem ipsum";
    public static int deadline = 10;
    public static int primire = 1;
    public static String EMPTY_STRING = "";
    public static String NULL_STRING = null;
    public static String empty_description = null;
    public static int invalid_deadline = 0;
    public static int invalid_primire = 0;
    public static String id = "1";
    public static String id_student = "430";
    public static String id_tema = "4";
    public static double nota = 10;
    public static LocalDate data =  LocalDate.of(2021, 2, 23);

    public Tema getAssignmentWithEmptyId() {
        return new Tema(EMPTY_STRING, descriere, deadline, primire);
    }

    public Tema getAssignmentWithNullId() {
        return new Tema(NULL_STRING, descriere, deadline, primire);
    }

    public Tema getAssignmentWithEmptyDescription() {
        return new Tema(nrTema, empty_description, deadline, primire);
    }

    public Tema getAssignmentWithInvalidDeadline() {
        return new Tema(nrTema, descriere, invalid_deadline, primire);
    }

    public Tema getAssignmentWithInvalidPrimire() {
        return new Tema(nrTema, descriere, deadline, invalid_primire);
    }

    //files
    public static String DEFAULT_STUDENT_XML_FILE = "testData/testStudentXMLFile.xml";
    public static String DEFAULT_STUDENT_FILE = "testData/testStudentFile.txt";
    public static String DEFAULT_GRADE_FILE = "testData/testGradeFile.txt";

    public static String DEFAULT_TEMA_XML_FILE = "testData/testTemaXMLFile.xml";
    public static String DEFAULT_TEMA_FILE = "testData/testTemaFile.txt";
    public static String DEFAULT_GRADE_XML_FILE = "testData/testNotaXMLFile.xml";

    public Student getStudent() {
        return new Student(DEFAULT_ID, DEFAULT_NAME, DEFAULT_GROUP, DEFAULT_EMAIL);
    }

    public Tema getAssignment() { return new Tema(nrTema, descriere, deadline, primire);}

    public Nota getGrade() { return new Nota(id, id_student, id_tema, nota, data);}

    public Tema getFaultyAssignment() {
        return new Tema(null, "", 0, 0);
    }

    public TemaValidator getAssignmentValidator() {
        return new TemaValidator();

    }

    public TemaXMLRepo getAssignmentXMLRepo() {
        return new TemaXMLRepo(DEFAULT_TEMA_XML_FILE);
    }

    public NotaXMLRepo getGradeXMLRepo() {
        return new NotaXMLRepo(DEFAULT_GRADE_XML_FILE);
    }

    public Student getFaultyStudent() {
        return new Student(null, null, -1, null);
    }

    public StudentValidator getStudentValidator() {
        return new StudentValidator();
    }

    public NotaValidator getNotaValidator() {
        return new NotaValidator(getStudentXMLRepo(), getAssignmentXMLRepo());
    }


    public StudentXMLRepo getStudentXMLRepo() {
        return new StudentXMLRepo(DEFAULT_STUDENT_XML_FILE);
    }


    public StudentFileRepository getStudentFileRepo() {
        return new StudentFileRepository(DEFAULT_STUDENT_FILE);
    }


    public Service getService() {
        return new Service(getStudentXMLRepo(), getStudentValidator(), null,
                null,null,null);
    }

    public Service getServiceAssignment() {
        return new Service(null, null, getAssignmentXMLRepo(), getAssignmentValidator(), null,
                null);
    }

    public Service getServiceGrade() {
        return new Service(getStudentXMLRepo(), getStudentValidator(),  getAssignmentXMLRepo(), getAssignmentValidator(), getGradeXMLRepo(), getNotaValidator());
    }
}
