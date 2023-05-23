package exam3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("greeting4")
public class NightGreetingImpl implements Greeting {

    @Override
    public void greet() {
        System.out.println("안녕히 주무세요.");
    }
}
