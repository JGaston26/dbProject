import java.util.ArrayList;
public class CourseOffering {
    private int timesAvailable;
    private ArrayList<Integer> periodsInUse = new ArrayList<>();
    private ArrayList<String> roomsInUse = new ArrayList<>();
    private int courseId;
    private Teacher teacher;
    private int id;
    private Room room;
    public CourseOffering(int courseId, Teacher teacher, int id, Room room){
        timesAvailable= (int)(Math.random()*6);
        this.courseId=courseId;
        this.teacher=teacher;
        this.id=id;
        this.room = room;
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
    public int getTimesAvailable(){
        return timesAvailable;
    }
    public boolean canBeUsed(){
        return timesAvailable!=0;
    }

}
