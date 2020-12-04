package com.linhmd.dto;

import java.util.Vector;

public class Department implements Comparable<Department>{
	private int id;
	private String name;

	public Department(){}

	public Department(int id, String name) {
		this.id = id;
		this.name = name;

	}

	public Department(Vector<String> data){
		this.id = Integer.parseInt(data.get(0));
		this.name = data.get(1);
	}

	public Department(String id, String name){
		this.id = Integer.parseInt(id);
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Department{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}

	@Override
	public int compareTo(Department o) {
		return this.id - o.id;
	}
}
