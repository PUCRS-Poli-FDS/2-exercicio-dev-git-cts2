package br.pucrs.politecnica._4636h.marsrover;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RoverTest {

    private Rover rover;

	@BeforeEach
	public void setUp() {
		rover = new Rover(0, 0, 'N');
	}


	@Test
	public void moveForwardTest() {

		
		// Act
		rover.runInstructions("MM");
		// Assert
		assertEquals(2, rover.getY());

	}

	@Test
	public void spinLeftTest() {

		// Act
		rover.runInstructions("L");
		// Assert
		assertEquals('W', rover.getDirection());
	}

	@Test
	public void spinRightTest() {

		// Act
		rover.runInstructions("R");
		// Assert
		assertEquals('E', rover.getDirection());
	}

	@Test
	public void runInvalidInstructionShouldThrowException() {

		// Arrange
		rover = new Rover(0, 0, 'N');
		String instructions = "0, 1, K";
		// Act
		assertThrows(IllegalArgumentException.class, () -> rover.runInstructions(instructions));
	}

}
