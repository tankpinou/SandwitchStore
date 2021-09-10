package application;

import java.util.ArrayList;

public class Order implements Customizable {

	private int lineNumber	;
	private ArrayList<OrderLine> orderlines;
	
	public Order() {
		lineNumber = 0;
		orderlines= new ArrayList<OrderLine>();

	}
	
	
	@Override
	public boolean add(Object obj) {
		
		OrderLine order= (OrderLine)obj;
		
		if (orderlines.add(order)) {
			setLineNumber(+ 1);
			return true;	
		}
		
		return false;
	}
	
	
	@Override
	public boolean remove(Object obj) {
		if(orderlines.remove(obj)) {
			orderlines.remove(obj);
			setLineNumber(- 1);
			return true;
		}
			  
		return false;
	}

	public ArrayList<OrderLine> getOrderLines (){
		return orderlines;
	}

	public void resetOrderlines() {
		orderlines= new ArrayList<OrderLine>();
		lineNumber = 1;
	}

	public int getLineNumber() {
		return lineNumber;
	}


	public void setLineNumber(int lineNumber) {
		this.lineNumber += lineNumber;
	}

}
	
