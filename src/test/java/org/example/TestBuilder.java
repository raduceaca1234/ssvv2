package org.example;


import org.example.domain.Student;
import org.example.domain.Tema;
import org.example.repository.StudentFileRepository;
import org.example.repository.StudentXMLRepo;
import org.example.repository.TemaXMLRepo;
import org.example.service.Service;
import org.example.validation.StudentValidator;
import org.example.validation.TemaValidator;

public class TestBuilder {
    //student
    public static String DEFAULT_ID = "420";
    public static String DEFAULT_NAME = "nume";
    public static Integer DEFAULT_GROUP = 932;
    public static String DEFAULT_EMAIL = "racheta@as_manca_o_ciorba.gov";
    public static String nrTema = "3";
    public static String descriere = "Lorem ipsum";
    public static int deadline = 4;
    public static int primire = 1;
    public static String EMPTY_STRING = "";
    public static String NULL_STRING = null;
    public static String empty_description = null;
    public static int invalid_deadline = 0;
    public static int invalid_primire = 0;

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

    public static String DEFAULT_TEMA_XML_FILE = "testData/testTemaXMLFile.xml";
    public static String DEFAULT_TEMA_FILE = "testData/testTemaFile.txt";

    public Student getStudent() {
        return new Student(DEFAULT_ID, DEFAULT_NAME, DEFAULT_GROUP, DEFAULT_EMAIL);
    }

    public Tema getAssignment() { return new Tema(nrTema, descriere, deadline, primire);}

    public Tema getFaultyAssignment() {
        return new Tema(null, "", 0, 0);
    }

    public TemaValidator getAssignmentValidator() {
        return new TemaValidator();

    }

    public TemaXMLRepo getAssignmentXMLRepo() {
        return new TemaXMLRepo(DEFAULT_TEMA_XML_FILE);
    }

    public Student getFaultyStudent() {
        return new Student(null, null, -1, null);
    }

    public StudentValidator getStudentValidator() {
        return new StudentValidator();
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
}
