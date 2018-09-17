package com.avengers.fc.processor;

import java.lang.reflect.Field;

import org.springframework.beans.BeansException;
import org.springframework.beans.InvalidPropertyException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import com.avengers.fc.annotation.EnchanceValue;

@Component
public class EnhanceValueProcessor implements BeanPostProcessor {

	String PREFIX = "DELTA";

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		String property = "";
		try {
			Class<?> klass = bean.getClass();
			Field fields[] = klass.getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				property = field.getName();
				EnchanceValue enchanceValue = field.getAnnotation(EnchanceValue.class);
				if (enchanceValue != null) {
					String value = PREFIX + " => " + field.get(bean);
					field.set(bean, value);
				}
			}
		} catch (Exception e) {
			throw new InvalidPropertyException(bean.getClass(), property, "Unable to enhance the value of the property");
		}
		return bean;
	}
}
