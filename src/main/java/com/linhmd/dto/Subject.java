package com.linhmd.dto;

import com.linhmd.utility.VectorAble;

import java.util.Objects;
import java.util.Vector;
import java.util.stream.Collectors;

public class Subject implements Comparable<Subject>, VectorAble{
	private int code;
	private int department;
	private String nameVN;
	private String nameEN;
	private String nameShort;
	private int grade;
	private int term;
	private boolean isExtra;

	public Subject(){
	}

	public Subject(int code, int department, String nameVN, String nameEN, String nameShort, int grade, int term, boolean isExtra) {
		this.code = code;
		this.department = department;
		this.nameVN = nameVN;
		this.nameEN = nameEN;
		this.nameShort = nameShort;
		this.grade = grade;
		this.term = term;
		this.isExtra = isExtra;
	}

	public Subject(Vector<String> vector) {
		this.code = Integer.parseInt((vector.get(0)));
		this.department = Integer.parseInt(vector.get(1));
		this.nameVN = vector.get(2);
		this.nameEN = vector.get(3);
		this.nameShort = vector.get(4);
		this.grade = Integer.parseInt(vector.get(5));
		this.term = Integer.parseInt(vector.get(6));
		this.isExtra = Boolean.parseBoolean(vector.get(7));
	}


	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getDepartment() {
		return department;
	}

	public void setDepartment(int department) {
		this.department = department;
	}

	public String getNameVN() {
		return nameVN;
	}

	public void setNameVN(String nameVN) {
		this.nameVN = nameVN;
	}

	public String getNameEN() {
		return nameEN;
	}

	public void setNameEN(String nameEN) {
		this.nameEN = nameEN;
	}

	public String getNameShort() {
		return nameShort;
	}

	public void setNameShort(String nameShort) {
		this.nameShort = nameShort;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public boolean isExtra() {
		return isExtra;
	}

	public void setExtra(boolean extra) {
		isExtra = extra;
	}

	@Override
	public String toString() {
		return "Subject{" +
				"code=" + code +
				", department=" + department +
				", nameVN='" + nameVN + '\'' +
				", nameEN='" + nameEN + '\'' +
				", nameShort='" + nameShort + '\'' +
				", grade=" + grade +
				", term=" + term +
				", isExtra=" + isExtra +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Subject)) return false;
		Subject subject = (Subject) o;
		return code == subject.code;
	}

	@Override
	public int hashCode() {
		return Objects.hash(code);
	}

	@Override
	public int compareTo(Subject o) {
		return this.code - o.code;
	}


	@Override
	public Vector<Object> toVector() {
		return null;
	}

	@Override
	public VectorAble toObject(Vector<Object> data) {
		if(data.size() == 0 || data.size() < 8) return null;
		Vector<String> vector = data.stream().map(s -> (String)s).collect(Collectors.toCollection(Vector::new));
		return new Subject(vector);
	}


}
