public class AssignmentTable {
    private int AssignmentID;
    private CourseOffering CourseOffering;
    private int AssignmentTypeID;
    private Student StudentID;
    private int Grade;

    public AssignmentTable(int AssignmentID,CourseOffering courseOffering,int AssignmentTypeID, Student studentID){
        this.AssignmentID=AssignmentID;
        this.CourseOffering=courseOffering;
        this.AssignmentTypeID=AssignmentTypeID;
        this.StudentID=studentID;
        Grade= (int) (Math.random() * 26 + 75);
    }

    public int getID(){
        return AssignmentID;
    }
    public int getGrade(){
        return Grade;
    }
    public Student getStudentID(){
        return StudentID;
    }

    public int getAssignmentID() {
        return AssignmentID;
    }

    public int getAssignmentTypeID() {
        return AssignmentTypeID;
    }

}
