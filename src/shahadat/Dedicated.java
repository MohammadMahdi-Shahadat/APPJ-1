package shahadat;

import java.util.ArrayList;

public class Dedicated extends course{
    ArrayList<Student> students =new ArrayList<>();
    public Dedicated(String teacherName,
                     String nameCourse,
                     String idCourse,
                     Integer sizeMember,
                     Integer sizeUnit,
                     Integer timeClassStart,
                     Integer timeClassFinish,
                     String timeFinal) {
        super(teacherName, nameCourse, idCourse, sizeMember, sizeUnit, timeClassStart, timeClassFinish, timeFinal);
    }
    @Override
    public void PrintCourseEveryThing(){
        System.out.println("Dedicated lesson => "+
                "TeacherName: "+getTeacherName()+" "+
                "NameCourse: "+getNameCourse()+" "+
                "IdCourse: "+getIdCourse()+" "+
                "SizeUnit: "+getSizeUnit()+" "+
                "TimeClassStart: "+getTimeClassStart()+" "+
                "TimeClassFinish: "+getTimeClassFinish()+" "+
                "TimeFinal: "+getTimeFinal()+" "+
                "Member :  "+ (getSizeMember()-getSizeAddMember())+"/"+getSizeMember());
        //this isn't complete need for SizeMember
    }
}
