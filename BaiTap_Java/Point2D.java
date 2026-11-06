import java.util.Locale;
import java.util.Objects;

/** Represents an immutable point in a two-dimensional coordinate system. */
public class Point2D {
    private final double x;
    private final double y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    /** Returns the Euclidean distance from this point to another 2D point. */
    public double distanceTo(Point2D other) {
        Objects.requireNonNull(other, "other must not be null");
        return Math.hypot(x - other.x, y - other.y);
    }

    /** Returns the point symmetric to this one through the origin. */
    public Point2D symmetric() {
        return new Point2D(-x, -y);
    }

    /** Returns a new point translated by the given x and y offsets. */
    public Point2D translate(double dx, double dy) {
        return new Point2D(x + dx, y + dy);
    }

    @Override
    public String toString() {
        return String.format(Locale.ROOT, "Point2D(x=%.2f, y=%.2f)", x, y);
    }
}
