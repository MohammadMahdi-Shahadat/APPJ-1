package shahadat;

public class General extends course {
    public General(String teacherName,
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
        System.out.println("General lesson => "+
                "TeacherName: "+getTeacherName()+" "+
                "NameCourse: "+getNameCourse()+" "+
                "IdCourse: "+getIdCourse()+" "+
                "SizeUnit: "+getSizeUnit()+" "+
                "TimeClassStart: "+getTimeClassStart()+" "+
                "TimeClassFinish: "+getTimeClassFinish()+" "+
                "TimeFinal: "+getTimeFinal());
        //this isn't complete need for SizeMember
    }
}
