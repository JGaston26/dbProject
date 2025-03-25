import java.util.ArrayList;
import java.util.Arrays;
public class Teacher {
    private String department = "";
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
    public void setDepartment(String dept){
        department=dept;
    }
    public String getDepartment(){
        return department;
    }
}
