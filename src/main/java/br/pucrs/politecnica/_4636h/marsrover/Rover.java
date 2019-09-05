package br.pucrs.politecnica._4636h.marsrover;

public class Rover {

	private static final String VALID_DIRECTION_CHARS = "NSWE";
	private static final String VALID_INSTRUCTION_CHARS = "LRM";

	private int x;
	private int y;
	private char direction;

	public Rover(int x, int y, char direction) {
		if (!isValidDirection(direction)) {
			throw new IllegalArgumentException("Invalid direction: " + direction);
		}

		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	public int getY() {
		return y;
	}

	public int getX() {
		return x;
	}

	public char getDirection() {
		return direction;
	}

	public void runInstructions(String instructions) {
		for (int i = 0, n = instructions.length(); i < n; i++) {
			char instruction = instructions.charAt(i);
			runInstruction(instruction);
		}
	}

	public void runInstruction(char instruction) {
		if (!isValidInstruction(instruction)) {
			throw new IllegalArgumentException("Invalid instruction: " + instruction);
		}

		switch (instruction) {
		case 'L':
			spinLeft();
			break;
		case 'R':
			spinRight();
			break;
		case 'M':
			moveForward();
			break;
		}
	}

	public String getPositionAsString() {
		return String.format("%d %d %c", x, y, direction);
	}

	private static boolean isValidDirection(char direction) {
		return VALID_DIRECTION_CHARS.indexOf(direction) != -1;
	}

	private static boolean isValidInstruction(char instruction) {
		return VALID_INSTRUCTION_CHARS.indexOf(instruction) != -1;
	}

	private void moveForward() {
		switch (direction) {
		case 'N':
			y++;
			break;
		case 'S':
			y--;
			break;
		case 'W':
			x--;
			break;
		case 'E':
			x++;
			break;
		}
	}

	private void spinLeft() {
		switch (direction) {
		case 'N':
			direction = 'W';
			break;
		case 'S':
			direction = 'E';
			break;
		case 'W':
			direction = 'S';
			break;
		case 'E':
			direction = 'N';
			break;
		}
	}

	private void spinRight() {
		switch (direction) {
		case 'N':
			direction = 'E';
			break;
		case 'S':
			direction = 'W';
			break;
		case 'W':
			direction = 'N';
			break;
		case 'E':
			direction = 'S';
			break;
		}
	}
}
