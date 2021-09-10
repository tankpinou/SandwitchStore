package application;

import java.util.ArrayList;

//import java.util.ArrayList;

public class Beef extends Sandwich{
    
	protected String [] beefbaseIngredients= {"Roast Beef","Provolone Cheese","Mustard"};
	
	public Beef(){ 
	       extras = new ArrayList<Extra>();
		
		}
		
	@Override
	public double price() {
		
		return 10.99+(extras.size()*1.99);
	}
	
public String getBaseIngredients() {
		
		String toBereturn="";
		for (String s: beefbaseIngredients) {
			toBereturn += s+", ";
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
	
	output= "Beef Sandwich ".concat(getBaseIngredients()).concat(getIngredients());
	
	return output;
	}


}
