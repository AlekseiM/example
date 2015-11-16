package com.minkin.AreaShape.model;

public class Circle extends Shape {

	private String color;
	private int id;
	private float diameter;

	public Circle() {

	}

	public void printArea() {
		float area = (float) (java.lang.Math.PI / 4 * diameter * diameter);
		System.out.printf(id + ":" + color + " - " + "%.2f" + "\n", area);

	}

	public void run() {
		float area = (float) (java.lang.Math.PI / 4 * diameter * diameter);
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

	public float getDiameter() {
		return diameter;
	}

	public void setDiameter(float diameter) {
		this.diameter = diameter;
	}

}
