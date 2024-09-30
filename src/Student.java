import java.sql.Connection;

public class Student {

    Connection connection =  Database_Connection.getConnection();
    private int s_id;
    private String s_name;
    private int age;
    private String course;

    public String getS_name(){
        return s_name;
    }

    public int getS_id() {
        return s_id;
    }
    public String getCourse(){
        return course;
    }
    public int getAge(){
        return age;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void setCourse(String course){
        this.course = course;
    }

    public String toString(){
        return ("Student Details are:[ ID: "+s_id+ " Name: "+s_name+" Age: "+age+ " Course: "+course);
    }

}
