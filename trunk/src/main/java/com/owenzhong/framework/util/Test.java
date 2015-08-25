package com.owenzhong.framework.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class Test {
	public static Map<String,String> classDefine;
	static{
		classDefine = new HashMap<String, String>();
		classDefine.put("A", "com.owenzhong.framework.util.AImpl");
		classDefine.put("IoCTest", "com.owenzhong.framework.util.IoCTestImpl");
		classDefine.put("AOPTest", "com.owenzhong.framework.util.AOPTestImpl");
	}
	public static Object loadClass(String name) throws Exception{
		Class<?> loadClass = Thread.currentThread().getContextClassLoader().loadClass(name);
		Object instance = loadClass.newInstance();
		Method[] declaredMethods = instance.getClass().getDeclaredMethods();
		for (Method method : declaredMethods) {
			String methodName = method.getName();
			if(methodName.startsWith("set")){
				String substring = methodName.substring(methodName.indexOf("set")+3);
				method.invoke(instance, loadClass(classDefine.get(substring)));
			}
		}
		return instance;
	}
	
	public static Object loadProxyClass(String name) throws Exception{
		Object loadClass = loadClass(name);
		return Proxy.newProxyInstance(loadClass.getClass().getClassLoader(), loadClass.getClass().getInterfaces(), new MethodInteceptor(loadClass));
	}
	
	public static void main(String[] args) {
		try {
			ioc();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			aop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void ioc() throws Exception{
		IoCTest loadClass = (IoCTest) loadClass(classDefine.get("IoCTest"));
		loadClass.doSomthing();
	}
	public static void aop() throws Exception{
		AOPTest proxyClass = (AOPTest) loadProxyClass(classDefine.get("AOPTest"));
		proxyClass.doSomthing();
		proxyClass.doHello();
	}
}

interface A {
	public void say();
}
class AImpl implements A{

	public void say() {
		System.out.println("IoCTest never known class AImpl.");
	}
	
}
interface IoCTest{
	public void doSomthing();
}
class IoCTestImpl implements IoCTest{
	private A a;
	public void doSomthing() {
		a.say();
	}
	public void setA(A a) {
		this.a = a;
	}
}
interface AOPTest{
	public void doSomthing();
	
	public void doHello();
}
class AOPTestImpl implements AOPTest{

	public void doSomthing() {
		System.out.println("doing something");
	}

	public void doHello() {
		System.out.println("hello aop test!");
	}
	
	
}

class MethodInteceptor implements InvocationHandler{
	private Object object;
	public MethodInteceptor(Object object){
		this.object = object;
	}
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("Method "+method.getName()+" start call at : "+System.currentTimeMillis()+" !");
		Object result = method.invoke(this.object, args);
		System.out.println("Method "+method.getName()+" called at :"+System.currentTimeMillis()+"!");
		return result;
	}
	
} 