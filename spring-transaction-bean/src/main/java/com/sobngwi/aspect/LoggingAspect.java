package com.sobngwi.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
//@Component // aspect is a string bean.
public class LoggingAspect {

	private Logger log = Logger.getLogger(getClass().getName());
	
	/*@Before("execution( void com.sobngwi.entities..*.*(*))")
	public void callSetters(JoinPoint joinpoint) { // What method was called , what value of parameter
		String method = joinpoint.getSignature().getName() ;
		String clazz  = joinpoint.getTarget().toString();
		log.info("A setter is called Before[" + method + "] in the class [" + clazz + "]");
	}
	@After("execution( void com.sobngwi.entities..*.*(*))")
	public void callAfterSetters(JoinPoint joinpoint) { // What method was called , what value of parameter
		log.info("A setter is Ending ]");
	}
	
	@Around("execution( void com.sobngwi.entities..*.*(*))")
	public void callAroundSetters(ProceedingJoinPoint joinpoint) throws Throwable { // What method was called , what value of parameter
		// start stopwatch
		Object val = joinpoint.proceed();
		// stop stopwatch
		log.info("A setter is Runing Around  + val ] == [" + val + "]" );
	}
	*/
	@Around("execution( String playGame())")
	public Object checkForRain(ProceedingJoinPoint joinpoint) throws Throwable { // What method was called , what value of parameter
		boolean rain = Math.random() < 0.5;
		Object result = null ; 
		if ( rain ) {
			log.info( joinpoint.getTarget() + " rained out");
			result = "Post-Poned";
		}
		else {
			result = joinpoint.proceed();
			log.info("result of the match :["+ joinpoint.getTarget().toString() + "] -->" + result.toString());
		}
		return result;
	}
}
