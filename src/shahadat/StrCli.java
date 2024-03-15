package shahadat;

import java.util.Scanner;

public class StrCli {
    static String IdOnline;
    private  static boolean Home;
    private String s ;
    private static Scanner sc;
    private static void initScanner() {
        sc = new Scanner(System.in);
    }
    public static String StrLobbyCLI(){
        return "Shahadat\\MyEdu\\Home";
    }
    public static void Login(String Id){
        Home =true;
        //harecat rahat baray bargasht be halat avale
        initScanner();
        if(User.IsCorrectID(Id)){
            setIdOnline(Id);
            System.out.println("Wellcome sir "+"You login With Id "+ getIdOnline());

            if(Id.equals("Admin")){
                Teacher.Onlline = true;
                LoginedAdmin();
            }else {
                LoginedStudent();
            }
        }else {
            System.out.println("There is no such ID.");
        }
    }
    public static void LoginedAdmin(){
        System.out.println("Now You can use this order name : SaveAll/Import/(you can type the List of college)/Home");
        University.PrintCollege();
        System.out.print(StrAddCLI(StrLobbyCLI(),getIdOnline()));

    }
    public static void LoginedStudent(){
        System.out.println("Now You can use this order name : ListOMyCourse / ListOColleges /Home");
        System.out.print(StrAddCLI(StrLobbyCLI(),getIdOnline()));
        while (Home){
            String s = sc.next();
            if (s.equals("ListOMyCourse")){
                User.GetStudent(getIdOnline()).ShowListCourseAccept();
                RemoveCourseFromStudent();
            }else if (s.equals("ListOColleges")){
                University.PrintCollege();
                ChoseCollege();
            }else if(s.equals("Home")||s.equals("Back")){
                System.out.println("See you later sir");
                break;
            }else {
                System.out.println("There is no such order.");
            }
            if(Home){
                System.out.println("Now You can use this order name : ListOMyCourse / ListOColleges /Home");
                System.out.print(StrAddCLI(StrLobbyCLI(), getIdOnline()));
            }
        }
    }
    public static void ChoseCollege(){
        while (Home) {
            System.out.println("You can chose the college and see the course of college Or Back Or Home");
            System.out.print(StrAddCLI(StrLobbyCLI(), getIdOnline() + "\\ChoseTheCollege"));

            String s = sc.next();
            if(s.equals("Home")){
                Home=false;
                System.out.println("See you later sir");
            }else if(s.equals("Back")){
                break;
            } else if (University.GetCollege(s) != null) {
                University.GetCollege(s).PrintAllCourse();
                YNChoseCourse(s);
            }else {
                Noorder();
            }
        }
    }
    public static void YNChoseCourse(String NameCollege){
        while (Home){
            System.out.println("Are you Want to Add Course from "+NameCollege+" OR Home || Back");
            System.out.println("Type Yes / No ");
            System.out.print(StrAddCLI(StrLobbyCLI(), getIdOnline() + "\\"+NameCollege+"\\"+"AddCourse"));
            String s = sc.next();
            if (s.equals("Yes")){
                AddCourseStudentYes(NameCollege);
            }else if(s.equals("No")||s.equals("Back")){
                break;
            }else if(s.equals("Home")){
                Home =false;
                System.out.println("See you later sir");
            }
            else {
                Noorder();
            }
        }
    }
    public static void AddCourseStudentYes(String NameCollege){
        System.out.println("You must now What's do for add the course yourself.");
        System.out.println("Rules :\n" +
                "1- The maximum course unit that can be taken is 20 units.\n" +
                "2- None of the courses should interfere with the time of the exam and the class.\n" +
                "3- If the lesson is full, you cannot take that lesson.\n" +
                "4- A maximum of 5 units of general courses can be taken.");
        while (Home){
            System.out.println("you must type yhe Id cours Or Home || Back ");
            System.out.print(StrAddCLI(StrLobbyCLI(), getIdOnline() + "\\"+NameCollege+"\\"+"AddCourse"));
            String s = sc.next();
            if (s.equals("Home")){
                Home = false;
                System.out.println("See you later sir");
            }else if(s.equals("Back")){
                break;
            }else if(University.GetCollege(NameCollege).GetDedicated(s)!=null ||University.GetCollege(NameCollege).GetGeneral(s)!= null){
                if(University.GetCollege(NameCollege).GetDedicated(s)!=null){
                    if(CanAddOrNo(NameCollege,s)){
                        User.GetStudent(getIdOnline()).AddCourseDedicatedInList(NameCollege,s);
                        System.out.println(getIdOnline() +" Add in course "+University.GetCollege(NameCollege).GetDedicated(s).getNameCourse());
                        break;
                    }
                }else{
                    if(CanAddOrNo(NameCollege,s)){
                        User.GetStudent(getIdOnline()).AddCourseGeneralInList(NameCollege,s);
                        System.out.println(getIdOnline() +" Add in course "+University.GetCollege(NameCollege).GetGeneral(s).getNameCourse());
                        break;
                    }
                }
            }else {
                Noorder();
            }
        }
    }
    public static void RemoveCourseFromStudent(){
        while (Home) {
            System.out.println("You can Remove the course Just " + "type Remove +College Name + General or Dedicated+ IdCourse Or You can type Back Or Home");
            System.out.println("for example :S~ Remove Mathematics General  303");
            System.out.print(StrAddCLI(StrLobbyCLI(), getIdOnline() + "\\RemoveCourse"));
            String s = sc.next();
            if (s.equals("Remove")) {
                if(sc.hasNext()){
                    String N = sc.next();
                    if(University.GetCollege(N)!=null){
                        if (sc.hasNext()){
                            String GD = sc.next();
                            if (GD.equals("General")){
                                if (sc.hasNext()){
                                   String Id =sc.next();
                                   if (University.GetCollege(N).GetGeneral(Id)!=null){
                                       User.GetStudent(getIdOnline()).RemoveStudentGeneral(N,Id);
                                   }else {
                                       System.out.println("There is no such Id.");
                                       Noorder();
                                   }
                                }else {
                                    System.out.println("pleas type Id Course ");
                                    Noorder();
                                }
                            } else if (GD.equals("Dedicated")) {
                                if (sc.hasNext()) {
                                    String Id = sc.next();
                                    if (University.GetCollege(N).GetDedicated(Id) != null) {
                                        User.GetStudent(getIdOnline()).RemoveStudentDedicated(N, Id);
                                    } else {
                                        System.out.println("There is no such Id.");
                                        Noorder();
                                    }
                                } else {
                                    System.out.println("pleas type Id Course ");
                                    Noorder();
                                }
                            }
                        }
                        else {
                            Noorder();
                        }
                    }else {
                        System.out.println("type College Name is wrong!");
                        Noorder();
                    }
                }else {
                    Noorder();
                }
            } else if (s.equals("Back")) {
                break;
            } else if (s.equals("Home")) {
                Home =false;
                System.out.println("See you later sir");
            }else {
                Noorder();
            }
        }
    }
    public static String StrAddCLI(String str,String str2){
        String s = str;
        s = s +"\\"+ str2;
        return s = s +"\\$~ ";
    }

