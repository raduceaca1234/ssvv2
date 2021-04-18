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

public class TestBuilder2 {
    //student
    public static String DEFAULT_STUDENT_ID = "420";
    public static String DEFAULT_NAME = "nume";
    public static Integer DEFAULT_GROUP = 932;
    public static String DEFAULT_EMAIL = "racheta@as_manca_o_ciorba.gov";
    public static String EMPTY_STRING = "";
    public static String NULL_STRING = null;

    //tema
    public static String DEFAULT_TEMA_ID = "69";
    public static String DEFAULT_DESCRIERE = "Nice work to be done";
    public static int DEFAULT_DEADLINE = 1;
    public static int DEFAULT_PRIMIRE = 10;

    //nota
    public static String DEFAULT_NOTA_ID = "69420";
    public static Double DEFAULT_NOTA = 10D;
    public static LocalDate DEFAULT_DATA = LocalDate.now();

    public static String DEFAULT_FEEDBACK = "Nice work guys";

    //files
    public static String DEFAULT_STUDENT_XML_FILE = "testData/testStudentXMLFile.xml";
    public static String DEFAULT_TEMA_XML_FILE = "testData/testTemaXMLFile.xml";
    public static String DEFAULT_NOTA_XML_FILE = "testData/testNotaXMLFile.xml";
    public static String DEFAULT_STUDENT_FILE = "testData/testStudentFile.txt";

    public Student getStudent() {
        return new Student(DEFAULT_STUDENT_ID, DEFAULT_NAME, DEFAULT_GROUP, DEFAULT_EMAIL);
    }

    public Student getStudentWithEmptyId() {
        return new Student(EMPTY_STRING, DEFAULT_NAME, DEFAULT_GROUP, DEFAULT_EMAIL);
    }

    public Student getStudentWithNullId() {
        return new Student(NULL_STRING, DEFAULT_NAME, DEFAULT_GROUP, DEFAULT_EMAIL);
    }

    public Student getStudentWithNegativeGroup() {
        return new Student(DEFAULT_STUDENT_ID, DEFAULT_NAME, -1, DEFAULT_EMAIL);
    }

    public Student getStudentWithEmptyName() {
        return new Student(DEFAULT_STUDENT_ID, EMPTY_STRING, DEFAULT_GROUP, DEFAULT_EMAIL);
    }
    public Student getStudentWithNullName() {
        return new Student(DEFAULT_STUDENT_ID, NULL_STRING, DEFAULT_GROUP, DEFAULT_EMAIL);
    }

    public Student getStudentWithEmptyEmail() {
        return new Student(DEFAULT_STUDENT_ID, DEFAULT_NAME, DEFAULT_GROUP, EMPTY_STRING);
    }
    public Student getStudentWithNullEmail() {
        return new Student(DEFAULT_STUDENT_ID, DEFAULT_NAME, DEFAULT_GROUP, NULL_STRING);
    }

    public Tema getTema() {
        return new Tema(DEFAULT_TEMA_ID, DEFAULT_DESCRIERE, DEFAULT_DEADLINE, DEFAULT_PRIMIRE);
    }

    public Nota getNota() {
        return new Nota(DEFAULT_NOTA_ID, DEFAULT_STUDENT_ID, DEFAULT_TEMA_ID, DEFAULT_NOTA, DEFAULT_DATA);
    }

    public StudentValidator getStudentValidator() {
        return new StudentValidator();
    }

    public TemaValidator getTemaValidator() {
        return new TemaValidator();
    }

    public NotaValidator getNotaValidator(StudentXMLRepo studentXMLRepo, TemaXMLRepo temaXMLRepo) {
        return new NotaValidator(studentXMLRepo, temaXMLRepo);
    }

    public StudentXMLRepo getStudentXMLRepo() {
        return new StudentXMLRepo(DEFAULT_STUDENT_XML_FILE);
    }

    public TemaXMLRepo getTemaXMLRepo() {
        return new TemaXMLRepo(DEFAULT_TEMA_XML_FILE);
    }
    public NotaXMLRepo getNotaXMLRepo() {
        return new NotaXMLRepo(DEFAULT_NOTA_XML_FILE);
    }

    public StudentFileRepository getStudentFileRepo() {
        return new StudentFileRepository(DEFAULT_STUDENT_FILE);
    }

    public Service getService() {
        StudentXMLRepo studentXMLRepo = getStudentXMLRepo();
        TemaXMLRepo temaXMLRepo = getTemaXMLRepo();
        return new Service(studentXMLRepo, getStudentValidator(), temaXMLRepo, getTemaValidator(), getNotaXMLRepo(),getNotaValidator(studentXMLRepo, temaXMLRepo));
    }
}