import java.util.Arrays;
import java.util.stream.Collectors;

class Polyline {
    private final Point[] points;

    public Polyline(Point[] points) {
        this.points = points;
    }

    public Point[] getPoints(){
        return points;
    }

    public String toString() {
        String pointsString = Arrays.stream(points)
                .map(Point::toString)
                .collect(Collectors.joining(","));
        return String.format("Линия [%s]", pointsString);
    }
}

