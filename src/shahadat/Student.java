package shahadat;

import java.util.ArrayList;

public class Student extends User{
    private String IDStudent;
    private Integer SizeCourseGeneral;
    private Integer SizeCourseDedicated;
    private ArrayList<General> ListIdCourseGeneral = new ArrayList<>();
    private ArrayList<Dedicated> ListIdCourseDedicated = new ArrayList<>();


    Student(String iDStudent) {
        this.SizeCourseDedicated=0;
        this.SizeCourseGeneral=0;
        this.IDStudent = iDStudent;
    }
    public void AddCourseGeneralInList(String CollegeName,String idCourse){// needs for complete
        ListIdCourseGeneral.add(University.GetCollege(CollegeName).GetGeneral(idCourse));
        ListIdCourseGeneral.getLast().AddStudent(getIDStudent());
        this.SizeCourseGeneral = ListIdCourseGeneral.getLast().getSizeUnit()+this.SizeCourseGeneral;
    }
    public void RemoveStudentGeneral(String CollegeName,String idCourse){
        University.GetCollege(CollegeName).GetGeneral(idCourse).RemoveStudent(getIDStudent());//Remove from course
        RemoveGeneral(idCourse);
        this.SizeCourseGeneral -= ListIdCourseGeneral.getLast().getSizeUnit();

    }
    public void RemoveGeneral(String idCourse){
        for (int i =0 ;i<ListIdCourseGeneral.size();i++){
            if(ListIdCourseGeneral.get(i).getIdCourse().equals(idCourse)){
                ListIdCourseGeneral.remove(i);
            }
        }//naba yad Id yeksan be vojod biad !!!!
        System.out.println("Bug Remove Deicatet #@#!#!%!$@!%#!$!#!!@$!$#$");
    }
    // set add and remove General
    public void AddCourseDedicatedInList(String CollegeName,String idCourse){// needs for complete
        ListIdCourseDedicated.add(University.GetCollege(CollegeName).GetDedicated(idCourse));
        ListIdCourseDedicated.getLast().AddStudent(getIDStudent());
        this.SizeCourseDedicated = ListIdCourseDedicated.getLast().getSizeUnit()+this.SizeCourseDedicated;
    }
    public void RemoveStudentDedicated(String CollegeName,String idCourse){
        University.GetCollege(CollegeName).GetDedicated(idCourse).RemoveStudent(getIDStudent());//Remove from course
        RemoveDedicated(idCourse);
        this.SizeCourseDedicated -= ListIdCourseDedicated.getLast().getSizeUnit();
    }
    public void RemoveDedicated(String idCourse){
        for (int i =0 ;i<ListIdCourseDedicated.size();i++){
            if(ListIdCourseDedicated.get(i).getIdCourse().equals(idCourse)){
                ListIdCourseDedicated.remove(i);
            }
        }//naba yad Id yeksan be vojod biad !!!!
        System.out.println("Bug Remove Deicatet #@#!#!%!$@!%#!$!#!!@$!$#$");
    }
    // set add and remove Dedicated

    public String getIDStudent() {
        return IDStudent;
    }
        public void ShowListCourseAccept(){
        System.out.println();
        System.out.println("##############################################################################");
        System.out.println("LIST COURSE FOR YOU :"+ getIDStudent());
        for (General i:ListIdCourseGeneral) {
            i.PrintCourseEveryThing();
        }
        for (Dedicated i: ListIdCourseDedicated) {
            i.PrintCourseEveryThing();
        }
        System.out.println("##############################################################################");
    }
}
