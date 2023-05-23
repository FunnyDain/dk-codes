package sampleanno1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//객체 생성시 원래 이름은 myFoodMgr인데 이름을 myFood로 변경
//당연히 FoodTest에서는 myFood로 찾아옴
@Component("myFood")  //default : myFoodMgr
public class MyFoodMgr{
	
	//필드에 정의
	//Food타입의 객체를 찾아 대입, xml엔 객체가 두 개 만들어짐
	//이럴 땐, 두 개 이므로 멤버변수와 이름이 똑같은 객체가 대입된다.
	@Autowired
	//@Qualifier(value="unFavoriteFood") : 이 주석을 푼다면 둘 다 unFavoriteFood가 대입
	private Food favoriteFood;     
	@Autowired
	private Food unFavoriteFood;
	                 
	
	@Override
	public String toString() {
		return "[favoriteFood=" + favoriteFood + ", unFavoriteFood=" + unFavoriteFood + "]";
	}
}
