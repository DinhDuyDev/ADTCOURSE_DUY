import java.util.ArrayList;
import java.util.List;

public class RecursionExtra {
    public static int power(int a, int b) {
        if (b == 0) {
            return 1;
        } else {
            return power(a, b-1) * a;
        }
    }

    public static void countdown(int n) {
        if (n == 0) {
            System.out.println(n);
        } else {
            System.out.println(n);
            countdown(n-1);
        }
    }

    public static int fib(int n) {
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else {
            return fib(n-1) + fib(n-2);  
        }
    }

    public static int countVal(Object val, List<? extends Object> lst) {
        if (lst.size() == 1) {
            if (lst.get(0) == val) {
                return 1;
            } else {
                return 0;
            }
        } else {
            int count = 0;
            if (lst.get(0) == val) {
                count = 1;
            } else {
                count = 0;
            }
            System.out.println(lst.toString());
            return count + countVal(val, lst.subList(1, lst.size()));
        }
    }

    public static int getMin(List<Integer> lst) {
        if (lst.size() == 1) {
            return lst.get(0);
        } else {
            int getInt = getMin(lst.subList(1, lst.size()));
            if (lst.get(0) < getInt) {
                return lst.get(0);
            } else {
                return getInt;
            }
        }
    }

    public static void countup(int n) {
        if (n > 0) {
            countup(n-1);
        }
        System.out.println(n);
    }

    public static int[] countFib(int n) {
        if (n == 1) {
            int[] result = {0, 1};
            return result;
        } else if (n == 2) {
            int[] result = {1, 1};
            return result;
        } else {
            int[] fib1 = countFib(n-1);
            int[] fib2 = countFib(n-2);
            int[] result = {fib1[0] + fib2[0], fib1[1] + fib2[1]};
            return result;
        }
    }

    public static int mod(int a, int b) {
        if (a-b < b) {
            return a - b;
        } else if (a == b) {
            return 0;
        } else {
            return mod(a-b, b);
        }
    }
    
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("Hello Sir");
        stringList.add("Hello Ma'am");
        stringList.add("Hello Ma'am");
        stringList.add("Hello Ma'am");
        stringList.add("Hello Ma'am");
        stringList.add("Hello Ma'am");
        stringList.add("Hello Ma'am");
        stringList.add("Hello Sir");

        List<Integer> intList = new ArrayList<>();
        intList.add(Integer.valueOf(100000));
        intList.add(Integer.valueOf(220340324));
        intList.add(Integer.valueOf(323452435));
        intList.add(Integer.valueOf(445654654));
        intList.add(Integer.valueOf(51234132));
        intList.add(Integer.valueOf(6125235));
        intList.add(Integer.valueOf(71345));
        intList.add(Integer.valueOf(81232304));

        System.out.println("Exercise 0: --------------" + power(4, 5));
        System.out.println("Exercise 1: --------------");
        countdown(10);
        System.out.println("Exercise 2: --------------");
        System.out.println(fib(8));
        System.out.println("Exercise 3: --------------");
        System.out.println(countVal("Hello Ma'am", stringList));
        System.out.println("Exercise 4: --------------");
        countup(10);
        System.out.println("Exercise 5: --------------");
        System.out.println(getMin(intList));
        System.out.println("Exercise 6: --------------");
        System.out.println(countFib(8)[1]);
        System.out.println("Exercise 7: --------------");
        System.out.println(mod(234239, 17));
    }
}
