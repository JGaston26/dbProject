import java.util.ArrayList;
public class CourseOffering {
    private ArrayList<Integer> periodsInUse = new ArrayList<>();
    private ArrayList<Integer> roomsInUse = new ArrayList<>();
    private ArrayList<Integer> courseOfferingIds;
    private int courseID;
    private Teacher teacher;
    private Room room;
    private int enrolled= 0;
    private int availableIdIndex = 0;
    public CourseOffering(ArrayList<Integer> courseOfferingIds, Teacher teacher, Room room, int courseID){
        this.courseOfferingIds=courseOfferingIds;
        this.courseID = courseID;
        this.teacher=teacher;
        this.room = room;
    }

    public void addPeriodInuse(int x){
        periodsInUse.add(x);
    }
    public void addRoomsInUse(int room){
        roomsInUse.add(room);
    }
    public ArrayList<Integer> getRoomsInUse(){
        return roomsInUse;
    }
    public ArrayList<Integer> getPeriodsInUse(){return periodsInUse;}
    public ArrayList<Integer> getCourseOfferingIds(){return courseOfferingIds;}
    public int getCourse(){return courseID;}
    public int getTeacherID(){return teacher.getId();}
    public void checkEnrolled(){
        enrolled++;
        if(enrolled > 50){
            enrolled = 0;
            availableIdIndex++;
        }
    }
    public int getAvailableIdIndex(){
        if(courseOfferingIds.isEmpty()){
            return -1;
        }
        if(availableIdIndex>=courseOfferingIds.size()){
            return courseOfferingIds.get((int)(Math.random()*courseOfferingIds.size()));
        }
        return courseOfferingIds.get(availableIdIndex);
    }


}
