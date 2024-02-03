package org.springframework.test.bean;

import org.github.springframework.beans.factory.DisposableBean;
import org.github.springframework.beans.factory.InitializingBean;
import org.github.springframework.context.annotation.Autowired;
import org.github.springframework.stereotype.Component;

@Component
public class Person implements InitializingBean, DisposableBean {

	private String name;

	private int age;
	@Autowired
	private Car car;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", age=" + age +
				", car=" + car +
				'}';
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("I died in the method named destroy");

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("I was born in the method named afterPropertiesSet");

	}

	public void customInitMethod() {
		System.out.println("I was born in the method named customInitMethod");
	}

	public void customDestroyMethod() {
		System.out.println("I died in the method named customDestroyMethod");
	}
}
