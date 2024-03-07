package shahadat;

import java.util.ArrayList;

public class Student extends User{
    private String IDStudent;
    private Integer SizeCourseGeneral;
    private Integer SizeCourseExclusive;
    private ArrayList<String> ListIdCourseAccsept = new ArrayList<String>();

    Student(String iDStudent) {
        this.SizeCourseExclusive=0;
        this.SizeCourseGeneral=0;
        this.IDStudent = iDStudent;
    }
    public void AddCourseInList(String idCourse){// needs for complete
        ListIdCourseAccsept.add(idCourse);
    }
    public void ShowListCourseAccept(){
        System.out.println();
        System.out.println("##############################################################################");
        System.out.println("LIST COURSE FOR YOU :");
        for (String i: ListIdCourseAccsept) {
            int n =1;
            course.PrintCourseEveryThing(i);
        }
        System.out.println("##############################################################################");
    }
}
