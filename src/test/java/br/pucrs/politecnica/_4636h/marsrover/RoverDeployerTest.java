package br.pucrs.politecnica._4636h.marsrover;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class RoverDeployerTest {

    @Test
    public void validateClassConstructor() {
        RoverDeployer deployer = new RoverDeployer("8 9");

        assertEquals(8, deployer.getPlateauX());
        assertEquals(9, deployer.getPlateauY());
    }

    @Test
    public void invalidPlateauArgumentMustThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new RoverDeployer("10"));
    }

    @Test
    public void validateFirstDeploy() {
        RoverDeployer deployer = new RoverDeployer("5 5");

        String result = deployer.deploy("1 2 N", "LMLMLMLMM");

        assertEquals("1 3 N", result);
    }

    @Test
    public void validateSecondDeploy() {
        RoverDeployer deployer = new RoverDeployer("5 5");

        String result = deployer.deploy("3 3 E", "MMRMMRMRRM");

        assertEquals("5 1 E", result);
    }

}
