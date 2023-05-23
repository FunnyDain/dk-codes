package exam2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class StudyApp {
    public static void main(String[] args) {
        ApplicationContext factory = new ClassPathXmlApplicationContext("bean1.XML");
        System.out.println("************ IoC 컨테이너의 초기화 작업 끝 ************\n");

        List<Student> students = new ArrayList<>();
        students.add(factory.getBean("st1", Student.class));
        students.add(factory.getBean("st2", Student.class));
        students.add(factory.getBean("st3", Student.class));


        for (Student s : students){
            if(s.getMyHomework().getHomeworkName().equals("수학"))
                System.out.printf("%s는 %s을 학습합니다.\n",s.getName(), s.getMyHomework().getHomeworkName());
            else
                System.out.printf("%s는 %s를 학습합니다.\n",s.getName(), s.getMyHomework().getHomeworkName());
        }

        ((ClassPathXmlApplicationContext)factory).close();
    }

}
