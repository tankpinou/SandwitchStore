package application;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class OrderTest {

	@Test
	void testAdd() {
		//fail("Not yet implemented");
		Order order = new Order();
		OrderLine orderline = new OrderLine();
		order.add(orderline);
		assertTrue(!order.getOrderLines().isEmpty());
		
	}

	@Test
	void testRemove() {
		// fail("Not yet implemented");
		Order order = new Order();
		OrderLine orderline = new OrderLine();
		order.add(orderline);
		order.remove(orderline);
		assertTrue(order.getOrderLines().isEmpty());
	}

	@Test
	void testGetOrderLines() {
		// fail("Not yet implemented");
		Order order = new Order();
		OrderLine orderline = new OrderLine();
		order.add(orderline);
		ArrayList<OrderLine> var = order.getOrderLines();
		assertTrue(var.size()==1);
	}

	@Test
	void testResetOrderlines() {
		// fail("Not yet implemented");
		Order order = new Order();
		OrderLine orderline = new OrderLine();
		order.add(orderline);
		order.resetOrderlines();
		assertTrue(order.getOrderLines().isEmpty());
	}

	@Test
	void testGetLineNumber() {
		// fail("Not yet implemented");
		Order order = new Order();
		OrderLine orderline = new OrderLine();
		
		order.add(orderline);
		
		int s = order.getLineNumber();
		assertEquals(s , 1);
	}


}
