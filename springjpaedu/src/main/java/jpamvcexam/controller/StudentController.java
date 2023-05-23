package jpamvcexam.controller;

import jpamvcexam.model.dao.StudentDAO;
import jpamvcexam.model.vo.Student;

import java.util.List;
import java.util.Objects;

public class StudentController {

    private StudentDAO studentDAO;

    public StudentController() {
        studentDAO = new StudentDAO();
    }

    public void printAll() {
        List<Student> students = studentDAO.getAllStudent();
        if (!students.isEmpty()) {
            for (Student str : students) {
                System.out.printf("%s학생의 점수는 %d\n", str.getName(), str.getScore());
            }
        } else {
            System.out.println("학생리스트가 없습니다.");
        }

    }

    public void printScore(String name) {
        Student student = studentDAO.getScore(name);
        if (Objects.isNull(student))
            System.out.printf("%s학생은 존재하지 않습니다.",name);
        else
            System.out.printf("%s학생의 점수는 %d입니다.",student.getName(), student.getScore());
    }

    public void insert(String name, Integer score) {
        Student student = new Student();
        student.setName(name);
        student.setScore(score);
        if (studentDAO.insertStudent(student)) {
            System.out.println("입력 성공");
        } else {
            System.out.println("입력 실패");
        }
    }

    public void update(String name, int score) {
        Student student = new Student();
        student.setName(name);
        student.setScore(score);
        if (studentDAO.updateStudent(student))
            System.out.printf("%s학생의 점수를 변경했습니다.", name);
        else
            System.out.printf("%s학생은 존재하지 않습니다.", name);

    }

    public void delete(String name) {
        if(studentDAO.deleteStudent(name))
            System.out.printf("%s학생의 데이터를 삭제했습니다.", name);
        else
            System.out.printf("%s학생은 존재하지 않습니다.", name);
    }
}
