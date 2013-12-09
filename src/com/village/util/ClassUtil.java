package com.village.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;

public class ClassUtil {

	public static <T> Class<T> getGenericClass(Class<?> genericClass) {
		return getGenericClass(genericClass, 0);
	}

	public static <T> Class<T> getGenericClass(Class<?> genericClass, int index) {
		Class modelClass = null;
		TypeVariable[] tv = genericClass.getTypeParameters();
		if (tv.length == 0) {
			Type gsc = genericClass.getGenericSuperclass();
			if ((gsc instanceof ParameterizedType)) {
				ParameterizedType pt = (ParameterizedType) gsc;
				modelClass = (Class) pt.getActualTypeArguments()[index];
			} else {
				modelClass = getGenericClass((Class) gsc);
			}
		} else {
			modelClass = getGenericClass(genericClass, (new StringBuilder(
					String.valueOf(index))).toString());
		}
		return modelClass;
	}

	public static <T> Class<T> getGenericClass(Class<?> genericClass,
			String name) {
		Class modelClass = null;

		TypeVariable[] tv = genericClass.getTypeParameters();
		Map map = new HashMap();
		int idx = 0;
		for (TypeVariable typeVariable : tv) {
			Type type = typeVariable.getBounds()[0];
			if ((type instanceof Class)) {
				map.put(typeVariable.getName(), (Class) type);
				map.put(idx, (Class) type);
			} else if ((type instanceof ParameterizedType)) {
				Type rawType = ((ParameterizedType) type).getRawType();
				map.put(typeVariable.getName(), (Class) rawType);
				map.put(idx, (Class) rawType);
			} else {
				// TODO 此处需添加LOG记录
				throw new RuntimeException("不支持的泛型反射�?" + type);
			}
			idx++;
		}
		itr(genericClass, map);
		if (map.containsKey(name))
			modelClass = (Class) map.get(name);
		else {
			// TODO 此处需添加LOG记录
			System.out.println("无法获取指定的泛型类相应的类型：" + name);
			try {
				throw new Throwable("123");
			} catch (Throwable e) {
			}
		}
		return modelClass;
	}

	private static void itr(Class genericClass, Map<String, Class<?>> map) {
		Class superclass = genericClass.getSuperclass();
		if (Object.class.equals(superclass))
			return;
		TypeVariable tv[] = superclass.getTypeParameters();
		Type actualTypes[] = (java.lang.reflect.Type[]) null;
		if (tv.length > 0) {
			Type gsc = genericClass.getGenericSuperclass();
			ParameterizedType pt = (ParameterizedType) gsc;
			actualTypes = pt.getActualTypeArguments();
		}
		for (int i = 0; i < tv.length; i++)
			if (map.containsKey(tv[i].getName())) {
				map.put((new StringBuilder()).append(i).toString(), (Class) map
						.get(tv[i].getName()));
			} else {
				if (actualTypes[i] instanceof Class)
					map.put(tv[i].getName(), (Class) actualTypes[i]);
				else if (actualTypes[i] instanceof TypeVariable)
					map
							.put(tv[i].getName(),
									(Class) ((TypeVariable) actualTypes[i])
											.getBounds()[0]);
				map.put((new StringBuilder()).append(i).toString(), (Class) map
						.get(tv[i].getName()));
			}
	}
	
	public static String getClassName(String name){
		String className = "";
		if(name != null){
			className = name.substring(name.lastIndexOf(".")+1, name.length());
		}
		return className;
	}

}
