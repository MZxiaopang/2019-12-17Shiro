package com.zhiyou.model;

import lombok.Data;


public class Authorty {

	private Integer id;
	private Integer roleId;
	private String authorty;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getAuthorty() {
		return authorty;
	}
	public void setAuthorty(String authorty) {
		this.authorty = authorty;
	}
	public Authorty(Integer id, Integer roleId, String authorty) {
		super();
		this.id = id;
		this.roleId = roleId;
		this.authorty = authorty;
	}
	public Authorty() {
		super();
	}
	@Override
	public String toString() {
		return "Authorty [id=" + id + ", roleId=" + roleId + ", authorty=" + authorty + "]";
	}
	
	
}
