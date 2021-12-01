import java.awt.*;

public class Truck extends Car {
    private Platform platform;

    public Truck(int nrDoors, Color color, double enginePower, String modelName, Platform platform) {
        super(nrDoors, color, enginePower, modelName);
        this.platform = platform;
    }

    @Override
    public void startEngine() throws PlatformWhileMovingException {
        platform.lock();
        super.startEngine();
    }

    @Override
    public void gas(double amount) throws PlatformWhileMovingException {
        platform.lock();
        super.gas(amount);
    }

    @Override
    public void brake(double amount) {
        super.brake(amount);
        if (getCurrentSpeed() == 0)
            platform.unlock();
    }
}
