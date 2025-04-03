class MainOutput {
    static Circular circle = new Circle();
    public static void main(String[] args) {
        circle.setRadius(10);
        System.out.println(circle.getArea());
        System.out.println(circle.getPerimeter());
    }
}