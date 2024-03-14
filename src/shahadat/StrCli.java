package shahadat;

import java.util.Scanner;

public class StrCli {
    static String IdOnline;
    private String s ;
    private static Scanner sc;
    private static void initScanner() {
        sc = new Scanner(System.in);
    }
    public static String StrLobbyCLI(){
        return "Shahadat\\MyEdu\\Home";
    }
    public static void Home(){
        System.out.print(StrCli.StrAddCLI(StrCli.StrLobbyCLI(),""));
        Login(sc.next());
    }
    public static void Login(String Id){
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
        while (true){
            String s = sc.next();
            if (s.equals("ListOMyCourse")){
                User.GetStudent(getIdOnline()).ShowListCourseAccept();
                RemoveCourseFromStudent();
            }else if (s.equals("ListOColleges")){
                University.PrintCollege();
            }else if(s.equals("Home")){
                System.out.println("See you later sir");
                break;
            }else {
                System.out.println("There is no such order.");
            }
            System.out.println("Now You can use this order name : ListOMyCourse / ListOColleges /Home");
            System.out.print(StrAddCLI(StrLobbyCLI(), getIdOnline()));
        }
    }
    public static void RemoveCourseFromStudent(){
        while (true) {
            System.out.println("You can Remove the course Just " + "type Remove with IdCourse Or You can type Back Or Home");
            System.out.println("for example :S~ Remove 303");
            System.out.print(StrAddCLI(StrLobbyCLI(), getIdOnline() + "\\RemoveCourse"));
            String s = sc.next();
            if (s.equals("Remove")) {
                System.out.println("Removed");
            } else if (s.equals("Back")) {
                break;
            } else if (s.equals("Home")) {
                Home();
            }else {
                System.out.println("There is no such order.");
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

    public static void setIdOnline(String idOnline) {
        IdOnline = idOnline;
    }
}
