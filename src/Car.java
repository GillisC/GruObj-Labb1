import java.awt.*;

abstract class Car {
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name
    protected double x;
    protected double y;
    protected int dir; // The Car's direction in Degrees
    protected boolean turboOn;
    protected boolean engineOn;

    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    protected void setColor(Color clr){
        color = clr;
    }

    protected void startEngine(){
        currentSpeed = 0.1;
        engineOn = true;
    }

    protected void stopEngine(){
        currentSpeed = 0;
        engineOn = false;
    }

    abstract public double speedFactor(); // Instantiated objects have to implement as they differ

    public void incrementSpeed(double amount){
        if (engineOn){
            currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
        }
        else{
            currentSpeed = 0;
        }
    }
    public void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }
    public void gas(double amount){
        incrementSpeed(amount);
    }

    public void brake(double amount){
        decrementSpeed(amount);
    }

    public void move(){
        this.x += getCurrentSpeed() * Math.cos(Math.toRadians(this.dir));
        this.y += getCurrentSpeed() * Math.sin(Math.toRadians(this.dir));
//        System.out.println("X: " + this.x );
//        System.out.println("Y: " + this.y );
    }
    public void turnLeft(){
        this.dir += 45;
        this.dir %= 360;
//        System.out.println("The " + this.modelName + " just turned left");
    }
    public void turnRight() {
        this.dir -= 45;
        this.dir %= 360;
//        System.out.println("The " + this.modelName + " just turned right");
    }
}
