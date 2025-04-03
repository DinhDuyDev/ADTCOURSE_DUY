package work2;
public class CollegeStudent extends Student {
    private int year; // Year of graduation
    private String degree; // Degree sought

    public CollegeStudent() {
        super();
        year = 0;
        degree = "";
    } // end of default constructor

    public CollegeStudent(Name studentName, String studentID, int graduationYear, String degreeSought) {
        super(studentName, studentID);
        year = graduationYear;
        degree = degreeSought;
    } // end of parametrized constructor

}