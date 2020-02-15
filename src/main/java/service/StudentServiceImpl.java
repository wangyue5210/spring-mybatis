package service;

import beans.Student;
import dao.StudentDao;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao;

    //Ioc的设值注入
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public int addStudent(Student student) {
         int rows = studentDao.insertStudent(student);
         return  rows;
    }

    public List<Student> queryStudents() {
        List<Student> students = studentDao.selectStudents();
        return students;
    }
}
