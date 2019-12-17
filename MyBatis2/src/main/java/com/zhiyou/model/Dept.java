package com.zhiyou.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dept implements Serializable {

	private Integer DEPTION;

	private String DNAME;

	private String LOC;
	// 一个部门中需要注入多个员工
	private List<Emp> emps;

	public Dept(Integer dEPTION, String dNAME, String lOC) {
		super();
		DEPTION = dEPTION;
		DNAME = dNAME;
		LOC = lOC;
	}

}
