import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class CountrySorterList {
  Node firstNode;
  Node lastNode;
  String indicator;

  private class Node {
    private Country data;
    private Node next;
    private Node previous;

    private Node(Country dataPortion) {
      this(dataPortion, null);
    } // end constructor

    private Node(Country dataPortion, Node nextNode) {
      data = dataPortion;
      next = nextNode;
    } // end constructor
  } // end Node

  public CountrySorterList(String ind, String filename) {
    indicator = ind;
    File inputFile = new File(filename);
    Scanner scanner = null;
    try {
      scanner = new Scanner(inputFile);
    } catch (FileNotFoundException e) {
      System.err.println(e);
      System.exit(1);
    }
    scanner.nextLine();
    while (scanner.hasNextLine()) {
      Country newCountry = new Country(scanner.nextLine());
      this.add(newCountry);
    } 
    scanner.close();
  }

  private void add(Country newEntry) {
    Node newCountry = new Node(newEntry);
    CountryComparator comparator = new CountryComparator(indicator);
    if (firstNode == null) {
      firstNode = newCountry;
    } else if (lastNode == null) {
      if (comparator.compare(newCountry.data, firstNode.data) < 0) {
        firstNode.previous = newCountry;
        newCountry.next = firstNode;
        lastNode = firstNode;
        firstNode = newCountry;
      } else {
        lastNode = newCountry;
        firstNode.next = lastNode;
        lastNode.previous = firstNode;
      }
    } else {
      Node curr = firstNode;
      Node prev = firstNode.previous;
      while (curr != null) {
        if (comparator.compare(newCountry.data, curr.data) >= 0) {
          prev = curr;
          curr = curr.next;
        } else {
          break;
        }
      }
      if (prev == null) {
        firstNode.previous = newCountry;
        newCountry.next = firstNode;
        firstNode = newCountry;
      } else if (curr == null) {
        lastNode.next = newCountry;
        newCountry.previous = lastNode;
        lastNode = newCountry;
      } else {
        newCountry.next = curr;
        newCountry.previous = prev;
        prev.next = newCountry;
        curr.previous = newCountry;
      }
    }
  }

  public void output(int num, String statName) {
    Node curr = this.firstNode;
    System.out.println("Lowest:");
    for (int i=0; i<num; i++) {
      System.out.println(i+1 + ". " + curr.data.getName() + " " + curr.data.getStat(statName));
      curr = curr.next;
    }
    curr = this.lastNode;
    System.out.println("------");
    System.out.println("Highest:");
    for (int i=0; i<num; i++) {
      System.out.println(i+1 + ". " + curr.data.getName() + " " + curr.data.getStat(statName));
      curr = curr.previous;
    }
  }

  public static void main(String[] args) {
    CountrySorterList newList = new CountrySorterList(args[2], args[0]);
    int count = Integer.parseInt(args[1]);
    newList.output(count, args[2]);
  }
}
