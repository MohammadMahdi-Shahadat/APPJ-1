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
            }else if(s.equals("Home")){
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
            System.out.print(StrAddCLI(StrLobbyCLI(), getIdOnline() + "\\ChoseTheCourse"));

            String s = sc.next();
            if(s.equals("Home")){

            }else if(s.equals("Back")){
                break;
            } else if (University.GetCollege(s) != null) {
                University.GetCollege(s).PrintAllCourse();
                System.out.println(sc.hasNext());
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
}
