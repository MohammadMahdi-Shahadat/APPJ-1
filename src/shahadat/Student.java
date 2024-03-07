package shahadat;

import java.util.ArrayList;

public class Student extends User{
    private String IDStudent;
    private ArrayList<String> ListIdCourseAccsept = new ArrayList<String>();

    Student(String iDStudent) {
        this.IDStudent = iDStudent;
    }
    public void AddCourseInList(String idCourse){
        ListIdCourseAccsept.add(idCourse);
    }
    public void ShowListCourseAccept(){
        System.out.println();
        System.out.println("##############################################################################");
        for (String i: ListIdCourseAccsept) {
            int n =1;
            course.PrintCourseEveryThing(i);
        }
        System.out.println("##############################################################################");
    }
}
