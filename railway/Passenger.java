package railway;

import java.util.*;

public class Passenger implements Comparable<Passenger>
{
	
	private String name;
	private int age;
	private char gender;
	
    public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}

    public Passenger(String name, int age, char gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

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

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Passenger [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}

	@Override
	public int compareTo(Passenger p) {
		// TODO Auto-generated method stub
		return name.compareTo(p.name);
	}
	
	
	
	

}
