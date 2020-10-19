package com.example.crudProject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// ORM- Object Relational Mapper- converts classes to tables

@Entity
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

	private String name;
	private int age;
	private String position;
	private int goals;
	
	public Player() { //Empty constructors and getters and setters needed for an entity
		super();
	}

	public Player(String name, int age, String position, int goals) {
		super();
		this.name = name;
		this.age = age;
		this.position = position;
		this.goals = goals;
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getGoals() {
		return goals;
	}

	public void setGoals(int goals) {
		this.goals = goals;
	}

	@Override
	public String toString() {
		return "Players [name= " + name + ", age= " + age + ", Position= " + position + ", Goals= " + goals
				+ "]";
	}

}	

