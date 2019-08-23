package in.conceptarchitect.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import in.conceptarchitect.animalkingdom.SpecialBehavior;
import in.conceptarchitect.animalkingdom.Speciality;

public class Reflect {
	
	public static Object invoke(Object o, String methodName, Object ...params) {
		try {
			
			Class<?> [] types= Stream.of(params)       //take all parameter as stream
							.map(arg-> arg.getClass())    //convert it to corresponding class strea
							.collect(Collectors.toList()) //collect as  list
							.toArray(new Class[0]);  //then as array
			
			Method method= o.getClass().getMethod(methodName,types);
			return method.invoke(o, params);			
		} catch(Exception ex) {
			throw new MethodInvokeException(methodName,ex.getMessage(),ex);
		}
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T invokeDefault(Object o, String methodName, T defaultReturn, Object...params) {
		try {
			return (T) invoke(o,methodName,params);
		} catch(MethodInvokeException ex) {
			return defaultReturn;
		}
	}

	
	public static String info(Object o) {
		return info(o.getClass());
	}
	
	static StringBuilder append(StringBuilder builder, String format, Object ...params) {
		builder.append(String.format(format, params));
		return builder;
	}
	
	public static String info(Class cls) {
		StringBuilder str=new StringBuilder();
		
		append(str, "package %s;\n\n", cls.getPackageName());
		
		int scope=cls.getModifiers();
		
		if(Modifier.isPublic(scope))
			append(str,"public ");
		if(Modifier.isInterface(scope))
			append(str,"interface ");
		else if(Modifier.isAbstract(scope))
			append(str,"abstract ");
		
		if(Modifier.isFinal(scope))
			append(str,"final ");
		
		if(!Modifier.isInterface(scope) )
				append(str,"class ");
		
		append(str, cls.getSimpleName());
		
		if(!cls.equals(Object.class))
			append(str,"\n\textends %s ",cls.getSuperclass().getName());
		
		Class<?> [] interfaces= cls.getInterfaces();
		
		if(interfaces.length>0) {
			if(Modifier.isInterface(scope))
				append(str,"\n\textends ");
			else
				append(str, "\n\timplements ");
			
			for(int i=0;i<interfaces.length;i++)
			{
				if(i>0)
					append(str,",");
				append(str,interfaces[i].getName());
			}
		}
		
		
		append(str,"{\n\n\n");
		
		for(Method method: cls.getMethods()) {
			if(! method.getDeclaringClass().equals(Object.class))
				append(str,"\t%s\n",method);
		}
		
		append(str,"}");
		
		
		return str.toString();
	}


	public static void invokeAll(Class<?> cls) {
		try {
			
			Object instance= cls.newInstance();
			Method [] methods= cls.getMethods();
			
			for(Method method: methods) {
				try {
				int m=method.getModifiers();
				if(Modifier.isStatic(m))
					continue; //ignore static method
				if(method.getDeclaringClass().equals(Object.class))
					continue; //ignore Object class Methods
				
				if(method.getParameterCount()>0){
					System.out.println("skipping parametered method "+method.getName());
					continue;
				}
				
				//Now is the method to call
				System.out.printf("Invoking %s ... ",method.getName());
				Object result = method.invoke(instance);
				System.out.println(result);
				}catch(Exception ex) {
					System.out.println("error:"+ex.getMessage());
				}
				
			}
			
		}catch(Exception ex) {
			System.out.println("error:"+ex+"\t"+ex.getMessage());
		}
	}

	public static void invokeSpecialBehaviors(Class<?> cls) {
		// TODO Auto-generated method stub
		try {
			
			Object instance= cls.newInstance();
			Method [] methods= cls.getMethods();
			int count=0;
			for(var method: methods) {
				try {
				int m=method.getModifiers();
				if(Modifier.isStatic(m))
					continue; //ignore static method
				if(method.getDeclaringClass().equals(Object.class))
					continue; //ignore Object class Methods
				
				if( method.getAnnotation(SpecialBehavior.class)==null)
						continue; //not a special behavior
				
				
				if(method.getParameterCount()>0){
					System.out.println("skipping parametered method "+method.getName());
					continue;
				}
				
				//Now is the method to call
				System.out.printf("Invoking %s ... ",method.getName());
				count++;
				Object result = method.invoke(instance);
				
				System.out.println(result);
				}catch(Exception ex) {
					System.out.println("error:"+ex.getMessage());
				}
				
			}
			
			if(count==0) {
				System.out.println(cls.getSimpleName()+" has No Special Behavior");
			}
				
			
		}catch(Exception ex) {
			System.out.println("error:"+ex+"\t"+ex.getMessage());
		}
		
	}
	
	
	public static void invokeSpeciality(Class<?> cls) {
		String methodName, requiredName, followName;
		try {
			
			Object instance= cls.newInstance();
			Speciality speciality=cls.getAnnotation(Speciality.class);
			if(speciality==null) {
				System.out.println(cls+" has No Speciality Defined");
				return;
			}
			
			methodName= speciality.name();
			requiredName=speciality.requires();
			followName=speciality.follows();
			
			Object result=null;
			if(!requiredName.equals("")) {
				System.out.print("Invoking Prerequisite ["+ requiredName+"]...");
				result= invoke(instance, requiredName);
				System.out.println(result);
			}
			
			System.out.printf("Invoking Speciality %s ... ",methodName);
			result=invoke(instance,methodName);
			System.out.println(result);
			
			
			if(!followName.equals("")) {
				System.out.print("Now Invoke ["+ followName+"]...");
				result= invoke(instance, followName);
				System.out.println(result);
			}
					
			
		}
		catch(MethodInvokeException ex) {
			String name=ex.getMethodName();
			System.out.println(cls+" doesn't support "+name);
		}
		catch(Exception ex) {
			System.out.println("Error: "+ex.getMessage());
		}
	}
	


}


