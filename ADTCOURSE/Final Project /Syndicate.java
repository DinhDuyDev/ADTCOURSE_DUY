import java.util.List;

public class Syndicate extends Organization {

    public Syndicate(Person hd, String name) {
        super(hd, name);
        functions = new String[] {
            "PRINT-ORGANIZATION",
            "SELECT-BOSS",
            "SETTLE",
            "RECRUIT-SUBORDINATE-AT",
            "ATTACK-AT",
            "END-TURN",
        };
    }

    /**
     * Remove a person from the organization
     * @param p // Person to remove
     */
    public void removePerson(Person p) {
        if (head == p) {
            head = null;
            defunct = true;
            updateOnMap();
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
            //p.xCoordinate = boss.xCoordinate;
            //p.yCoordinate = boss.yCoordinate;
            boss.addSubordinate(p);
            p.myOrganization = this;
            coordinatesList.add(new int[] {p.xCoordinate, p.yCoordinate}); 
            updateOnMap();
        } else {
            for (Person person : curr.children) {
                addHelper(person, boss, p);
            }
        }
    }

    /**
     * Update all personnel on map
     * @param map
     */
    public void updateOnMap() {
        while (!coordinatesList.isEmpty()) {
            int[] coords = coordinatesList.removeLast();
            if (WorldMap.personMap[coords[1]][coords[0]] != null) {
                if (this.getPerson(WorldMap.personMap[coords[1]][coords[0]].personId) == null) {
                    WorldMap.deadPeople.add(WorldMap.personMap[coords[1]][coords[0]]); // means they're dead.
                }
            }
            WorldMap.personMap[coords[1]][coords[0]] = null;
        }
        if (!defunct) {
            updateHelper(head);
        }
    }

    private void updateHelper(Person p) {
        WorldMap.personMap[p.yCoordinate][p.xCoordinate] = p;
        coordinatesList.add(new int[] {p.xCoordinate, p.yCoordinate});
        for (Person child : p.children) {
            updateHelper(child);
        }
    }

    // True if the organization is dead, false if not

    public void checkDefunct() {
        if (head == null) {
            defunct = true;
        }
    }
    public boolean getDefunct() {
        return defunct;
    }

    // Return organization type
    public String returnType() {
        return "TREE";
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
            printHelper(person, spaces + 5);
        }
    }
}
