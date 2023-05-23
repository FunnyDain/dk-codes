package jpamvcexam.mainview;

import jpamvcexam.model.vo.Book;

import javax.persistence.*;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class JPASelectBookLab {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("emptest");
        EntityManager em = factory.createEntityManager();
        int num;

        Scanner sc = new Scanner(System.in);

        String jpql;
        Random random = new Random();
        TypedQuery<Book> b;

        outer : while(true){
            System.out.println("1. 모두 출력하기");
            System.out.println("2. 가격이 높은 순으로 출력하기");
            System.out.println("3. 20000원 이상의 도서들만 출력하기");
            System.out.println("4. id가 3번인 도서 출력하기");
            System.out.println("5. 도서명에 '자바' 또는 '스프링'을 포함하는 도서들만 출력하기");
            System.out.println("6. 분류별 도서 가격의 합을 출력하기");
            System.out.println("7. 종료");
            System.out.print("원하는 메뉴의 번호를 선택 : ");
            num = sc.nextInt();

            switch (num) {
                case 1:
                    //모두 출력하기
                    jpql = "select b from Book b";
                    b = em.createQuery(jpql, Book.class);
                    b.getResultList().stream().forEach(System.out::println);
                    break;
                case 2:
                    //가격이 높은 순으로 출력하기
                    jpql = "select b from Book b order by price desc";
                    b = em.createQuery(jpql, Book.class);
                    b.getResultList().stream().forEach(System.out::println);
                    break;
                case 3:
                    //20000원 이상의 도서들만 출력하기
                    jpql = "select b from Book b where b.price >= 20000";
                    b = em.createQuery(jpql, Book.class);
                    b.getResultList().stream().forEach(System.out::println);
                    break;
                case 4:
                    //id가 3번인 도서 출력하기
                    Book book = em.find(Book.class, 3);
                    if (book != null)
                        System.out.println(book);
                    else
                        System.out.println("없엉 ㅜㅜㅜ");
                    break;
                case 5:
                    //도서명에 '자바' 또는 '스프링'를 포함하는 도서들만 출력하기
                    b = em.createQuery("select b from Book b where b.title like :word", Book.class);
                    if (random.nextBoolean()) {
                        b.setParameter("word", "%자바%");
                    } else {
                        b.setParameter("word", "%스프링%");
                    }
                    List<Book> books = b.getResultList();
                    if(books != null)
                        books.stream().forEach(System.out::println);
                    else{
                        System.out.println("엉엉 도서없어");
                    }
                    break;
                case 6:
                    //분류별 도서 가격의 합을 출력하기
                    jpql = "select b.kind, sum(b.price) from Book b group by b.kind";
                    Query query = em.createQuery(jpql);
                    List<Object[]> objects = query.getResultList();
                    for (Object[] object : objects) {
                        System.out.printf("분류코드 %s \t %,d \n", object[0],object[1]);
                    }
                    break;
                case 7 :
                    System.out.println("후후 종료할게^^");
                    break outer;
                default:
                    System.out.println("1~7까지의 번호를 입력하시오");
            }

        }
        em.close();
        factory.close();

    }
}
