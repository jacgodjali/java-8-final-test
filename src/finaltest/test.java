package finaltest;


import static org.junit.Assert.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import finaltest.main;

public class test {
	
	String inputFile = "studentname.txt";
	
	@Test
	public void fourLengthName() throws Exception {	
		assertEquals(main.fourLengthName(inputFile, 4), "Cody");
	}
	
	@Test
	public void vName() throws Exception{	
		assertEquals(main.vName(inputFile), "Devon");
	}
	
	@Test
	public void allUpperCase() throws Exception{	
		assertEquals(main.allUpperCase(inputFile), "HARRY");
	}
	
	@Test
	public void longestName() throws Exception{	
		assertEquals(main.longestName(inputFile), "Desiree");
	}
	
	@Test
	public void shortestNameWithoutY() throws Exception{	
		assertEquals(main.shortestNameWithoutY(inputFile, "Y"), "Devon");
	}
	
	@Test
	public void storeNewAscendingly() throws Exception{
		String outputFile = "ascending.txt";
		main.storeNewAscendingly(inputFile, outputFile);
		assertNotNull(Paths.get(outputFile));
		
		List<String> result = Files.lines(Paths.get(outputFile)).collect(Collectors.toList());
		assertEquals(result.get(0), "Amy");
		assertEquals(result.get(1), "Archie");
		assertEquals(result.get(6), "Larry");
		assertEquals(result.get(9), "Tammy");
		assertEquals(result.size(), 10);
	}
	
	@Test
	public void storeNewAscendingUppercase() throws Exception{
		String outputFile = "ascendingUppercase.txt";
		main.storeNewAscendingUppercase(inputFile, outputFile);
		assertNotNull(Paths.get(outputFile));
		
		List<String> result = Files.lines(Paths.get(outputFile)).collect(Collectors.toList());
		assertEquals(result.get(0), "AMY");
		assertEquals(result.get(1), "ARCHIE");
		assertEquals(result.get(6), "LARRY");
		assertEquals(result.get(9), "TAMMY");
		assertEquals(result.size(), 10);
	}
}
