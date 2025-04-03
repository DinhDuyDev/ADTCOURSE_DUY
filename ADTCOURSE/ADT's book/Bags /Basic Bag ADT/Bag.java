import java.util.ArrayList;
import java.util.List;
public class Bag<T> implements BagInterface<T> {
    private List<T> listOfEntries;
    private int entryLimit = 10;

    public Bag () {
        this.listOfEntries = new ArrayList<>();
    } // end Bag

    public int getCurrentSize() {
        return this.listOfEntries.size();
    } // end getCurrentSize
    
    public boolean isEmpty() {
        return (this.listOfEntries.size() == 0);
    } // end isEmpty

    public boolean add(T newEntry) {
        boolean canAdd = true;
        if (this.listOfEntries.size() < entryLimit) {
            this.listOfEntries.add(newEntry);
        } else {
            canAdd = false;
        }
        return canAdd;
    } // end add

    public T remove() {
        int lastElementInd = listOfEntries.size()-1;
        if (listOfEntries.size() > 0) {
            T removedEntry = listOfEntries.get(lastElementInd);
            listOfEntries.remove(lastElementInd);
            return removedEntry;
        }
        return null;
    } // end remove

    public boolean remove(T anEntry) {
        int indexOfEntry = listOfEntries.indexOf(anEntry);
        if (indexOfEntry != -1) {
            listOfEntries.remove(indexOfEntry);
            return true;
        } else {
            return false;
        }
    } // end remove

    public boolean contains(T anEntry) {
        return listOfEntries.contains(anEntry);
    } // end contains

    public int getFrequencyOf(T anEntry) {
        int frequency = 0;
        for (int i=0; i<listOfEntries.size(); i++) {
            if (anEntry == listOfEntries.get(i)) {
                frequency++;
            }
        }
        return frequency;
    } // end getFrequencyOf

    public void clear() {
        listOfEntries.clear();
    } // end clear

    public String toArray() {
        return "Bag {" +
        "items=" + this.listOfEntries
        + "}";
    } // end toArray

    public BagInterface<T> union(BagInterface<T> anEntry) {
        BagInterface<T> newBag = new Bag<>();
        List<T> getArray = new ArrayList<T>();
        while (!this.isEmpty()) {
            T removedEntry = this.remove();
            getArray.add(removedEntry);
        }
        while (!getArray.isEmpty()) {
            
        }
        return newBag;
    }
}
