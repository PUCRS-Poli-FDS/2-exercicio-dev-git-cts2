package br.pucrs.politecnica._4636h.marsrover;

public enum Direction {
    NORTH('N'),
    SOUTH('S'),
    EAST('E'),
    WEST('W');

    private final char value;

    Direction(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public static Direction fromValue(char value) {
        for (Direction i : Direction.values()) {
            if (i.value == value) {
                return i;
            }
        }
        return null;
    }
}
