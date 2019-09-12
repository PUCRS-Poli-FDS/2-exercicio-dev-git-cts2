package br.pucrs.politecnica._4636h.marsrover;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class RoverParser {

	public Rover parsePosition(String position) {
		int x, y;
		char direction;
		Scanner scanner = new Scanner(position);

		if (!scanner.hasNextInt()) {
			throw invalidPositionException();
		}

		x = scanner.nextInt();

		if (!scanner.hasNextInt()) {
			throw invalidPositionException();
		}

		y = scanner.nextInt();

		if (!scanner.hasNext()) {
			throw invalidPositionException();
		}

		direction = scanner.next().charAt(0);

		return new Rover(x, y, Direction.fromValue(direction));
	}

	private IllegalArgumentException invalidPositionException() {
		return new IllegalArgumentException("Invalid position string!");
	}

	public List<Instruction> parseInstructions(String instructions) {
		List<Instruction> instructionsList = new LinkedList<>();

		for (int i = 0, j = instructions.length(); i < j; i++) {
			char instructionChar = instructions.charAt(i);
			Instruction instruction = Instruction.fromValue(instructionChar);

			if (instruction != null) {
				instructionsList.add(instruction);
			} else {
				throw new IllegalArgumentException("Invalid instruction: " + instructionChar);
			}
		}

		return instructionsList;
	}
}
