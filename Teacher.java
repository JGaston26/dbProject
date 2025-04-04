import java.util.ArrayList;
import java.util.Arrays;
public class Teacher {
    private int department;
    private int id;
    private String name;
    private ArrayList<Integer> availablePeriods = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));

    public Teacher(String name, int department, int id){
        this.name=name;
        this.department=department;
        this.id=id;
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
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getDepartment(){
        return department;
    }
}
