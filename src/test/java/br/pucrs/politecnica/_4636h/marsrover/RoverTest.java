package br.pucrs.politecnica._4636h.marsrover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RoverTest {

    private Rover rover;

	@BeforeEach
	public void setUp() {
		rover = new Rover(0, 0, Direction.NORTH);
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
		assertEquals(Direction.WEST, rover.getDirection());
	}

	@Test
	public void spinRightTest() {

		// Act
		rover.runInstructions("R");
		// Assert
		assertEquals(Direction.EAST, rover.getDirection());
	}

	@Test
	public void runInvalidInstructionShouldThrowException() {

		// Act		
		String instructions = "0, 1, K";
		// Assert
		assertThrows(IllegalArgumentException.class, () -> rover.runInstructions(instructions));
	}

}
