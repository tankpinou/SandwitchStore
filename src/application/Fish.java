package application;

import java.util.ArrayList;

//import javax.swing.text.html.HTMLDocument.Iterator;

 //import java.util.ArrayList;

public class Fish extends Sandwich {
	
	protected String [] fishBase= {"Grilled Snapper","Cilantro","Lime"};
	
	public Fish() {
       extras = new ArrayList<Extra>();
	}

	
	@Override
	public double price() {
		
		return 12.99+(extras.size()*1.99);
	}
	
	
public String getFishIngredients() {
		
		String toBereturn="";
		for (int i =0;i<fishBase.length;i++) {
			toBereturn += fishBase[i]+", ";
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
	
	output= "Fish Sandwich ".concat(getFishIngredients() + getIngredients());
	
	return output;
}



}
