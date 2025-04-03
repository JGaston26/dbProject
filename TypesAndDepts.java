public class TypesAndDepts {
    private static String[] depts = {"Biology", "Chemistry", "Computer Science", "English", "Health and PE", "Mathematics", "Physics", "Social Studies", "Special Education",
                                "Visual and Performing Arts", "Foreign Languages and ENL", "Health and Safety"};

    public static void printTypesAndDepts() {
        for (int i = 1; i <= depts.length; i++){
            System.out.println("INSERT INTO Departments (DepartmentID, DepartmentName) VALUES (" + i + ", '" + depts[i-1] + "');");
        }
        System.out.println("INSERT INTO CourseTypes (TypeID, Type) VALUES (1, 'Elective');\n" +
                        "INSERT INTO CourseTypes (TypeID, Type) VALUES (2, 'Regents');\n" +
                        "INSERT INTO CourseTypes (TypeID, Type) VALUES (3, 'AP');\n" +
                        "INSERT INTO AssignmentTypes (AssignmentTypeID, AssignmentType) VALUES (1, 'Minor');\n" +
                        "INSERT INTO AssignmentTypes (AssignmentTypeID, AssignmentType) VALUES (2, 'Major');");
    }
}
