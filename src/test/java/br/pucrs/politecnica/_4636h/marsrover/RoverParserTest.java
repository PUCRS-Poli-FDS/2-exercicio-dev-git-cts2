package br.pucrs.politecnica._4636h.marsrover;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class RoverParserTest {


	
	/*x y e pro direction*/
	
	@Test
	public void parseY() {
		assertThrows(IllegalArgumentException.class, () -> new RoverParser().parsePosition("20 20 N"));	
		
	}
	
	@Test
	public void parsePositionTest(){
		RoverParser jorge = new RoverParser();
		Rover rover = jorge.parsePosition("10 20 N");
		assertEquals(10, rover.getX());
		assertEquals(20, rover.getY());
		assertEquals('N', rover.getDirection());
		
	}
	
		
}
