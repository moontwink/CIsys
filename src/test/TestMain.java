package test;

import static org.junit.Assert.*;
import main.Main;

import org.junit.Test;

public class TestMain {

	@Test
	public void test() {
		Main main = new Main();
		String helloWorld = main.helloWorld();
		assertEquals("Hello World!",helloWorld);
	}

}
