package com.app.sample.messenger.model;

import java.io.Serializable;

public class Friend implements Serializable {
	private long id;
	private String name;
	private int photo;
	private String fund;
	public Friend(long id, String name, int photo) {
		this.id = id;
		this.name = name;
		this.photo = photo;
	}
	public Friend(long id, String name, int photo,String fund) {
		this.id = id;
		this.name = name;
		this.photo = photo;
		this.fund = fund;
	}
	public Friend(String name, int photo) {
		this.name = name;
		this.photo = photo;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getPhoto() {
		return photo;
	}

	public String getFund() {
		return fund;
	}

	public void setFund(String fund) {
		this.fund = fund;
	}
}
