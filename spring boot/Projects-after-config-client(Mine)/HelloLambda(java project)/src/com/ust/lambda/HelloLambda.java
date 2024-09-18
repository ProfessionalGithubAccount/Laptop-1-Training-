package com.ust.lambda;

public class HelloLambda {
	public String handleRequest() {
		return "Hello AWS Lambda";
		
	}
	
	public String myNewMethodWithParameters(String name) {
		return "Hello"+name;
	}
	
	//In aws lambda ..go to edit runtime settings
	//Then type com.ust.lambda.HelloLambda::handleRequest() :: saying to execute the method..<packagename>.<classname>::<Methodname>

}
