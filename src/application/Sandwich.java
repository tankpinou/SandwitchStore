package application;

import java.util.ArrayList;

public abstract class Sandwich implements Customizable {
	
	static final int MAX_EXTRA=6;
	static final double PER_EXTRA =1.99; 
	protected ArrayList<Extra> extras;
	
	public abstract double price () ;


	@Override
	public boolean add (Object obj) {
		
		
		Extra e = new Extra(obj.toString());
		
		if(!extras.contains(e)) {
			extras.add(new Extra (String.valueOf(obj)));
			
		}
	
		
	return true;
	}

	@Override
	public boolean remove(Object obj){
		
		return true;
	}
	public String getIngredients() {
		
		String var="";
		
		for(int i =0; i < extras.size();i++)
			var = var + extras.get(i).toString()+", ";
		
		return 	var;	//extras.get(1).toString();

		
	}

}
