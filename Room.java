import java.util.ArrayList;
import java.util.Arrays;

public class Room {
    private ArrayList<Integer> availablePeriods = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
    private int id;
    private String name;
    public Room(int initID, String name){
        this.name=name;
        id=initID;
    }

    public void removePeriod(int period){
        ArrayList<Integer> returnArray = new ArrayList<>();

        for (Integer availablePeriod : availablePeriods) {
            if (availablePeriod != period) {
                returnArray.add(availablePeriod);
            }
        }
        availablePeriods=returnArray;
    }

    public boolean checkIfPeriodExists(int period){
        for(Integer periodIn: availablePeriods){
            if(periodIn==period){
                return true;
            }
        }
        return false;
    }

    public ArrayList<Integer> getAvailablePeriods(){
        return availablePeriods;
    }



}
