import org.junit.Test;

import java.awt.*;
import java.awt.image.ConvolveOp;

import static org.junit.Assert.assertEquals;

public class CarTest {

    public Volvo240 volvo = new Volvo240();
    public Saab95 saab = new Saab95();


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
        Volvo240 volvo = new Volvo240();
        volvo.stopEngine();
        volvo.incrementSpeed(10);
        assertEquals(0, volvo.getCurrentSpeed(), 0.01);
    }
//    @Test
//    public void next_position(){
//        Volvo240 volvo = new Volvo240();
//        volvo.x = 0;
//        volvo.y = 0;
//        volvo.startEngine();
//        volvo.gas(0.9);
//        volvo.dir = 90;
//        volvo.move();
//        assertEquals(1, volvo.y);
//    }
    @Test
    public void turn_right_should_45(){
        Volvo240 volvo = new Volvo240();
        volvo.dir = 90;
        volvo.turnRight();
        assertEquals(45, volvo.dir);
    }


}
