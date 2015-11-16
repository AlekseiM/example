package com.minkin.AreaShape.model;

import java.util.ArrayList;

public class Rectangle extends Shape {

	private String color;
	private int id;
	private ArrayList<Float> sides = new ArrayList<>();

	public Rectangle() {

	}

	public void printArea() {

		float area = (float) sides.get(0) * sides.get(1);
		System.out.printf(id + ":" + color + " - " + "%.2f" + "\n", area);

	}

	public void run() {

		float area = (float) sides.get(0) * sides.get(1);
		System.out.printf(id + ":" + color + " - " + "%.2f" + "\n", area);

	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void addSide(float side) {
		sides.add(side);
	}

}
