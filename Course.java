public class Course {
    private int id;
    private String name;
    private int typeId;
    public Course(String name, int typeId, int id){
        this.id=id;
        this.name=name;
        this.typeId=typeId;
    }

    public int getId(){
        return id;
    }
    public String getName(){return name;}
    public int getTypeId(){return typeId;}
}
