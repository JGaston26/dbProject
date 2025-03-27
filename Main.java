import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> studentNames = getFileData("Students");
        ArrayList<String> teacherNames = getFileData("TeachersAndDepartments"); //no dupes
        ArrayList<String> roomNames = getFileData("Rooms");

        ArrayList<Teacher> teacherData = createTeachers(teacherNames);
        ArrayList<Student> studentData = createStudents(studentNames);
        ArrayList<Room> roomData = createRooms(roomNames);
        System.out.println(teacherData);
        System.out.println(studentData);
        System.out.println(roomData);
    }

    public static ArrayList<Teacher> createTeachers(ArrayList<String> teacherNames){
        ArrayList<Teacher> returnList = new ArrayList<>();
        int deptId=1;
        int teacherId=1;
        for(String name: teacherNames){
            if(name.equals("NEWDEPT")){deptId++;}
            else{
                returnList.add(new Teacher(name,deptId,teacherId));
                teacherId++;
            }

        }
      /*
      This doesn't work, gets up to Mr. Anderson at 276 and then gets an out-of-bounds error.
       */
        for(int i=0; i<=returnList.size(); i++){
            System.out.println("INSERT INTO Teachers(TeacherID,TeacherName,DepartmentID) " +
                    "VALUES (" + returnList.get(i).getId() +
                    ", '" + returnList.get(i).getName() + "', " +
                    returnList.get(i).getDepartment() + " );" );
        }
        return returnList;
    }
    public static ArrayList<Student> createStudents(ArrayList<String> studentNames) {
        ArrayList<Student> returnList = new ArrayList<>();
        int deptId=1;
        int studentId=1;
        for(String name: studentNames){
            returnList.add(new Student(studentId));
            studentId++;
        }
        return returnList;
    }
    public static ArrayList<Room> createRooms(ArrayList<String> rooms){
        ArrayList<Room> returnList = new ArrayList<>();
        int roomId=1;
        for(String name: rooms){
            returnList.add(new Room(roomId, name));
            roomId++;
        }
        return returnList;
    }
    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.isEmpty() && !fileData.contains(line))
                    if(!line.contains("DEPARTMENT"))fileData.add(line);else{
                        fileData.add("NEWDEPT");
                    }
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }

}
