package aop04;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component		//필수
@Aspect
public class MyAspect{
	@Before("execution(public int aop04.*.*())")		//패키지.클래스.메서드, return값이 void인 것은 실행되지 않음
	public void b(JoinPoint joinPoint) {
		System.out.println("Before");
	}
	
	@After("execution(public int aop04.*.*())")
	public void a(JoinPoint joinPoint) {
		System.out.println("After");
	}

	@Around("execution(public int aop04.*.*())")
	public Object around(ProceedingJoinPoint jp) {
		//핵심로직이 실행되기 전
		System.out.println("Before Around");
		Object obj = null;
		
		//핵심로직 + 예외처리
		try {
			obj = jp.proceed();		//work1, work2, ..
			System.out.println("Around 리턴 값 : "+obj);
		} catch(Throwable e) {
			System.out.println("Around 예외 발생 : "+e.getMessage());
		}
		
		//핵심로직이 실행되기 후
		if (obj == null)
			obj = new Integer(0);
		System.out.println("After Around");
		return obj;
	}
	
	//@After은 무조건 실행
	
	//@AfterThrowing 에러가 나타났을 때 실행, 그냥 log만 찍을 용도
	//예외처리를 해주는 것은 아니므로 예외처리를 하고 싶다면 Around
	@AfterThrowing(pointcut="execution(public int aop04.*.*())", throwing="e" )
	public void at(Throwable e){
		System.out.println("AfterThrowing : " + e.getMessage());
	}

	//@AfterReturning 에러가 없이 return값이 있을 때 실행
	//work2, work3 실행 no, return타입이 안맞음
	@AfterReturning(pointcut="execution(public int aop04.*.*())", returning="ret" )
	public void ar(Object ret){
		System.out.println("AfterReturning : " + ret);
	}

	
	//work2만 회출됐을 때만 실행
	//work2의 return 값은 void이므로 얘만 실행
	@Before("execution(* *.work2()))")
	public void b1(JoinPoint joinPoint) {
		System.out.println("Before-b1");
	}
	//work3만 회출됐을 때만 실행
	@Before("execution(* *.work3()))")
	public void b2(JoinPoint joinPoint) {
		System.out.println("Before-b2");
	}
}







