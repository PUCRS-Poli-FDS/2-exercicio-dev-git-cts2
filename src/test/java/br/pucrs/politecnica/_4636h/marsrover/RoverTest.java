package br.pucrs.politecnica._4636h.marsrover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverTest {

    private Rover rover;

	@BeforeEach
	public void setUp() {
		rover = new Rover(0, 0, Direction.NORTH);
	}


	@Test
	public void moveForwardTest() {
        List<Instruction> instructions = new LinkedList<>();
        instructions.add(Instruction.MOVE_FORWARD);
        instructions.add(Instruction.MOVE_FORWARD);
		
		// Act
		rover.runInstructions(instructions);
		// Assert
		assertEquals(2, rover.getY());

	}

	@Test
	public void spinLeftTest() {
	    List<Instruction> instructions = new LinkedList<>();
	    instructions.add(Instruction.SPIN_LEFT);

		// Act
		rover.runInstructions(instructions);
		// Assert
		assertEquals(Direction.WEST, rover.getDirection());
	}

	@Test
	public void spinRightTest() {
        List<Instruction> instructions = new LinkedList<>();
        instructions.add(Instruction.SPIN_RIGHT);

        // Act
        rover.runInstructions(instructions);
		// Assert
		assertEquals(Direction.EAST, rover.getDirection());
	}
}
