import java.util.ArrayList;
public class CourseOffering {
    private int timesAvailable;
    private ArrayList<Integer> periodsInUse = new ArrayList<>();
    private ArrayList<String> roomsInUse = new ArrayList<>();
    private int courseId;
    private int teacherId;
    private int id;
    public CourseOffering(int courseId, int teacherId, int id){
        timesAvailable= (int)(Math.random()*6);
        this.courseId=courseId;
        this.teacherId=teacherId;
        this.id=id;
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
