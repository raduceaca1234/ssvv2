package org.example;


import org.example.domain.Student;
import org.example.repository.StudentFileRepository;
import org.example.repository.StudentXMLRepo;
import org.example.service.Service;
import org.example.validation.StudentValidator;

public class TestBuilder {
    //student
    public static String DEFAULT_ID = "420";
    public static String DEFAULT_NAME = "nume";
    public static Integer DEFAULT_GROUP = 932;
    public static String DEFAULT_EMAIL = "racheta@as_manca_o_ciorba.gov";

    //files
    public static String DEFAULT_STUDENT_XML_FILE = "testData/testStudentXMLFile.xml";
    public static String DEFAULT_STUDENT_FILE = "testData/testStudentFile.txt";

    public Student getStudent() {
        return new Student(DEFAULT_ID, DEFAULT_NAME, DEFAULT_GROUP, DEFAULT_EMAIL);
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
        return new Service(getStudentXMLRepo(), getStudentValidator(), null,null,null,null);
    }
}
