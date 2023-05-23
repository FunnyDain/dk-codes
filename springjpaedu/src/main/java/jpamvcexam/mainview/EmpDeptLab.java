package jpamvcexam.mainview;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class EmpDeptLab {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
        EntityManager em = factory.createEntityManager();

        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        String jpql;

        if(random.nextBoolean() == true){
            System.out.print("사원명을 입력하시오 : ");
            String inputName = scan.next();

            //사원명을 입력받아 부서명
            jpql = "select d.dName from Emp e join e.dept d where e.eName = :en";

            TypedQuery<String> deptName = em.createQuery(jpql, String.class);
            deptName.setParameter("en", inputName);

            String result = deptName.getSingleResult();

            if (result.isEmpty()) {
                System.out.println("부서명을 찾을 수 없네요 ㅠㅠ");
            }else{
                System.out.printf("%s사원의 부서명은 %s입니다.\n", inputName, result);
            }
        }else {
            System.out.println("부서명을 입력하시오 : ");
            String inputDept = scan.next();

            //부서명을 입력받아 직원들 이름
            jpql = "select e.eName from Emp e join e.dept d where d.dName = :dn";

            TypedQuery<String> eName = em.createQuery(jpql, String.class);
            eName.setParameter("dn", inputDept);

            List<String> eNames = eName.getResultList();

            if (eNames.isEmpty()) {
                System.out.println("직원을 찾을 수 없네요 ㅠㅠ");
            }else{
                System.out.printf("%s부서에 직원들입니다.\n", inputDept);
                for (String name : eNames) {
                    System.out.println(name);
                }
            }
        }



        System.out.println("부서명을 입력하세요");
    }
}
