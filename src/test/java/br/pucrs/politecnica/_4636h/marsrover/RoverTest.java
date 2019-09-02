package br.pucrs.politecnica._4636h.marsrover;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class RoverTest {

	Rover rover;

	@Test
	public void moveForwardTest() {

		// Arrange
		rover = new Rover(0, 0, 'N');
		// Act
		rover.runInstructions("MM");
		// Assert
		assertEquals("0 2 N", rover.getPositionAsString());

	}

	@Test
	public void spinLeftTest() {

		// Arrange
		rover = new Rover(0, 0, 'N');
		// Act
		rover.runInstructions("L");
		// Assert
		assertEquals("0 0 W", rover.getPositionAsString());
	}

	@Test
	public void spinRightTest() {

		// Arrange
		rover = new Rover(0, 0, 'N');
		// Act
		rover.runInstructions("R");
		// Assert
		assertEquals("0 0 E", rover.getPositionAsString());
	}

	@Test
	public void roverDirecaoInvalidaDeveLancarExcecao() {

		// Arrange
		rover = new Rover(0, 0, 'N');
		String instructions = "0, 1, 'K'";
		// Act
		assertThrows(IllegalArgumentException.class, () -> rover.runInstructions(instructions));
	}

}
