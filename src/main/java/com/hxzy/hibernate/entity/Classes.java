package com.hxzy.hibernate.entity;

import java.io.Serializable;

public class Classes implements Serializable {
	private static final long serialVersionUID = -7707535225640407083L;
	public Integer id;
	public String name;

	public Classes(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Classes() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
		return "Classes [id=" + id + ", name=" + name + "]";
	}
}
