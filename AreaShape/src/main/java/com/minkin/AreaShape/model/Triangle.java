package com.minkin.AreaShape.model;

import java.util.ArrayList;

public class Triangle extends Shape {

	private String color;
	private int id;
	private ArrayList<Float> sides = new ArrayList<>();

	public Triangle() {

	}

	public void printArea() {

		float p = (sides.get(0) + sides.get(1) + sides.get(2)) / 2;
		float area = (float) Math.sqrt(p * (p - sides.get(0)) * (p - sides.get(1)) * (p - sides.get(2)));
		System.out.printf(id + ":" + color + " - " + "%.2f" + "\n", area);

	}

	public void run() {

		float p = (sides.get(0) + sides.get(1) + sides.get(2)) / 2;
		float area = (float) Math.sqrt(p * (p - sides.get(0)) * (p - sides.get(1)) * (p - sides.get(2)));
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
