package com.zhiyou.model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp implements Serializable {

	private Integer EMPNO;

	private String ENAME;

	private String JOB;

	private Integer MGR;

	private Date HIREDATE;

	private Integer SAL;

	private Integer COMM;

	private Integer DEPTNO;
	// 多对一 每个员工都有部门信息
	private Dept dept;
}
