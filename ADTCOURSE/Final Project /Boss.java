public class Boss extends Person {
    public Boss() {
        super();
    }
    public Boss(int x, int y) {
        super(x, y);
        type = "BOSS";
    }

    public String returnType() {
        return type;
    }
}
