package exam1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sample1.MessageBean;

import java.time.LocalDateTime;

public class GreetingTest {
    public static void main(String[] args) {
        ApplicationContext factory
                = new ClassPathXmlApplicationContext("exam1.xml");
        System.out.println("************ IoC 컨테이너의 초기화 작업 끝 ************\n");

        LocalDateTime now = factory.getBean("time", LocalDateTime.class);

        Greeting greeting = null;

        int hour = now.getHour();

        if(6<=hour && 12>hour){
            greeting = factory.getBean("greeting1", MorningGreetingImpl.class);
        }else if(hour>=12 && hour<17){
            greeting = factory.getBean("greeting2", AfternoonGreetingImpl.class);
        }else if(hour>=17 && hour<22){
            greeting = factory.getBean("greeting3", EveningGreetingImpl.class);
        }else{
            greeting = factory.getBean("greeting4", NightGreetingImpl.class);
        }
        greeting.greet();
        ((ClassPathXmlApplicationContext)factory).close();

    }
}
