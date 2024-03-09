package shahadat;

import java.util.ArrayList;

public class college {
    private String CollegeName;
    private ArrayList<General> ListCourseGeneral = new ArrayList<>();
    private ArrayList<Dedicated> ListCourseDedicated = new ArrayList<>();

    public college(String CollegeName) {
        this.CollegeName = CollegeName;
    }
    public  void AddCourseGeneral(String teacherName,
                                 String nameCourse,
                                 String idCourse,
                                 Integer sizeMember,
                                 Integer sizeUnit,
                                 Integer timeClassStart,
                                 Integer timeClassFinish,
                                 String timeFinal){
        ListCourseGeneral.add(new General(teacherName, nameCourse, idCourse, sizeMember, sizeUnit, timeClassStart, timeClassFinish, timeFinal));
    }
    public  void AddCourseDedicated(String teacherName,
                                        String nameCourse,
                                        String idCourse,
                                        Integer sizeMember,
                                        Integer sizeUnit,
                                        Integer timeClassStart,
                                        Integer timeClassFinish,
                                        String timeFinal){
        ListCourseDedicated.add(new Dedicated(teacherName, nameCourse, idCourse, sizeMember, sizeUnit, timeClassStart, timeClassFinish, timeFinal));
    }
    public Dedicated  GetDedicated(String idCourse){
        for (Dedicated i : ListCourseDedicated) {
            if (i.getIdCourse().equals(idCourse)) {
                return i;
            }
        }
        return null;
    }
    public General  GetGeneral(String idCourse){
        for (General i : ListCourseGeneral) {
            if (i.getIdCourse().equals(idCourse)) {
                return i;
            }
        }
        return null;
    }
    public void PrintAllCourse(){
        System.out.println("##############################################################################");
        System.out.println("The List All course in "+getCollegeName()+"'s college");
        for (General i : ListCourseGeneral){
            i.PrintCourseEveryThing();
        }
        for (Dedicated i : ListCourseDedicated){
            i.PrintCourseEveryThing();
        }
        System.out.println("##############################################################################");
    }

    public String getCollegeName() {
        return CollegeName;
    }
}
