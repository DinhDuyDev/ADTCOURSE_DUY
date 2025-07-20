import java.util.LinkedList;
import java.util.List;
public class WorldMap {
    public static int side = 40;
    public static String[][] worldMap;
    public static Person[][] personMap;
    public static boolean show_enemies;

    public static List<Person> deadPeople;

    public WorldMap() {
        worldMap = new String[side][side];
        personMap = new Person[side][side];
        deadPeople = new LinkedList<>();
        
        for (int i = 0; i < side; i ++) {
            for (int j = 0; j < side; j ++) {
                worldMap[i][j] = "...";
            }
        }
    } // end constructor 

    public String toString() {
        String str = "";
        for (int i = 0; i < side+1; i ++) {
            for (int j = 0; j < side+1; j ++) {
                if (i == 0) {
                    if (j == 0) {
                        str += "   ";
                    } else {
                        String delineate = " ";
                        if (j < 11) {
                            delineate = "  ";
                        }
                        str += delineate + (j-1) + " ";
                    }
                } else {
                    if (j == 0) {
                        String delineate = " ";
                        if (i < 11) {
                            delineate = "  ";
                        }
                        str += delineate + (i-1) + " ";
                    } else {
                        str += worldMap[i-1][j-1] + " ";
                    }
                }
            }
            str += "\n";
        }
        return str;
    }

    public static void printWorld() {
        String str = "";
        while (!deadPeople.isEmpty()) {
            Person deadperson = deadPeople.removeLast();
            worldMap[deadperson.yCoordinate][deadperson.xCoordinate] = "XXX";
        }
        for (int i = 0; i < side+1; i ++) {
            for (int j = 0; j < side+1; j ++) {
                if (i == 0) {
                    if (j == 0) {
                        str += "   ";
                    } else {
                        String delineate = " ";
                        if (j < 11) {
                            delineate = "  ";
                        }
                        str += delineate + (j-1) + " ";
                    }
                } else {
                    if (j == 0) {
                        String delineate = " ";
                        if (i < 11) {
                            delineate = "  ";
                        }
                        str += delineate + (i-1) + " ";
                    } else {
                        str += worldMap[i-1][j-1] + " ";
                    }
                }
            }
            str += "\n";
        }
        System.out.println(str);
    }

    // This is to update the graphics for the world map.
    public static void updateWorldMap() {
        for (int i = 0; i < side; i ++) {
            for (int j = 0; j < side; j ++) {
                worldMap[i][j] = "...";
            }
        }
        for (int i = 0; i < side; i ++) {
            for (int j = 0; j < side; j ++) {
                if (personMap[i][j] != null) {
                    String space = " ";
                    int pID = personMap[i][j].personId;
                    if (pID < 10) {
                        space = "  ";
                    }
                    if (personMap[i][j].myOrganization.name == Main.playerOrgName) {
                        worldMap[i][j] = space + String.valueOf(personMap[i][j].personId);
                    } 
                    if (personMap[i][j].returnType().compareTo("BOSS") == 0 && personMap[i][j].myOrganization.name == Main.playerOrgName) {
                        worldMap[i][j] = "BOS";
                    }
                } else {
                    worldMap[i][j] = "...";
                }
            }
        }
    }

    // Check if at a coordinate there is an obstruction
    public static boolean isEmpty(int x, int y) {
        if (x >= 0 && x < side && y > 0 && y < side) {
            return personMap[y][x] == null;
        } else {
            return false;
        }
    }

    public static boolean isInBound(int x, int y) {
        return x >= 0 && x < side && y >= 0 && y < side;
    }
}
