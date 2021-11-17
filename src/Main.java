import java.awt.*;

public class Main {

    public static void main(String[] args) {
        Saab95 saab = new Saab95();
        Volvo240 volvo = new Volvo240();

        volvo.startEngine();
        volvo.incrementSpeed(10);
        for (int i=0; i<10; i++) {
            volvo.move();
            if (i % 3 == 0) {
                volvo.turnRight();
            }
        }
    }
}
