package shahadat;

import java.util.ArrayList;

public class Student extends User{
    private final String IDStudent;
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
        System.out.println("Student "+getIDStudent() +" Add to " + University.GetCollege(CollegeName).getCollegeName());
    }
    public void RemoveStudentGeneral(String CollegeName,String idCourse){
        this.SizeCourseGeneral -= University.GetCollege(CollegeName).GetGeneral(idCourse).getSizeUnit();
        University.GetCollege(CollegeName).GetGeneral(idCourse).RemoveStudent(getIDStudent());//Remove from course
        RemoveGeneral(idCourse);
    }
    public void RemoveGeneral(String idCourse){
        boolean u = true;
        for (int i =0 ;i<ListIdCourseGeneral.size();i++){
            if(ListIdCourseGeneral.get(i).getIdCourse().equals(idCourse)){
                u = false;
                ListIdCourseGeneral.remove(i);
                break;
            }
        }//naba yad Id yeksan be vojod biad !!!!
        if(u==true) {
            System.out.println("Bug Remove General #@#!#!%!$@!%#!$!#!!@$!$#$");
        }
    }
    // set add and remove General
    public void AddCourseDedicatedInList(String CollegeName,String idCourse){// needs for complete
        ListIdCourseDedicated.add(University.GetCollege(CollegeName).GetDedicated(idCourse));
        ListIdCourseDedicated.getLast().AddStudent(getIDStudent());
        this.SizeCourseDedicated = ListIdCourseDedicated.getLast().getSizeUnit()+this.SizeCourseDedicated;
    }
    public void RemoveStudentDedicated(String CollegeName,String idCourse){
        this.SizeCourseDedicated -= University.GetCollege(CollegeName).GetDedicated(idCourse).getSizeUnit();
        University.GetCollege(CollegeName).GetDedicated(idCourse).RemoveStudent(getIDStudent());//Remove from course
        RemoveDedicated(idCourse);
    }
    public void RemoveDedicated(String idCourse){
        boolean u = true;

        for (int i =0 ;i<ListIdCourseDedicated.size();i++){
            if(ListIdCourseDedicated.get(i).getIdCourse().equals(idCourse)){
                u = false;
                ListIdCourseDedicated.remove(i);
            }
        }//naba yad Id yeksan be vojod biad !!!!
        if(u==true) {
            System.out.println("Bug Remove General #@#!#!%!$@!%#!$!#!!@$!$#$");
        }
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
        System.out.println("Sum of Unit General Lesson : " +this.SizeCourseGeneral);
        for (Dedicated i: ListIdCourseDedicated) {
            i.PrintCourseEveryThing();
        }
            System.out.println("Sum of Unit Dedicated Lesson : " +this.SizeCourseDedicated);
            System.out.println("Sum of Unit All : "+ (this.SizeCourseGeneral+this.SizeCourseDedicated));
        System.out.println("##############################################################################");
    }

    public Integer getSizeCourseGeneral() {
        return SizeCourseGeneral;
    }

    public Integer getSizeCourseDedicated() {
        return SizeCourseDedicated;
    }
    public boolean CheckTimeFinaleAndClass(Integer StartClass,Integer FinishClass,String TimeFinale){
        boolean t =true;
        for (General i : ListIdCourseGeneral){
            if (i.getTimeFinal().equals(TimeFinale)){
                System.out.println("this TimeFinale Have OverLap With :");
                i.PrintCourseEveryThing();
                t =false;
            }
            if (((i.getTimeClassStart() > StartClass)&&(i.getTimeClassStart() < FinishClass))  || ((i.getTimeClassFinish() > StartClass)&&(i.getTimeClassFinish() < FinishClass))){
                System.out.println("thi TimeClass Have OverLap With :");
                i.PrintCourseEveryThing();
                t =false;
            }
        }
        for (Dedicated i : ListIdCourseDedicated){
            if (i.getTimeFinal().equals(TimeFinale)){
                System.out.println("this TimeFinale Have OverLap With :");
                i.PrintCourseEveryThing();
                t =false;
            }
            if (((i.getTimeClassStart() > StartClass)&&(i.getTimeClassStart() < FinishClass))  || ((i.getTimeClassFinish() > StartClass)&&(i.getTimeClassFinish() < FinishClass))){
                System.out.println("thi TimeClass Have OverLap With :");
                i.PrintCourseEveryThing();
                t =false;
            }
        }
        return t;
    }
}