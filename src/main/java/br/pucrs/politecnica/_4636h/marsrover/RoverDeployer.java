package br.pucrs.politecnica._4636h.marsrover;

import java.util.Scanner;

public class RoverDeployer {

    private int plateauX;
    private int plateauY;

    public RoverDeployer(String plateau) {
        parsePlateau(plateau);
    }

    public int getPlateauX() {
        return plateauX;
    }

    public int getPlateauY() {
        return plateauY;
    }

    public String deploy(String position, String instructions) {
        Rover rover = parsePosition(position);
        rover.runInstructions(instructions);
        return rover.getPositionAsString();
    }

    private void parsePlateau(String plateau) {
        Scanner scanner = new Scanner(plateau);

        if (!scanner.hasNextInt()) {
            throw invalidPlateauException();
        }

        plateauX = scanner.nextInt();

        if (!scanner.hasNextInt()) {
            throw invalidPlateauException();
        }

        plateauY = scanner.nextInt();

        scanner.close();
    }

    private Rover parsePosition(String position) {
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

    private IllegalArgumentException invalidPlateauException() {
        return new IllegalArgumentException("Invalid plateau string!");
    }

    private IllegalArgumentException invalidPositionException() {
        return new IllegalArgumentException("Invalid position string!");
    }
}
