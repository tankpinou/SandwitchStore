package application;

import java.text.DecimalFormat;
import java.util.*;

public class OrderLine {
	
	private int lineNumber;
	private Sandwich sandwich;
	private double price;
	
	DecimalFormat d = new DecimalFormat("0.00");
	
	public OrderLine() {
		lineNumber=1;
		sandwich = new Chicken();
		price = sandwich.price();
	}

	public OrderLine(OrderLine line) {
		this.lineNumber = line.lineNumber;
		this.sandwich = line.sandwich;
		this.price = line.price;
	}
/*
	public OrderLine(int serialNumber, Sandwich aSandwich) {
		lineNumber = serialNumber;
		sandwich =aSandwich;
		price = aSandwich.price();
	}
*/

	@Override
	public String toString() {
		String output="";
		output= lineNumber+" "+sandwich.toString()+"Price $"+d.format(price);
		return output;
	}
	
	public double getPrice() {
		return sandwich.price();
	}
	
	public void setSandwich (Sandwich aSandwich) {
		sandwich = aSandwich;
	}
	public Sandwich getSandwich() {
		return sandwich;
	}

	public int getLineNumber() {
		return lineNumber;
	}
	public void setOrderLineNumber(int num) {
		lineNumber = num;
	}

	public void setLine(int serialNumber, Sandwich aSandwich) {
		lineNumber = serialNumber;
		sandwich =aSandwich;
		price = aSandwich.price();
	}
	
	
	


}
