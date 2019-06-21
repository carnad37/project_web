package com.test2;

public class DAO {

	public int testMethod(MyValue mv) {
		int i = 0;
		aaa(mv);
		return i;
	}
	
	public MyValue aaa (MyValue mv) {
		mv.setYhea("String");
		return mv;
	}
}
