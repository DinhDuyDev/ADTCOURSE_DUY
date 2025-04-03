public interface Circular {
    public static final double piConstant = 3.14;

    /** sets the radius of the circle
     * @param radius 
     */
    public void setRadius(double radius);

    /** Computes the perimeter of a circle
     * @param radius 
     * @return perimeter if radius > 0
     * @throws Error if radius < 0
     */
    public double getPerimeter();

    /**
     * @param radius
     * @return area of circle if radius > 0
     * @throws Error if radius < 0 
     */
    public double getArea();
}