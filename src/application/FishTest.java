package application;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FishTest {

	@Test
	void testPrice() {
		
		//fail("Not yet implemented");
				Fish Fish1 = new Fish();
				Fish Fish2 = new Fish();
				assertEquals(Fish1.price() , Fish2.price(), 8.99);
	}

	@Test
	void testGetIngredients() {
		//fail("Not yet implemented");
		Fish Fish = new Fish();
		Fish.add("Mayo");		
				String  s = Fish.getIngredients();
					assertEquals(s,"Mayo,");
	}

	@Test
	void testGetFishIngredients() {
		//fail("Not yet implemented");
		Fish Fish = new Fish();			
		String  s = Fish.getFishIngredients();	
			
	assertEquals(s,"Grilled Snapper, Cilantro, Lime, ");
	}

	@Test
	void testToString() {
		//fail("Not yet implemented");
		Fish Fish = new Fish();
		
		String  s = Fish.toString();
			
			assertEquals(s,"Fish Sandwich Grilled Snapper, Cilantro, Lime, ");
		
	}

}
