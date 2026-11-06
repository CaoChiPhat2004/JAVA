import java.util.Locale;
import java.util.Objects;

/** Represents an immutable 3D point and inherits its x and y coordinates from Point2D. */
public class Point3D extends Point2D {
    private final double z;

    public Point3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double getZ() {
        return z;
    }

    /** Returns the Euclidean distance from this point to another 3D point. */
    public double distanceTo(Point3D other) {
        Objects.requireNonNull(other, "other must not be null");
        double dx = getX() - other.getX();
        double dy = getY() - other.getY();
        double dz = z - other.z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    /** Overrides the 2D method so the z coordinate is reflected as well. */
    @Override
    public Point3D symmetric() {
        return new Point3D(-getX(), -getY(), -z);
    }

    /** Translates x and y while keeping the z coordinate unchanged. */
    @Override
    public Point3D translate(double dx, double dy) {
        return new Point3D(getX() + dx, getY() + dy, z);
    }

    /** Returns a new point translated by the given x, y, and z offsets. */
    public Point3D translate(double dx, double dy, double dz) {
        return new Point3D(getX() + dx, getY() + dy, z + dz);
    }

    @Override
    public String toString() {
        return String.format(Locale.ROOT, "Point3D(x=%.2f, y=%.2f, z=%.2f)", getX(), getY(), z);
    }
}
