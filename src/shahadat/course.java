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
    public static void RemoveCourse(String idCourse){
        int t =FindTFromIdCourse(idCourse);
        TeacherName.remove(t);
        NameCourse.remove(t);
        IdCourse.remove(t);
        SizeMember.remove(t);
        SizeUnit.remove(t);
        TimeClassStart.remove(t);
        TimeClassFinish.remove(t);
        TimeFinal.remove(t);
    }
    public static void SetNewCourse(String teacherName,
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
      //  System.out.println("Set course "+NameCourse.getLast());
    }
    public static int FindTFromIdCourse(String idCourse){
        int t =0;
        for (String i : IdCourse ){
            if(idCourse.equals(IdCourse.get(t))){
                return t;
            }
            t++;
        }
        return -1;
    }
    public static void PrintCourseEveryThing(String idCors){
        int t = FindTFromIdCourse(idCors);
        System.out.println("NameCourse: "+NameCourse.get(t)+" "+
                "IdCourse: "+IdCourse.get(t)+" "+
                "SizeUnit: "+SizeUnit.get(t)+" "+
                "TimeClassStart: "+TimeClassStart.get(t)+" "+
                "TimeClassFinish: "+TimeClassFinish.get(t)+" "+
                "TimeFinal: "+TimeFinal.get(t)+" ");
        //this isn't complete need for SizeMember
    }
    public static void EditSizeMember(String idCourse,int addPlus){
        int t = FindTFromIdCourse(idCourse);
        SizeMember.set(t,SizeMember.get(t)+addPlus);
    }
}
