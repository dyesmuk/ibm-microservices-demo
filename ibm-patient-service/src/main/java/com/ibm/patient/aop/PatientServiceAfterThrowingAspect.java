package com.ibm.patient.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import com.ibm.patient.exception.InsuranceNotFoundException;
import com.ibm.patient.exception.UserNotFoundException;

@Configuration
@Aspect
public class PatientServiceAfterThrowingAspect {
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@AfterThrowing(pointcut = "execution(* com.ibm.patient.service.PatientService.patient*(..))")
	public void exceptionUserNotFound(JoinPoint obj) {
			LOG.warn("User Not Found : " + obj.getSignature().toString());
	}
	
	@AfterThrowing(pointcut = "execution(* com.ibm.patient.service.PatientService.insuranceByPatientId(Integer))", throwing = "ex")
	public void exceptionUserOrInsuranceNotFound(JoinPoint obj, Exception ex) {
	    if (ex instanceof UserNotFoundException || ex instanceof InsuranceNotFoundException) {
	        LOG.warn("Exception thrown in method " + obj.getSignature().toString() + ": " + ex.getMessage());
	    }
	}
	
	@AfterThrowing(pointcut = "execution(* com.ibm.patient.service.PatientService.insurance*(..))")
	public void exceptionInsuranceNotFound(JoinPoint obj) {
			LOG.warn("Insurance Not Found : " + obj.getSignature().toString());
	}

}
