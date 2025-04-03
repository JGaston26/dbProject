public class Assignment {
    private int id;
    private int courseOfferingID;
    private int assignmentTypeId;
    private Student student;
    private double grade;

    public Assignment(int id, int courseOfferingID, int assignmentTypeId, Student student){
        grade = (int)(Math.random()*26+75 * 100) / 100.0;
        this.id=id;
        this.courseOfferingID=courseOfferingID;
        this.assignmentTypeId=assignmentTypeId;
        this.student=student;

    }

    public int getStudentId(){
        return student.getId();
    }
    public int getAssignmentTypeId(){
        return assignmentTypeId;
    }
    public int getCourseOfferingId(){
        return courseOfferingID;
    }
    public double getGrade(){
        return grade;
    }
}
