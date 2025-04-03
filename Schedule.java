public class Schedule {
    private Student student;
    private CourseOffering CourseOffering;
    private int scheduleID;

    public Schedule(int scheduleID, Student student,CourseOffering courseOffering){
        this.scheduleID=scheduleID;
        this.student = student;
        this.CourseOffering=courseOffering;
    }

    public int getStudentID(){
        return student.getId();
    }
    public CourseOffering getCourseOffering(){
        return CourseOffering;
    }
    public int getID(){
        return scheduleID;
    }
}
