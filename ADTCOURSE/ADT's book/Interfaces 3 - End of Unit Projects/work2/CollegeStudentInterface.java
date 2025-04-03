package work2;
public interface CollegeStudentInterface {
    /** setting the student's values
     * 
     * @param studentName
     * @param studentID
     * @param graduationYear
     * @param degreeSought
     */
    public void setStudent(Name studentName, String studentID, int graduationYear, String degreeSought);
    /**
     * 
     * @return super.toString() + ", " + degree + ", " + year;
     */
    public String toString();
}

/*
 * I WOULD CHANGE REMOVE THE Name interface and replace the datatype for the studentName field with String
 */