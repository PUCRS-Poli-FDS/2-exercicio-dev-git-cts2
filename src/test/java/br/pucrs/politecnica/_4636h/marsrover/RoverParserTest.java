package br.pucrs.politecnica._4636h.marsrover;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class RoverParserTest {

	@Test
	public void parsePositionTest(){
		RoverParser jorge = new RoverParser();
		Rover rover = jorge.parsePosition("10 20 N");
		assertEquals(10, rover.getX());
		assertEquals(20, rover.getY());
		assertEquals('N', rover.getDirection());
		
	}
	
	/*x y e pro direction*/
	
/*	@Test
	public void parseY() {
		RoverParser
		
	}
	*/	
		
}
