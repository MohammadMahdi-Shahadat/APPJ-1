package shahadat;
import java.util.ArrayList;
import java.util.HashSet;

public class User {
    private static Boolean teacherMode;
    private static Boolean studentMode;
    static HashSet<String> IDTeacher= new HashSet<>();
    static HashSet<String> IDStudent= new HashSet<>();
    static ArrayList<Student> StudentA= new ArrayList<>();
    User(){
    }


    public static void HardCodeUser(){
        AddStudent("402109740");
        AddStudent("402109741");
        AddStudent("402109742");
        AddStudent("402109743");
        AddStudent("402109744");
        IDTeacher.add("Admin");
    }


    public static void AddStudent(String id){
        StudentA.add(new Student(id));
        IDStudent.add(id);
    }



    public static Student GetStudent(String idStudent){
        for (Student i : StudentA){
            if(i.getIDStudent().equals(idStudent)){
                return i;
            }
        }
        return null;
    }



    static Boolean IsCorrectID (String id){
        return IDStudent.contains(id) || IDTeacher.contains(id);
    }
}
