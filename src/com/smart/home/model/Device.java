package com.smart.home.model;

public class Device {
	
	private final int id;
	private final String name;
	private final int userId;
	
	public Device(final int id, final String name, final int userId) {
		this.id = id;
		this.name = name;
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getUserId() {
		return userId;
	}
	
	
}
