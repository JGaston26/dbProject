import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Course> apCourses = new ArrayList<>();
    public static void main(String[] args) {
        ArrayList<String> studentNames = getFileData("Students");
        ArrayList<String> teacherNames = getFileData("TeachersAndDepartments"); //no dupes
        ArrayList<String> roomNames = getFileData("Rooms");
        ArrayList<String> courseNames = getFileData("Classes");

        TypesAndDepts.printTypesAndDepts();

        ArrayList<Course> courseData = createCourses(courseNames);
        ArrayList<Teacher> teacherData = createTeachers(teacherNames);
        ArrayList<Student> studentData = createStudents(studentNames);
        ArrayList<Room> roomData = createRooms(roomNames);
        ArrayList<CourseOffering> courseOfferingData = createCourseOffering(courseData,teacherData,roomData);

        System.out.println(courseOfferingData);
        System.out.println(courseOfferingData.size());

    }

    public static ArrayList<Teacher> createTeachers(ArrayList<String> teacherNames){
        ArrayList<Teacher> returnList = new ArrayList<>();
        int deptId=0;
        int teacherId=1;
        for(String name: teacherNames){
            if(name.equals("NEWDEPT")){deptId++;}
            else{
                returnList.add(new Teacher(name,deptId,teacherId));
                teacherId++;
            }

        }
        for(int i=0; i<returnList.size(); i++){
            System.out.println("INSERT INTO Teachers(TeacherID,TeacherName,DepartmentID) " +
                    "VALUES (" + returnList.get(i).getId() +
                    ", '" + returnList.get(i).getName() + "', " +
                    returnList.get(i).getDepartment() + " );" );
        }
        return returnList;
    }
    public static ArrayList<Student> createStudents(ArrayList<String> studentNames) {
        ArrayList<Student> returnList = new ArrayList<>();
        int studentId=1;
        for(String name: studentNames){
            returnList.add(new Student(studentId));
            studentId++;
        }
        for(int i=0; i< returnList.size(); i++){
           // System.out.println(returnList.get(i).getId());
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
        for(int i=1; i< returnList.size(); i++){
            System.out.println("INSERT INTO Rooms( RoomID, RoomName) VALUES " +
                    "("+ i + ", '" + returnList.get(i).getName() + "');");
        }
        return returnList;
    }
    public static ArrayList<Course> createCourses(ArrayList<String> courses){
        ArrayList<Course> returnList = new ArrayList<>();
        int courseID=1;
        for(String name: courses){
            int typeId=1;
            if(name.contains("Common Core") || name.contains("Regents")) typeId= 2;
            else if(name.contains("AP ")){
                typeId=3;
                apCourses.add(new Course(name, courseID,typeId));
            }
            returnList.add(new Course(name, courseID,typeId));
            courseID++;
        }

        return returnList;
    }
    public static ArrayList<CourseOffering> createCourseOffering(ArrayList<Course> courses, ArrayList<Teacher> teachers, ArrayList<Room> rooms){
        /*
            When assigning teachers to courses its important to note:
            Teachers cannot teach 2 classes at the same time, so make sure to check they are available in the period we're checking for

            Step 1: Select random teacher and course to create a course offering
            Step 2: Using the times available, properly remove periods available from the room/teacher objects and make sure to account for APs
            Step 3: Run until no more teacher periods / rooms to use etc etc
         */
        ArrayList<CourseOffering> returnList = new ArrayList<>();
        int courseOfferingId=1;
        for(int i =0; i < teachers.size(); i++){
            Teacher currentTeacher = teachers.get(i);
            int room = 1;
            int earliestAvailablePeriod = 1;
            boolean terminate = false;
            int timesAvailableRand = (int)(Math.random()*6);
            ArrayList<Integer> periodsToAdd = new ArrayList<>();
            ArrayList<Integer> roomsToAdd = new ArrayList<>();
            for(int r = 0; r < timesAvailableRand; r++){
                for(int j = 1; j < 11; j++){
                    if(currentTeacher.getAvailablePeriods().contains((j)) && rooms.get(room).getAvailablePeriods().contains(j)){
                        earliestAvailablePeriod=j;
                        currentTeacher.removePeriod(j);
                        rooms.get(room).removePeriod(j);
                        periodsToAdd.add(j);
                        roomsToAdd.add(rooms.get(room).getID());
                        break;
                    }
                    //max teacher + max rooms case
                    if(room==rooms.size()-1 && currentTeacher==teachers.getLast() && j==10){
                        terminate=true;
                        break;
                    }
                    //max rooms, not maxed teachers case
                    else if(room==rooms.size()-1 && j==10 && currentTeacher!=teachers.getLast()){
                        currentTeacher=teachers.get(i+1);
                        i++;
                    }
                    //maxed period case
                    else if(j==10){
                        room++;
                        j=0;
                    }
                }
                if(terminate)break;
            }
            if(terminate)break;
            ArrayList<Integer> idListToUse = new ArrayList<>();
            for(int z = courseOfferingId; z < timesAvailableRand+courseOfferingId; z++){
                System.out.println(z);
                idListToUse.add(z);
            }
            CourseOffering currentCourseOffering = new CourseOffering(idListToUse,currentTeacher, rooms.get(room), courses.get((int)(Math.random()*courses.size())).getId());

            //add periods / rooms in use
            for(int x = 0; x < periodsToAdd.size(); x++){
                System.out.println(periodsToAdd);
                currentCourseOffering.addPeriodInuse(periodsToAdd.get(x));
                currentCourseOffering.addRoomsInUse(roomsToAdd.get(x));
            }

            courseOfferingId+= timesAvailableRand+1;
            returnList.add(currentCourseOffering);
        }

        for (CourseOffering courseOffering : returnList) {
            for (int j = 0; j < courseOffering.getCourseOfferingIds().size(); j++) {
                System.out.println(courseOffering.getCourseOfferingIds().toString());
                System.out.println("INSERT INTO CourseOffering( CourseOfferingID, Period, RoomID, CourseID, TeacherID) VALUES "
                        + "(" + courseOffering.getCourseOfferingIds().get(j)
                        + "," + courseOffering.getPeriodsInUse().get(j)
                        + "," + courseOffering.getRoomsInUse().get(j)
                        + "," + courseOffering.getCourse()
                        + "," + courseOffering.getTeacherID() +")" );

            }

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