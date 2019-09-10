package br.pucrs.politecnica._4636h.marsrover;

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

		return new Rover(x, y, direction);
	}

	private IllegalArgumentException invalidPositionException() {
		return new IllegalArgumentException("Invalid position string!");
	}
}
