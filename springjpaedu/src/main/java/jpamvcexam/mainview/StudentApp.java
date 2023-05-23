package jpamvcexam.mainview;

import jpamvcexam.controller.StudentController;

import java.awt.*;
import java.util.Scanner;

public class StudentApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StudentController sc = new StudentController();
        int num;
        outer : while (true) {
            System.out.println("******************************************************");
            System.out.println("1. 학생 정보 출력");
            System.out.println("2. 학생 정보 입력");
            System.out.println("3. 학생 정보 삭제");
            System.out.println("4. 학생 정보 수정");
            System.out.println("5. 학생 점수 확인");
            System.out.println("6. 종료");
            System.out.print("입력 : ");

            num = scan.nextInt();
            String name;
            int score;
            switch (num) {
                case 1 :
                    sc.printAll();
                    break;
                case 2 :
                    System.out.println("학생의 이름을 입력하시오");
                    name = scan.next();

                    System.out.println("학생의 점수를 입력하시오");
                    score = scan.nextInt();

                    sc.insert(name, score);
                    break;
                case 3 :
                    System.out.println("삭제하려는 학생의 이름을 입력하시오");
                    name = scan.next();
                    sc.delete(name);
                    break;
                case 4 :
                    System.out.println("수정하려는 학생의 이름을 입력하시오");
                    name = scan.next();
                    System.out.println("수정하려는 학생의 점수를 입력하시오");
                    score = scan.nextInt();
                    sc.update(name, score);
                    break;
                case 5 :
                    System.out.println("점수를 확인하고자 하는 학생의 이름을 입력하시오");
                    name = scan.next();
                    sc.printScore(name);
                    break;
                case 6 :
                    break outer;
                default:
                    System.out.println("1부터 6까지만 입력하시오");
            }

        }
        scan.close();
    }
}
