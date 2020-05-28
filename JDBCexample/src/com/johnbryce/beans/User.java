package com.johnbryce.beans;

public class User {
	private int id;
	private String last;
	private String first;

	public User(int id, String last, String first) {
		this.id = id;
		this.last = last;
		this.first = first;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", last=" + last + ", first=" + first + "]";
	}

}
