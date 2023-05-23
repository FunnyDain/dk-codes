package jpamvcexam.mainview;

import jpamvcexam.model.entity.EntityTest;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.Scanner;

public class EntityTestApp2 {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
        EntityManager em = factory.createEntityManager();
        EntityTest et;
        em.getTransaction().begin();
        
        for(int i=1; i < 6; i++) {
        	et = new EntityTest();
        	et.setName("둘리"+i);
        	et.setAge(10+i);
        	et.setBirthday(LocalDateTime.now());
        	em.persist(et);         //insert하는 것, persist한다고 db에 넣어지지는 않음
        }
        System.out.println("엔터키.....");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
        scan.close();
        //enter키를 눌러야 commit or flush해서 값이 넣어짐
        em.getTransaction().commit();       
        em.close();
        factory.close();
	}
}
