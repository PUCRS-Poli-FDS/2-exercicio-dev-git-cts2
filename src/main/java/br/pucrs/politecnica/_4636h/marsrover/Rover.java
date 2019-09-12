package br.pucrs.politecnica._4636h.marsrover;

public class Rover {

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

	public void runInstructions(Iterable<Instruction> instructions) {
	    instructions.forEach(this::runInstruction);
	}

	public void runInstruction(Instruction instruction) {
		switch (instruction) {
            case SPIN_LEFT:
                spinLeft();
                break;
            case SPIN_RIGHT:
                spinRight();
                break;
            case MOVE_FORWARD:
                moveForward();
                break;
		}
	}

	public String getPositionAsString() {
		return String.format("%d %d %c", x, y, direction.getValue());
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
