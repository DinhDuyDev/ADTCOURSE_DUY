import java.util.List;
import java.util.LinkedList;

public class Organization {
    protected boolean defunct;
    protected Person head;
    protected int currPersonnelID = 0;
    protected List<int[]> coordinatesList; // list of all members' coordinates
    public String[] functions;
    protected String name;

    public Organization(Person hd, String name) {
        defunct = false;
        head = hd;
        head.personId = currPersonnelID ++;
        head.myOrganization = this;
        coordinatesList = new LinkedList<>();
        coordinatesList.add(new int[] {head.xCoordinate, head.yCoordinate});
        this.name = name;
    }

    public Person getHead() {
        return head;
    }

    /**
     * Remove a person from the organization
     * @param p // Person to remove
     */
    public void removePerson(Person p) {
        if (head == p) {
            head = null;
            defunct = true;
        } else {
            removeHelp(head, p);
        }
    }

    private void removeHelp(Person rt, Person p) {
        if (rt.children.isEmpty()) {
            return;
        } else {
            for (Person person : rt.children) {
                if (person == p) {
                    rt.children.remove(person);
                    break;
                } else {
                    removeHelp(person, p);
                }
            }
        }
    }

    /**
     * Adds a person to the organization
     * @param p // Person to add
     * @param boss // The boss to add the organization after
     */
    public void addPerson(Person boss, Person p) {
        addHelper(head, boss, p);
    }
    
    private void addHelper(Person curr, Person boss, Person p) {
        if (curr == boss) {
            p.personId = currPersonnelID++;
            boss.addSubordinate(p);
            coordinatesList.add(new int[] {p.xCoordinate, p.yCoordinate}); 
        } else {
            for (Person person : curr.children) {
                addHelper(person, boss, p);
            }
        }
    }


    /**
     * Returns the person for the id
     * @param id
     * @return
     */
    public Person getPerson(int id) {
        return getHelper(head, id);
    }

    private Person getHelper(Person rt, int id) {
        if (rt == null) {
            return null;
        }
        if (rt.personId == id) {
            return rt;
        } else {
            for (Person child : rt.children) {
                Person get = getHelper(child, id);
                if (get != null) {
                    return get;
                }
            }
        }
        return null;
    }

    /**
     * Returns the children for the specified
     * @param id
     * @return
     */
    public List<Person> getChildren(Person person) {
        return person.children;
    }

    /**
     * Update all personnel on map
     * @param map
     */
    public void updateOnMap() {
        while (!coordinatesList.isEmpty()) {
            int[] lastCoords = coordinatesList.getLast();
            if (WorldMap.personMap[lastCoords[1]][lastCoords[0]].myOrganization == this) {
                int[] coords = coordinatesList.removeLast();
                WorldMap.personMap[coords[1]][coords[0]] = null;
            }
        }
        if (!defunct) {
            updateHelper(head);
        }
    }

    private void updateHelper(Person p) {
        System.out.println(WorldMap.personMap[p.yCoordinate][p.xCoordinate]);
        WorldMap.personMap[p.yCoordinate][p.xCoordinate] = p;
        coordinatesList.add(new int[] {p.xCoordinate, p.yCoordinate});
        for (Person child : p.children) {
            updateHelper(child);
        }
    }

    // True if the organization is dead, false if not
    public boolean getDefunct() {
        return defunct;
    }

    // Return organization type
    public String returnType() {
        return "GENERAL_TREE";
    }

    /**
     * Returns a list of children
     * @param boss
     * @return
     */
    public List<Person> listChildren(Person boss) {
        return boss.children;
    }

    // Print out the organization
    public void printOrganization() {
        if (head == null) {
            return;
        }
        System.out.println(head);
        if (!head.children.isEmpty()) {
            for (Person person : head.children) {
                printHelper(person, 3);
            }
        }
     }
    
    private void printHelper(Person rt, int spaces) {
        String space = "";
        for (int i = 0; i < spaces; i ++) {
            space += " ";
        }
        System.out.println(space + rt.toString());
        for (Person person : rt.children) {
            printHelper(person, spaces + 3);
        }
    }

    /**
     * Adds a person to the organization
     * @param p // Person to add
     */
    public void addPerson(Person p) {

    }
    
    public void checkDefunct() {
        
    }
    // Return a list of all members
    public Person[] getAllPersons() {
        return new Person[0];
    }

}
