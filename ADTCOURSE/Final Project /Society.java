import java.util.List;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Society extends Organization {
    private Map<Person, List<Person>> graphL;

    public Society(Person hd, String name) {
        super(hd, name);
        graphL = new HashMap<>();
        graphL.put(hd, new LinkedList<>());

        functions = new String[] {
            "PRINT-ORGANIZATION",
            "RECRUIT-MEMBER-AT",
            "SOCIETY-ATTACK-AT",
            "KILL-BOSS",
            "END-TURN"
        };
    }

    public Person getHead() {
        return head;
    }
    /**
     * Remove a person from the organization
     * @param p // Person to remove
     */
    public void removePerson(Person p) {
        graphL.remove(p, graphL.get(p));
        boolean foundBoss = false;
        for (Person person : graphL.keySet()) {
            if (p.returnType() == "BOSS" && !foundBoss) {
                person.promote();
                head = person;
                foundBoss = true;
            }
            if (!foundBoss) {
                head = null;
            }
            graphL.get(person).remove(p);
        }
        updateOnMap();
    }

    /**
     * Adds a person to the organization
     * @param p // Person to add
     */
    public void addPerson(Person p) {
        p.personId = currPersonnelID ++;
        p.myOrganization = this;
        graphL.put(p, new LinkedList<>());
        for (Person person : graphL.keySet()) {
            if (person != p) {
                graphL.get(person).add(p);
                graphL.get(p).add(person);
            }
        }
        coordinatesList.add(new int[] {p.xCoordinate, p.yCoordinate});
        updateOnMap();
    }

    /**
     * Returns the person for the id
     * @param id of the node needed to find
     * @return the person object
     */
    public Person getPerson(int id) {
        for (Person person : graphL.keySet()) {
            if (person.personId == id) {
                return person;
            }
        }
        return null;
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

        for (Person person : graphL.keySet()) {
            WorldMap.personMap[person.yCoordinate][person.xCoordinate] = person;
            coordinatesList.add(new int[] {person.xCoordinate, person.yCoordinate});
        }
    }

    // Return a list of all members
    public Person[] getAllPersons() {
        return graphL.keySet().toArray(new Person[graphL.keySet().size()]);
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
        return "MAP";
    }

    // Print out the organization
    public void printOrganization() {
        for (Person p : graphL.keySet()) {
            System.out.println(p);
        }
    }
}
