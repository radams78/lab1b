import java.awt.*;
import java.util.Stack;

class Loader<T extends Car> {
    private Point position;
    private Stack<T> contents;

    public void load(T car) throws LoadException {
        {
            double distance = position.distance(car.getPosition());
            if (distance < 0.5) {
                throw new LoadException(
                        String.format("Attempted to load car at distance of %.2f", distance)
                );
            }
        }
        if (contents.contains(car)) {
            throw new LoadException("Attempted to load car already on transport");
        }
    }

    public T unload() throws LoadException {
        if (contents.isEmpty())
            throw new LoadException("Attempted to unload empty container");

        return contents.pop();
    }

    public void setPosition(Point p) {
        position = p;
        for (T car : contents) {
            car.setPosition(p);
        }
    }
}
