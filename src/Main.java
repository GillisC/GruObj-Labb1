import java.awt.*;

public class Main {

    public static void main(String[] args) {
        Saab95 saab = new Saab95();
        Volvo240 volvo = new Volvo240();
        volvo.brake(2);
        volvo.startEngine();
        volvo.incrementSpeed(10);

    }
}
