package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OrderLineTest {

	@Test
	void testToString() {
		//fail("Not yet implemented");
	}

	@Test
	void testGetPrice() {
		//fail("Not yet implemented");
		OrderLine orderLine = new OrderLine();
		orderLine.setLine(1, new Chicken());
		assertTrue(orderLine.getPrice()==8.99);
	}

	@Test
	void testSetSandwich() {
		//fail("Not yet implemented");
		OrderLine orderLine = new OrderLine();
		orderLine.setSandwich(new Fish());
		assertTrue(orderLine.getPrice()==12.99);
	}

	@Test
	void testGetSandwich() {
		//fail("Not yet implemented");
		OrderLine orderLine = new OrderLine();
		orderLine.setSandwich(new Beef());
		assertTrue(orderLine.getSandwich().price()==10.99);
	}

	@Test
	void testGetLineNumber() {
		//fail("Not yet implemented");
		OrderLine orderLine = new OrderLine();
		orderLine.setSandwich(new Beef());
		assertTrue(orderLine.getSandwich().price()==10.99);
		
	}

	@Test
	void testSetOrderLineNumber() {
		//fail("Not yet implemented");
		OrderLine orderLine = new OrderLine();
		orderLine.setSandwich(new Beef());
		int s = orderLine.getLineNumber();
		assertEquals(s,1);
	}

	@Test
	void testSetLine() {
		//fail("Not yet implemented");
		
		OrderLine orderLine = new OrderLine();
		Fish fish = new Fish();
		int s = orderLine.getLineNumber();
		
		orderLine.setLine(2,fish);
		
		assertTrue( s != orderLine.getLineNumber());
		assertTrue(orderLine.getPrice()== 12.99);
		
	}

}
