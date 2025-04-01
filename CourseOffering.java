import java.util.ArrayList;
public class CourseOffering {
    private boolean isAPClass;
    private int timesAvailable;
    private ArrayList<Integer> periodsInUse = new ArrayList<>();
    private ArrayList<String> roomsInUse = new ArrayList<>();
    private int courseId;
    private Teacher teacher;
    private int id;
    public CourseOffering(int courseId, Teacher teacher, int id, boolean isAP){
        timesAvailable= (int)(Math.random()*6);
        this.courseId=courseId;
        this.teacher=teacher;
        this.id=id;
        isAPClass = isAP;
    }

    public void addPeriodInuse(int x){
        periodsInUse.add(x);
    }
    public void addRoomsInUse(String room){
        roomsInUse.add(room);
    }
    public ArrayList<String> getRoomsInUse(){
        return roomsInUse;
    }

    public void decrementTimesAvailable(){
        timesAvailable--;
    }
    public boolean canBeUsed(){
        return timesAvailable!=0;
    }

}
