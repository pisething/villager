package com.piseth.java.school.model;

public class Person2 {
	private String name;
	private String gender;
	private int age;
	private String pet;

	public Person2(String name, String gender, int age, String pet) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.pet = pet;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", gender=" + gender + ", age=" + age + ", pet={" + pet + "}]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPet() {
		return pet;
	}

	public void setPet(String pet) {
		this.pet = pet;
	}

}
