package br.pucrs.politecnica._4636h.marsrover;

public class Rover {

	private static final String VALID_INSTRUCTION_CHARS = "LRM";

	private int x;
	private int y;
	private Direction direction;

	public Rover(int x, int y, Direction direction) {
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

	public Direction getDirection() {
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
		return String.format("%d %d %c", x, y, direction.getValue());
	}

	private static boolean isValidInstruction(char instruction) {
		return VALID_INSTRUCTION_CHARS.indexOf(instruction) != -1;
	}

	private void moveForward() {
		switch (direction) {
			case NORTH:
				y++;
				break;
			case SOUTH:
				y--;
				break;
			case EAST:
				x++;
				break;
			case WEST:
				x--;
				break;
		}
	}

	private void spinLeft() {
		switch (direction) {
			case NORTH:
				direction = Direction.WEST;
				break;
			case SOUTH:
				direction = Direction.EAST;
				break;
			case EAST:
				direction = Direction.NORTH;
				break;
			case WEST:
				direction = Direction.SOUTH;
				break;
		}
	}

	private void spinRight() {
		switch (direction) {
			case NORTH:
				direction = Direction.EAST;
				break;
			case SOUTH:
				direction = Direction.WEST;
				break;
			case WEST:
				direction = Direction.NORTH;
				break;
			case EAST:
				direction = Direction.SOUTH;
				break;
		}
	}
}
