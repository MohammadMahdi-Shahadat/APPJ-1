package shahadat;
import java.util.ArrayList;
import java.util.HashSet;
public class course {
    static ArrayList<String> TeacherName = new ArrayList<String>();
    static ArrayList<String> NameCourse= new ArrayList<String>();
    static ArrayList<String> IdCourse= new ArrayList<String>();
    static ArrayList<Integer> SizeMember= new ArrayList<Integer>();
    static ArrayList<Integer> SizeUnit= new ArrayList<Integer>();
    static ArrayList<Integer> TimeClassStart= new ArrayList<Integer>();
    static ArrayList<Integer> TimeClassFinish= new ArrayList<Integer>();
    static ArrayList<String> TimeFinal = new ArrayList<String>();
    //Integer NumberOfCourse;
    public static void RemoveCourse(int t){
        TeacherName.remove(t);
        NameCourse.remove(t);
        IdCourse.remove(t);
        SizeMember.remove(t);
        SizeUnit.remove(t);
        TimeClassStart.remove(t);
        TimeClassFinish.remove(t);
        TimeFinal.remove(t);
    }
    public static void SetCourse(String teacherName,
                                 String nameCourse,
                                 String idCourse,
                                 Integer sizeMember,
                                 Integer sizeUnit,
                                 Integer timeClassStart,
                                 Integer timeClassFinish,
                                 String timeFinal) {
        TeacherName.add(teacherName);
        NameCourse.add(nameCourse);
        IdCourse.add(idCourse);
        SizeMember.add(sizeMember);
        SizeUnit.add(sizeUnit);
        TimeClassStart.add(timeClassStart);
        TimeClassFinish.add(timeClassFinish);
        TimeFinal.add(timeFinal);
        System.out.println("Set course "+NameCourse.getLast());
    }
    public static void EditSizeMember(int t,int addPlus){
        SizeMember.set(t,SizeMember.get(t)+addPlus);
    }
}
