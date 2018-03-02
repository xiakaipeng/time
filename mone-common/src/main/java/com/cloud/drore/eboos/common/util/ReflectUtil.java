package com.cloud.drore.eboos.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ReflectUtil
{

	public static Class<?> getGenericParameterType(final Class<?> cls)
	{
		Type type = cls.getGenericSuperclass();
		if (type instanceof ParameterizedType)
		{
			ParameterizedType pt = (ParameterizedType) cls.getGenericSuperclass();
			return (Class<?>) pt.getActualTypeArguments()[0];
		}
		return null;
	}

	public static Object forceGet(final Object obj, final String fieldName)
	{
		Field field = null;
		try
		{
			field = getDeclaredField(obj, fieldName);
			field.setAccessible(true);
			return field.get(obj);
		} catch (SecurityException e)
		{
			e.printStackTrace();
		} catch (IllegalArgumentException e)
		{
			e.printStackTrace();
		} catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static void forceSet(final Object obj, final String fieldName, final Object value)
	{
		Field field = null;
		try
		{
			field = getDeclaredField(obj, fieldName);
			field.setAccessible(true);
			field.set(obj, value);
		} catch (SecurityException e)
		{
			e.printStackTrace();
		} catch (IllegalArgumentException e)
		{
			e.printStackTrace();
		} catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
	}

	public static Object forceApply(Object obj, String methodName, Class<?>[] types, Object[] values)
	{
		try
		{
			Method method = getDeclaredMethod(obj, methodName, types);
			method.setAccessible(true);
			return method.invoke(obj, values);
		} catch (SecurityException e)
		{
			e.printStackTrace();
		} catch (IllegalArgumentException e)
		{
			e.printStackTrace();
		} catch (IllegalAccessException e)
		{
			e.printStackTrace();
		} catch (InvocationTargetException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static Method getDeclaredMethod(Object object, String methodName, Class<?>... parameterTypes)
	{
		Method method = null;
		for (Class<?> cls = object.getClass(); cls != Object.class; cls = cls.getSuperclass())
		{
			try
			{
				method = cls.getDeclaredMethod(methodName, parameterTypes);
				return method;
			} catch (Exception e)
			{
			}
		}
		return null;
	}

	public static Field getDeclaredField(Object object, String fieldName)
	{
		Field field = null;
		Class<?> cls = object.getClass();
		for (; cls != Object.class; cls = cls.getSuperclass())
		{
			try
			{
				field = cls.getDeclaredField(fieldName);
				return field;
			} catch (Exception e)
			{
			}
		}
		return null;
	}

	public static Object apply(Object object, String methodName, Class<?>[] parameterTypes, Object[] parameters)
	{
		Method method = getDeclaredMethod(object, methodName, parameterTypes);
		method.setAccessible(true);
		try
		{
			if (null != method)
				return method.invoke(object, parameters);
		} catch (IllegalArgumentException e)
		{
			e.printStackTrace();
		} catch (IllegalAccessException e)
		{
			e.printStackTrace();
		} catch (InvocationTargetException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static Object apply(Object object, String methodName, Class<?> parameterTypes, Object parameters)
	{
		Method method = getDeclaredMethod(object, methodName, parameterTypes);
		method.setAccessible(true);
		try
		{
			if (null != method)
				return method.invoke(object, parameters);
		} catch (IllegalArgumentException e)
		{
			e.printStackTrace();
		} catch (IllegalAccessException e)
		{
			e.printStackTrace();
		} catch (InvocationTargetException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
