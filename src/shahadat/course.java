package shahadat;
import java.util.ArrayList;
import java.util.HashSet;
public abstract class course {

    private String TeacherName;
    private String NameCourse;
    private String IdCourse;
    private Integer SizeMember;
    private Integer SizeUnit;
    private  Integer TimeClassStart;
    private Integer TimeClassFinish;
    private String TimeFinal ;
    private ArrayList<Student> ListStudentInCourse = new ArrayList<>();

    public course(String teacherName,
                  String nameCourse,
                  String idCourse,
                  Integer sizeMember,
                  Integer sizeUnit,
                  Integer timeClassStart,
                  Integer timeClassFinish,
                  String timeFinal) {
        TeacherName = teacherName;
        NameCourse = nameCourse;
        IdCourse = idCourse;
        SizeMember = sizeMember;
        SizeUnit = sizeUnit;
        TimeClassStart = timeClassStart;
        TimeClassFinish = timeClassFinish;
        TimeFinal = timeFinal;
    }
    public void AddStudent(String IDStudent){
        ListStudentInCourse.add(GetStudent(IDStudent));
    }
    public void RemoveStudent(String IdStudent){
        for (int i = 0;i<ListStudentInCourse.size();i++){
            if(ListStudentInCourse.get(i).getIDStudent().equals(IdStudent)){
                ListStudentInCourse.remove(i);
            }
        }
        System.out.println("Student Removed From "+getNameCourse());
    }
    public Student GetStudent(String idStudent){
        for (Student i : ListStudentInCourse) {
            if (i.getIDStudent().equals(idStudent)) {
                return i;
            }
        }
        return null;
    }
    public abstract void PrintCourseEveryThing();

    //Integer NumberOfCourse;
    //set course
    //PrintCourseEveryThing
    //EditSizeMember

    public String getTeacherName() {
        return TeacherName;
    }

    public String getNameCourse() {
        return NameCourse;
    }

    public String getIdCourse() {
        return IdCourse;
    }

    public Integer getSizeMember() {
        return SizeMember;
    }

    public Integer getSizeUnit() {
        return SizeUnit;
    }

    public Integer getTimeClassStart() {
        return TimeClassStart;
    }

    public Integer getTimeClassFinish() {
        return TimeClassFinish;
    }

    public String getTimeFinal() {
        return TimeFinal;
    }

    public void setSizeMember(Integer sizeMember) {
        SizeMember = sizeMember;
    }
    public void IncreaseMember(int s){
        setSizeMember(s + getSizeMember());
    }
}
