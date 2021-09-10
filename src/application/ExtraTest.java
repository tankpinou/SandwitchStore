package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ExtraTest {

	@Test
	void testExtra() {
		//fail("Not yet implemented");
		
		Chicken chicken = new Chicken();
		Extra item = new Extra("Onions");
		assertEquals(item.toString(),"Onions");
		
	}

	@Test
	void testSetExtra() {
		//fail("Not yet implemented");
		Extra item = new Extra("Empanadas");
		item.setExtra("Oregano");
		assertTrue(item.toString().equals("Oregano"));
	}

	@Test
	void testToString() {
		//fail("Not yet implemented");
		Extra item = new Extra("Ranch");
		assertTrue(item.toString().equals("Ranch"));

	}

}
