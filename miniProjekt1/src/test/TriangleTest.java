package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Triangle;

class TriangleTest {
	
	@DisplayName("Testing triangle where all the sides are the same")
	@Test
	public void testAllSameSideTriangle() {
		Triangle triangle = new Triangle(3, 3, 3);
		assertEquals(Triangle.TYPE.EQUILATERAL, triangle.getCurrent_type());
	}
	
	@DisplayName("Testing triangle where 2 of the sides are the same")
	@Test
	public void testTwoSameSidesTriangle() {
		Triangle triangle = new Triangle(3, 3, 4);
		assertEquals(Triangle.TYPE.ISOSCELES, triangle.getCurrent_type());
	}
	
	@DisplayName("Testing triangle where all the sides are different")
	@Test
	public void testOneSameSidesTriangle() {
		Triangle triangle = new Triangle(3, 4, 5);
		assertEquals(Triangle.TYPE.SCALENE, triangle.getCurrent_type());
	}
	
	@DisplayName("Testing something that is not a triangle")
	@Test
	public void testNotATriangle() {
		Triangle triangle = new Triangle(1, 2, 3);
		assertNull(triangle.getCurrent_type());
	}
	
	@DisplayName("Testing triangle with negative value")
	@Test
	public void testNegativeSideTriangle() {
		Triangle triangle = new Triangle(-1, 2, 3);
		assertNull(triangle.getCurrent_type());
	}
	
	@DisplayName("Testing the triangle constructor with StringArray")
	@Test
	public void testConstructor() {
		Triangle triangle1 = new Triangle(new String[] {"3", "4", "5"});
		assertEquals(Triangle.TYPE.SCALENE, triangle1.getCurrent_type());
		
		Triangle triangle2 = new Triangle(new String[] {"1", "2"});
		assertNull(triangle2.getCurrent_type());
		
		Triangle triangle3 = new Triangle(new String[] {"a", "b", "c"});
		assertNull(triangle3.getCurrent_type());
	}
	
	@DisplayName("Testing user input")
	@Test
	public void testUserInput() {
		ByteArrayInputStream input = new ByteArrayInputStream("3,4,5".getBytes());
		System.setIn(input);
		
		Triangle triangle = new Triangle();
		triangle.getUserInput();
		assertEquals(Triangle.TYPE.SCALENE, triangle.getCurrent_type());
		
		System.setIn(System.in);
	}

}
