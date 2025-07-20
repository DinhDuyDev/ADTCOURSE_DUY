
public class Utilities {
    public static double pointDistance(int a, int b, int x, int y) {
        return Math.sqrt(Math.pow((x-a), 2) + Math.pow((y-b), 2));
    }

    public static boolean array_contains(String[] arr, String x) {
        for (String s : arr) {
            if (s.compareTo(x) == 0) {
                return true;
            }
        }
        return false;
    }

    public static void space_out(int spaces) {
        for (int i = 0; i < spaces; i++) {
            System.out.println("");
        }
    }

    public static int random(int maxVal) {
        return (int) (Math.random() * (maxVal + 1));
    }
}
