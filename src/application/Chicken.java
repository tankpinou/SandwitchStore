package application;

import java.util.ArrayList;

//import javax.swing.text.html.HTMLDocument.Iterator;

 //import java.util.ArrayList;

public class Chicken extends Sandwich {
	
	protected String [] chickenbaseIngredients= {"Fried Chicken","Spicy Sauce","Pickles"};
	
	public Chicken() {
       extras = new ArrayList<Extra>();
	}

	
	@Override
	public double price() {
		
		return 8.99+(extras.size()*1.99);
	}
	
	
public String getchickenIngredients() {
		
		String toBereturn="";
		for (int i =0;i<chickenbaseIngredients.length;i++) {
			toBereturn += chickenbaseIngredients[i]+", ";
		}
		return toBereturn;	
	}

public String getIngredients() {
	
	String var="";
	
	for(int i =0; i < extras.size();i++)
		var = var + extras.get(i).toString()+",";
	
	return 	var;	//extras.get(1).toString();

	
}


public String toString() {
String output="";
	
	output= "Chicken Sandwich ".concat(getchickenIngredients() + getIngredients());
	
	return output;
}




}
