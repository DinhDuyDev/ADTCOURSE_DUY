public class Circle implements Circular {
    double radius;
    public void setRadius(double _radius) {
        radius = _radius;
    }
    public double getPerimeter() {
        double answer = radius * 2 * piConstant;
        return answer;
    }
    public double getArea() {
        double answer = ArithmeticOps.Power(radius, 2) * piConstant;
        return answer;
    }
}
