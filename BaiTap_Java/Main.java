import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        // A Point3D is also a Point2D, so one list can contain both types.
        List<Point2D> points = new ArrayList<>();
        points.add(new Point2D(1, 2));
        points.add(new Point3D(1, 2, 3));
        points.add(new Point2D(4, 6));
        points.add(new Point3D(4, 6, 3));
        points.add(new Point2D(-2, 3));
        points.add(new Point3D(-2, 3, 6));

        System.out.println("Danh sách điểm ban đầu:");
        printPoints(points);

        double total2D = totalDistance2D(points);
        double total3D = totalDistance3D(points);
        System.out.printf(Locale.ROOT, "\nTổng quãng đường các điểm 2D: %.2f%n", total2D);
        System.out.printf(Locale.ROOT, "Tổng quãng đường các điểm 3D: %.2f%n", total3D);

        // The translate methods return new points and leave the original list unchanged.
        System.out.println("\nVí dụ tịnh tiến:");
        System.out.println("Điểm 2D sau khi tịnh tiến (dx=2, dy=-1): "
                + points.get(0).translate(2, -1));
        Point3D first3D = (Point3D) points.get(1);
        System.out.println("Điểm 3D sau khi tịnh tiến (dx=1, dy=-2, dz=0.5): "
                + first3D.translate(1, -2, 0.5));

        // Collect first so that the list is not modified while it is being traversed.
        List<Point2D> symmetricPoints = new ArrayList<>();
        for (Point2D point : points) {
            symmetricPoints.add(point.symmetric());
        }
        points.addAll(symmetricPoints);

        System.out.println("\nDanh sách sau khi thêm các điểm đối xứng:");
        printPoints(points);
    }

    /** Sums distances between consecutive 2D points in their appearance order. */
    private static double totalDistance2D(List<Point2D> points) {
        Point2D previous = null;
        double total = 0;

        for (Point2D point : points) {
            if (!(point instanceof Point3D)) {
                if (previous != null) {
                    total += previous.distanceTo(point);
                }
                previous = point;
            }
        }
        return total;
    }

    /** Sums distances between consecutive 3D points in their appearance order. */
    private static double totalDistance3D(List<Point2D> points) {
        Point3D previous = null;
        double total = 0;

        for (Point2D point : points) {
            if (point instanceof Point3D) {
                Point3D current = (Point3D) point;
                if (previous != null) {
                    total += previous.distanceTo(current);
                }
                previous = current;
            }
        }
        return total;
    }

    private static void printPoints(List<Point2D> points) {
        for (int i = 0; i < points.size(); i++) {
            System.out.printf("%2d. %s%n", i + 1, points.get(i));
        }
    }
}
