package exam3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("greeting2")
public class AfternoonGreetingImpl implements Greeting {

    @Override
    public void greet() {
        System.out.println("즐거운 오후되세요.");
    }
}