    public static String getIdOnline() {
        return IdOnline;
    }
    public static void Noorder(){
        System.out.println("There is no such order.");
    }
    public static void setIdOnline(String idOnline) {
        IdOnline = idOnline;
    }
    public static boolean CanAddOrNo(String CollegeName,String IdCourse){
        boolean s =true;
        if (University.GetCollege(CollegeName).GetGeneral(IdCourse)!= null){
            if (5 <User.GetStudent(getIdOnline()).getSizeCourseGeneral()+University.GetCollege(CollegeName).GetGeneral(IdCourse).getSizeUnit()){
                System.out.println("You can't add Course General up 5 Unit");
                s = false;
            }
            if (!User.GetStudent(getIdOnline()).CheckTimeFinaleAndClass(University.GetCollege(CollegeName).GetGeneral(IdCourse).getTimeClassStart(),
                    University.GetCollege(CollegeName).GetGeneral(IdCourse).getTimeClassFinish(),
                    University.GetCollege(CollegeName).GetGeneral(IdCourse).getTimeFinal())){
                s = false;
            }
            if (20 <User.GetStudent(getIdOnline()).getSizeCourseGeneral()+
                    University.GetCollege(CollegeName).GetGeneral(IdCourse).getSizeUnit()+
                    User.GetStudent(getIdOnline()).getSizeCourseDedicated()){
                System.out.println("You rejected the unit ceiling.");
                s=false;
            }if (0>University.GetCollege(CollegeName).GetGeneral(IdCourse).getSizeAddMember()-1){
                System.out.println("this course haven't any size");
                s = false;
            }
        }else {
            if (!User.GetStudent(getIdOnline()).CheckTimeFinaleAndClass(University.GetCollege(CollegeName).GetDedicated(IdCourse).getTimeClassStart(),
                    University.GetCollege(CollegeName).GetDedicated(IdCourse).getTimeClassFinish(),
                    University.GetCollege(CollegeName).GetDedicated(IdCourse).getTimeFinal())){
                s = false;
            }
            if (20 <User.GetStudent(getIdOnline()).getSizeCourseGeneral()+
                    University.GetCollege(CollegeName).GetDedicated(IdCourse).getSizeUnit()+
                    User.GetStudent(getIdOnline()).getSizeCourseDedicated()){
                System.out.println("You rejected the unit ceiling.");
                s=false;
            }if (0>University.GetCollege(CollegeName).GetDedicated(IdCourse).getSizeAddMember()-1){
                System.out.println("this course haven't any size");
                s = false;
            }
        }
        return s;
    }
}