import java.util.Objects;

class Point {
    private Double x;
    private Double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point otherC = (Point) obj;
        return this.getX().equals(otherC.getX()) && this.getY().equals(otherC.getY());
    }

    @Override
    public int hashCode() { //без этого переписанный equals не работает корректно
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return String.format("{%.1f;%.1f}", x, y);
    }
}