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
        Rover rover = new RoverParser().parsePosition(position);
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

    private IllegalArgumentException invalidPlateauException() {
        return new IllegalArgumentException("Invalid plateau string!");
    }


}
