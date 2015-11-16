package com.minkin.AreaShape.model;

import java.util.ArrayList;

public class Shape implements Runnable {

	private String color;
	private int id;
	private ArrayList<Float> sides = new ArrayList<>();
	private float diameter;

	Shape() {

	}

	public void printArea() {

	}

	public void run() {

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

	public void addSide(float side) {
		sides.add(side);
	}

}
