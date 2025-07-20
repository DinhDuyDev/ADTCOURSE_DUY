import java.util.List;
import java.util.LinkedList;

public class Crew extends Organization {
    private List<Person> personnelList;

    public Crew(Person hd, String name) {
        super(hd, name);
        personnelList = new LinkedList<>();
        personnelList.add(hd);

        functions = new String[] {
            "PRINT-ORGANIZATION",
            "SELECT-BOSS",
            "SETTLE",
            "RECRUIT-SUBORDINATE-AT",
            "ATTACK-AT",
            "END-TURN"
        };
    }
    // Returns the head of the organization
    public Person getHead() {
        return personnelList.getFirst();
    }

    /**
     * Remove a person from the organization
     * @param p // Person to remove
     */
    public void removePerson(Person p) {
        int currIndex = personnelList.indexOf(p);
        swap(currIndex, personnelList.size() - 1);
        personnelList.removeLast();
        heapifyDown(currIndex, hasLeftChild(currIndex), hasRightChild(currIndex));
        if (!personnelList.isEmpty()) {
            if (personnelList.getFirst().returnType() != "BOSS") {
                personnelList.getFirst().promote();
            }
        }
        updateOnMap();
    }

    /**
     * Adds a person to the organization
     * @param p // Person to add
     * @param boss // The boss to add the organization after
     */
    public void addPerson(Person boss, Person p) {
        p.personId = currPersonnelID ++;
        p.myOrganization = this;
        personnelList.add(p);
        coordinatesList.add(new int[] {p.xCoordinate, p.yCoordinate});
        int currentIndex = personnelList.size() - 1;
        heapifyUp(currentIndex);
        updateOnMap();
    }

    private void heapifyUp(int i) {
        int parentIndex = getParent(i);
        Person thisPerson = personnelList.get(i);
        Person parentPerson = personnelList.get(parentIndex);
        if (thisPerson.personId < parentPerson.personId) {
            swap(i, parentIndex);
        }
        if (parentIndex != 0) {
            heapifyUp(parentIndex);
        }
    }

    private void heapifyDown(int index, boolean hasLeft, boolean hasRight) {
        if (isLeaf(index)) {
            return;
        }

        Person currNode = personnelList.get(index);
        Person dominantChild = currNode;
        if (hasLeft && !hasRight) {
            Person leftChild = personnelList.get(getLeftChild(index));
            if (leftChild.personId < currNode.personId) {
                dominantChild = leftChild;
            }
        } else if (!hasLeft && hasRight) {
            Person rightChild = personnelList.get(getRightChild(index));
            if (rightChild.personId < currNode.personId) {
                dominantChild = rightChild;
            }
        } else {
            Person leftChild = personnelList.get(getLeftChild(index));
            Person rightChild = personnelList.get(getRightChild(index));
                
            if (leftChild.personId < rightChild.personId && leftChild.personId < currNode.personId) {
                dominantChild = leftChild;
            } else if(leftChild.personId > rightChild.personId && rightChild.personId < currNode.personId) {
                dominantChild = rightChild;
            }
        }

        if (dominantChild != currNode) {
            int dominantIndex = personnelList.indexOf(dominantChild);
            swap(personnelList.indexOf(dominantChild), personnelList.indexOf(currNode));
            heapifyDown(dominantIndex, hasLeftChild(dominantIndex), hasRightChild(dominantIndex));
        } 
    }

    private void swap(int a, int b) {
        Person personA = personnelList.get(a);
        Person personB = personnelList.get(b);
        Person tempPerson = new Person(personA.xCoordinate, personA.yCoordinate);
        personA.xCoordinate = personB.xCoordinate;
        personA.yCoordinate = personB.yCoordinate;
        personB.xCoordinate = tempPerson.xCoordinate;
        personB.yCoordinate = tempPerson.yCoordinate;

        personnelList.set(a, personB);
        personnelList.set(b, personA);
    }

    private int getParent(int index) {
        return (index - 1) / 2;
    }

    private int getLeftChild(int index) {
        return index * 2 + 1;
    }

    private int getRightChild(int index) {
        return index * 2 + 2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChild(index) < personnelList.size();
    }


    private boolean hasRightChild(int index) {
        return getRightChild(index) < personnelList.size();
    }

    private boolean isLeaf(int index) {
        return (!hasLeftChild(index) && !hasRightChild(index));
    }

    /**
     * Returns the person for the id
     * @param id of the node needed to find
     * @return the person object
     */
    public Person getPerson(int id) {
        for (Person person : personnelList) {
            if (person.personId == id) {
                return person;
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
        List<Person> list = new LinkedList<>();
        int parentIndex = personnelList.indexOf(person);
        if (hasLeftChild(parentIndex)) {
            list.add(personnelList.get((getLeftChild(parentIndex))));
        } 
        if (hasRightChild(parentIndex)) {
            list.add(personnelList.get((getRightChild(parentIndex))));
        }
        return list;
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

        for (Person person : personnelList) {
            WorldMap.personMap[person.yCoordinate][person.xCoordinate] = person;
            coordinatesList.add(new int[] {person.xCoordinate, person.yCoordinate});
        }
    }

    public void checkDefunct() {
        if (personnelList.isEmpty()) {
            defunct = true;
        }
    }
    // True if the organization is dead, false if not
    public boolean getDefunct() {
        return defunct;
    }

    // Return organization type
    public String returnType() {
        return "TREE";
    }

    // Print out the organization
    public void printOrganization() {
        if (getHead() != null) {
            printHelper(0, currPersonnelID);
        } else {
            System.out.println("[]");
        }
    }

    /**
     * Returns a list of children
     * @param boss
     * @return
     */
    public List<Person> listChildren(Person boss) {
        List<Person> childrenList = new LinkedList<>();
        int indexOfBoss = personnelList.indexOf(boss);
        if (hasLeftChild(indexOfBoss)) {
            childrenList.add(personnelList.get(getLeftChild(indexOfBoss)));
        }
        if (hasRightChild(indexOfBoss)) {
            childrenList.add(personnelList.get(getLeftChild(indexOfBoss)));
        }
        return childrenList;
    }

    private void printHelper(int p, int spaces) {
        String space = "";
        for (int i = 0; i < spaces; i ++) {
            space += " ";
        }
        Person rt = personnelList.get(p);
        int left = getLeftChild(p);
        int right = getRightChild(p);
        System.out.println(space + rt.toString());
        if (left < personnelList.size()) printHelper(left, spaces + 5);
        if (right < personnelList.size()) printHelper(right, spaces + 5);
    }
}
