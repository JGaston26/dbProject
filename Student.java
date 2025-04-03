import java.util.ArrayList;
import java.util.Arrays;

public class Student {
    private int id;

    public Student(int id){
        this.id=id;
    }

    private ArrayList<Integer> availablePeriods = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
    public void removePeriod(int period){
        ArrayList<Integer> returnArray = new ArrayList<>();

        for (Integer availablePeriod : availablePeriods) {
            if (availablePeriod != period) {
                returnArray.add(availablePeriod);
            }
        }
        availablePeriods=returnArray;
    }

    public ArrayList<Integer> getAvailablePeriods(){
        return availablePeriods;
    }
    public int getId(){
        return id;
    }
}
