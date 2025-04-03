public class ArithmeticOps {
    /** Powering 
     * @param realnumber
     * @param indices
     * @return squarednum 
     */
    public static double Power(double realnumber, double indices) {
        double answer = 1;
        for (int i=0; i<indices; i++) {
            answer *= realnumber;
        }
        return answer;
    }
}