import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class Saab95test {

    public Saab95 saab = new Saab95();

    @Test
    public void saab_turbo_should_be_false_at_start(){
        assertFalse(saab.turboOn);
    }
    @Test
    public void saab_doors_should_be_two(){
        assertEquals(2, saab.nrDoors);
    }
    @Test
    public void color_should_be_black() {
        assertEquals(Color.red, saab.color);
    }
    @Test
    public void saab_enginePower() {
        assertEquals(125, saab.enginePower, 0.01);
    }

    @Test
    public void speedFactor_should_be_constant(){
        Saab95 saab = new Saab95();
        saab.setTurboOff();
        assertEquals(1.25, saab.speedFactor(), 0.01);
    }
    @Test
    public void speedFactor_with_turbo(){
        Saab95 saab = new Saab95();
        saab.setTurboOn();
        assertEquals(1.625, saab.speedFactor(), 0.01);
    }
}
