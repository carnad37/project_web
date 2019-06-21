package com.test;

import java.util.HashMap;
import java.util.Map;

public class MainTest {

	public static void main(String[] args) {
		Map<String, Command> testMap = new HashMap<String, Command>();
		Command test = null;
		test = new ACommand();
		testMap.put("ACommand",test);
		test = new BCommand();
		testMap.put("BCommand",test);
		test = new CCommand();
		testMap.put("CCommand",test);

		testMap.get("BCommand").testMethod();
	}
	
}
