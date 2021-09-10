package application;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ChickenTest {

	@Test
	void testPrice() {
		
		Chicken Chicken1 = new Chicken();
		Chicken Chicken2 = new Chicken();
		assertEquals(Chicken2.price() , Chicken2.price(), 8.99);
	}

	@Test
	void testGetIngredients() {
		
		Chicken Chicken1 = new Chicken();
		Chicken1.add("Mayo");		
				String  s = Chicken1.getIngredients();
					assertEquals(s,"Mayo,");
					
				
	}

	@Test
	void testGetchickenIngredients() {
		
		Chicken Chicken1 = new Chicken();			
				String  s = Chicken1.getchickenIngredients();	
					
			assertEquals(s,"Fried Chicken, Spicy Sauce, Pickles, ");
	}

	@Test
	void testToString() {
		Chicken Chicken = new Chicken();
		
		String  s = Chicken.toString();
			
			assertEquals(s,"Chicken Sandwich Fried Chicken, Spicy Sauce, Pickles, ");
		
	}

}
