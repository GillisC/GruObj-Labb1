import org.junit.Test;

import java.awt.*;
import java.awt.image.ConvolveOp;
import java.security.InvalidParameterException;

import static org.junit.Assert.*;

public class CarTest {

    public Volvo240 volvo = new Volvo240();
    public Saab95 saab = new Saab95();

    @Test
    public void volvo_doors_four(){
        assertEquals(4, volvo.getNrDoors());
    }
    @Test
    public void volvo_engine_100(){
        assertEquals(100, volvo.getEnginePower(), 0.01);
    }
    @Test
    public void car_should_turn_45_degrees() {
        Volvo240 volvo = new Volvo240();
        volvo.dir = 315;
        volvo.turnLeft();
        assertEquals(0, volvo.dir);
    }
    @Test
    public void test_both_startEngine(){
        volvo.startEngine();
        assertEquals(0.1, volvo.getCurrentSpeed(), 0.01);
    }
    @Test
    public void get_color(){
        volvo.setColor(Color.yellow);
        assertEquals(Color.yellow, volvo.getColor());
    }
    @Test
    public void should_not_be_able_to_incrementSpeed_with_engine_off(){
        Volvo240 volvo = new Volvo240(); // A car should not be able to accelerate without the engine being on
        volvo.stopEngine();
        volvo.incrementSpeed(1);
        assertEquals(0, volvo.getCurrentSpeed(), 0.01);
    }
    @Test
    public void move_not_should_move_if_engineOff(){
        Volvo240 volvo = new Volvo240();
        volvo.dir = 45;
        volvo.stopEngine();
        volvo.move();
        assertEquals(0, volvo.x, 0.01);
    }
    @Test
    public void should_move_if_engineOn() throws InvalidParameterException {
        Volvo240 volvo = new Volvo240();
        volvo.dir = 90;
        volvo.y = 0;
        volvo.startEngine();
        volvo.gas(1);
        volvo.move();
        assertTrue(volvo.y > 0);
    }
    @Test
    public void brake_should_lower_currentSpeed() throws InvalidParameterException {
        Volvo240 volvo = new Volvo240();
        volvo.startEngine();
        volvo.gas(1);
        double v0 = volvo.getCurrentSpeed();
        volvo.brake(0.5);
        assertTrue(volvo.getCurrentSpeed() < v0);
    }
    @Test
    public void turn_right_should_45(){
        Volvo240 volvo = new Volvo240();
        volvo.dir = 90;
        volvo.turnRight();
        assertEquals(45, volvo.dir);
    }
    @Test
    public void exceptionShouldBeThrownGas(){
        InvalidParameterException thrown =  assertThrows(InvalidParameterException.class, () -> {
            Volvo240 volvo = new Volvo240();
            volvo.gas(10);
        });
    }
    @Test
    public void exceptionShouldBeThrownBrake(){
        InvalidParameterException thrown =  assertThrows(InvalidParameterException.class, () -> {
            Volvo240 volvo = new Volvo240();
            volvo.brake(10);
        });
    }


}
