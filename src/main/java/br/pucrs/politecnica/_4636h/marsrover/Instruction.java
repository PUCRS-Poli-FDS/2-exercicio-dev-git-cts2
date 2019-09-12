package br.pucrs.politecnica._4636h.marsrover;

public enum Instruction {
    SPIN_LEFT('L'),
    SPIN_RIGHT('R'),
    MOVE_FORWARD('M');

    private final char value;

    Instruction(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public static Instruction fromValue(char value) {
        for (Instruction i : Instruction.values()) {
            if (i.value == value) {
                return i;
            }
        }
        return null;
    }
}
