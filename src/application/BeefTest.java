package application;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Assert;

import org.junit.jupiter.api.Test;

class BeefTest {

	@Test
	void testPrice() {
		
		Beef beef1 = new Beef();
		Beef beef2 = new Beef();
		assertEquals(beef1.price() , beef2.price(), 10.99);
		
	}

	@Test
	void testGetBaseIngredients() {
		
		Beef beef1 = new Beef();
		
		String  s = beef1.getBaseIngredients();
			
			assertEquals(s,"Roast Beef, Provolone Cheese, Mustard, ");
			
		
	}

	@Test
	void testToString() {
		Beef beef1 = new Beef();
		
		String  s = beef1.toString();
			
			assertEquals(s,"Beef Sandwich Roast Beef, Provolone Cheese, Mustard, ");
		
	}

	@Test
	void testAddString() {
		
		Beef beef1 = new Beef();
		beef1.add("Mayo");
		
		
		assertFalse(beef1.extras.isEmpty());
		
		
	}

}
