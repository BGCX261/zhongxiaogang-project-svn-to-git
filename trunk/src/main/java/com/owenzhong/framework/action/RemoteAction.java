package com.owenzhong.framework.action;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONPopulator;
import org.apache.struts2.json.JSONUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@SuppressWarnings("unchecked")
public class RemoteAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;

	private JSONPopulator populator = new JSONPopulator();
	
	private String service;
	private String method;
	private String params;
	
	private List paramsList = null;

	private Object result;
	private Boolean success;
	private String error;
	
	@Override
	public String execute() throws Exception {
		try {
			paramsList = (List) JSONUtil.deserialize(params);
		} catch (JSONException e) {
			error = e.getMessage();
			success = false;
		}
		int papramsCount = getParams() == null ? 0 : paramsList.size();
		if (service != null && method != null) {
			Object bean = getBean();
			Method matchMethod = getMethod(bean, method, papramsCount);
			if (matchMethod != null) {
				try {
					invoke(bean,matchMethod,papramsCount);
					success = true;
				} catch (Exception e) {
					error = e.getMessage();
					success = false;
				}
			} else {
				error = "Method can not found!";
				success = false;
			}
		}else{
			error = "Both service and method can not be null!";
			success = false;
		}
		return SUCCESS;
	}
	
	private void invoke(Object bean,Method matchMethod,int papramsCount)throws Exception{
		if (papramsCount > 0) {
			Class[] parameterTypes = matchMethod.getParameterTypes();
			Type[] genericTypes = matchMethod.getGenericParameterTypes();
			List invocationParameters = new ArrayList();
			if (parameterTypes.length != papramsCount) {
				return ;
			}
			for (int i = 0; i < paramsList.size(); ++i) {
				Object parameter = paramsList.get(i);
				Class paramType = parameterTypes[i];
				Type genericType = genericTypes[i];
				Object converted;
				converted = this.populator.convert(paramType,genericType, parameter, matchMethod);
				invocationParameters.add(converted);
			}
			result = matchMethod.invoke(bean, invocationParameters);
		} else {
			result = matchMethod.invoke(bean, new Object[0]);
		}
	}
	private Object getBean(){
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(ServletActionContext
				.getServletContext());
		return webApplicationContext.getBean(service);
	}
	private Method getMethod(Object bean, String methodName, int papramsCount) {
		Method[] methods = bean.getClass().getMethods();
		for (Method method : methods) {
			if (checkMethodSignature(method, methodName, papramsCount)) {
				return method;
			}
		}
		return null;
	}

	private boolean checkMethodSignature(Method method, String name,
			int parameterCount) {
		boolean paramsMatch = method.getParameterTypes().length == parameterCount;
		if ((method.getName().equals(name)) && (paramsMatch)) {
			return true;
		}
		return false;
	}

	public JSONPopulator getPopulator() {
		return populator;
	}

	public void setPopulator(JSONPopulator populator) {
		this.populator = populator;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}


	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getParams() {
		return params;
	}
}
