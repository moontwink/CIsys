package test;

import static org.junit.Assert.*;
import main.Main;

import org.junit.Test;

public class TestMain {

	@Test
	public void test() {
		String helloWorld = Main.helloWorld();
		assertEquals("Hello World!",helloWorld);
	}

}
