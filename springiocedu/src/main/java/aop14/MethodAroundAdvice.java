package aop14;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MethodAroundAdvice {
	@Around("execution(public * aop14.DayServiceImpl.*())")
	public Object around(ProceedingJoinPoint pjp) {
		if (pjp.getSignature().getName().startsWith("get"))		//joinPoint객체가 누구냐 확인
			System.out.println("<<< MethodBeforeLogAdvice >>>");	//아니면 error가 발생해도 이게 실행됨
		Object result=null;
		try {
			result = pjp.proceed();
		}catch(Throwable e) {
			System.out.println(":::오류 발생 메시지 : " + e.getMessage());
		}
		return result;
	}
}