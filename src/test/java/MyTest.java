import beans.Student;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.StudentService;

import java.util.List;

public class MyTest {

    private StudentService studentService;

    @Before
    public void myinit(){
        String config="applicationContext.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(config);
        studentService = (StudentService) ctx.getBean("studentService");
    }

    @Test
    public  void testAddStudent(){

        Student student=new Student();
        student.setAge(20);
        student.setName("Tom");
        int rows=studentService.addStudent(student);
        System.out.println("插入操作影响的行数："+rows);

    }
    @Test
    public void testQueryStudents(){
       List<Student> studentList= studentService.queryStudents();
       for(Student student:studentList){
           System.out.println(student);
       }
    }
}
