package it.corso;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class MainTest {
	

	@Test
	void somma() {
		assertEquals(true, Main.controllaPari(2, 2));
		assertEquals(false, Main.controllaPari(2, 3));
		assertEquals(true, Main.controllaPari(3, 2));
		assertEquals(false, Main.controllaPari(3, 3));
	}
	

}
