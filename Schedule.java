public class Schedule {
    private Student StudentID;
    private CourseOffering CourseOffering;

    public Schedule(Student studentID,CourseOffering courseOffering){
        this.StudentID =studentID;
        this.CourseOffering=courseOffering;
    }

    public Student getStudentID(){
        return StudentID;
    }
    public CourseOffering getCourseOffering(){
        return CourseOffering;
    }
}
