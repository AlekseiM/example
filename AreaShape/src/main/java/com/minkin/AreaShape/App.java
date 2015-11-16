package com.minkin.AreaShape;

public class App {

	public static void main(String[] args) {

		String fileName = args.length == 0 ? "text.xml" : args[0];
		
		ParserShapes parserShapes = new ParserShapes();
		parserShapes.perform(fileName);
	}

}
