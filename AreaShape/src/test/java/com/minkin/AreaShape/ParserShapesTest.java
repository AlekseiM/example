package com.minkin.AreaShape;


import java.io.FileNotFoundException;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ParserShapesTest {
	@Rule
	public final ExpectedException thrown = ExpectedException.none();

	private static ParserShapes parserShapes;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		parserShapes = new ParserShapes();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testParserShapes() {
		//assertNotNull(ParserShapes.id);
		//fail("Not yet implemented");
	}

	@Test
	public void testPerform() throws FileNotFoundException{
		thrown.expect(FileNotFoundException.class);
		parserShapes.perform("text.x");
		
		//fail("Not yet implemented");
	}

}
