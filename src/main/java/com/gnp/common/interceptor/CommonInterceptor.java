package com.gnp.common.interceptor;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.gnp.common.constant.Server;

/**
 * ??Όλ―Έν° λ‘κΉ λ°? λ‘κ·Έ?Έ ? λ³? ???₯.
 * 
 * <p>
 * Server.DEBUG κ°? true ?Ό κ²½μ° request ? ?΄κΈ? ??Όλ―Έν°κ°μ μΆλ ₯
 * </p>
 * 
 * @author osm077
 * @since 2020-01-06
 */
public class CommonInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(CommonInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
		
		String module = req.getRequestURI().split("/")[1];
		
		if (Server.NOCACHE) {
			// request λ§λ€ ??€? ?«?λ₯? λ°κΈ??¬ "?1234567890" ??λ‘?
			// request? attributeλ‘? μΆκ???¬ JSP(header.include)?? ?¬?©??λ‘? ??€.
			req.setAttribute(Server.CACHE_ID, "?" + System.currentTimeMillis());
		}
		return true;
	}

	private void print(HttpServletRequest req) {
		logger.info("requestURI : " + req.getRequestURI());
		logger.info("==[+]==========================================================================================");
		logger.info("requestURL  = {}", req.getRequestURL());
		logger.info("remoteAddr  = {}", req.getRemoteAddr());

		for (Enumeration<String> parameterNames = req.getParameterNames(); parameterNames.hasMoreElements();) {
			String name = parameterNames.nextElement();
			String[] values = req.getParameterValues(name);

			if (values.length > 1) {
				for (int i = 0; i < values.length; i++) {
					logger.info("{}[{}] = {}", name, i, values[i]);
				}
			} else {
				logger.info("{} = {}", name, values[0]);
			}
		}

		logger.info("===[-]=========================================================================================");
	}

	/**
	 * Controller ?? ? View λ₯? ?ΈμΆνκΈ? ? ? ?ΈμΆλ?€.
	 * modelAndView ??Όλ―Έν°? μ»¨νΈλ‘€λ¬κ°? ?? €μ€? ? λ³΄λ‘ μ»¨νΈλ‘€λ¬ ?? κ²°κ³Όλ₯? μ°Έμ‘°?κ±°λ μ‘°μ?  ? ??€
	 */
	@Override
	public void postHandle (HttpServletRequest req, HttpServletResponse res, Object handler, ModelAndView modelAndView) throws Exception
	{
	}

	/**
	 * View ?? μ΅μ’ κ²°κ³Όλ₯? ??±?? ?±? λͺ¨λ  ???΄ ?λ£λ ? ?€???€.
	 * ?μ²?μ²λ¦¬ μ€μ ?¬?©? λ¦¬μ?€λ₯? λ°ν?΄μ£ΌκΈ°? ? ?Ή? λ©μ??€
	 */
	@Override
	public void afterCompletion (HttpServletRequest req, HttpServletResponse res, Object handler, Exception e) throws Exception
	{
	}
}
