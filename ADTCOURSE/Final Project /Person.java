import java.util.List;
import java.util.LinkedList;

public class Person {
    protected String type = "PERSON";
    public int personId;
    public int xCoordinate;
    public int yCoordinate;
    public int prevX;
    public int prevY;
    public List <Person> children = new LinkedList<>();
    public int childLimit = 100000;
    public Organization myOrganization;

    public Person() {} // end default constructor
    public Person(int x, int y) {
        init(x, y);
    }
    void init(int x, int y) {
        xCoordinate = x;
        yCoordinate = y;
        prevX = x;
        prevY = y;
    }
    public String returnType() {
        return type;
    }

    public void promote() {
        type = "BOSS";
    }

    public String toString() {
        return "[ X: " + xCoordinate + ", Y: " + yCoordinate + ", " + "Syndicate ID : " + personId + ", personType: " + returnType() + " ]";
    }
    
    public void updateSelfOnMap() {
        WorldMap.personMap[prevX][prevY] = null;
        WorldMap.personMap[yCoordinate][xCoordinate] = this;
    }

    public void addSubordinate(Person addSub) {
        if (children.size() <= childLimit) {
            children.add(addSub);
        } else {
            System.out.println("SUBORDINATE LIMIT REACHED!");
        }
    }
}
