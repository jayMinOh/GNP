package com.gnp.common.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ?€?? ?€ ???. @TODO
 * 
 * <p>?Όλ°μ¬?©??Ή, λͺ¨λ°?Ό?¬?©??? ?¬?©</p>
 * 
 * @author	osm077
 * @since	2020-01-06
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginRequired {

}
