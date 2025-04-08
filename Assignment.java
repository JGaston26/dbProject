public class Assignment {
    private int id;
    private int courseOfferingID;
    private int assignmentTypeId;
    private int scheduleID;
    private double grade;

    public Assignment(int id, int courseOfferingID, int assignmentTypeId, int scheduleID){
        grade = (int)((Math.random()*25+75) * 100) / 100.0;
        this.id=id;
        this.courseOfferingID=courseOfferingID;
        this.assignmentTypeId=assignmentTypeId;
        this.scheduleID = scheduleID;

    }
    public int getId(){
        return id;
    }
    public int getScheduleID(){
        return scheduleID;
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
