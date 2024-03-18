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
            if(Id.equals("Admin")){
                System.out.println("Hi Admin pleas enter your password Or Back");
                while (Home){
                    System.out.print(StrAddCLI(StrLobbyCLI(),"\\Password"));
                    String s =sc.next();
                    if (s.equals("Back")){
                        Home = false;
                    } else if (s.equals("mmsh4831")) {
                        setIdOnline(Id);
                        System.out.println("Wellcome sir "+"You login With Id "+ getIdOnline());
                        Teacher.Onlline = true;
                        LoginedAdmin();
                    }else {
                        System.out.println("Incorrect Password");
                    }
                    Teacher.Onlline = false;
                }
            }else {
                System.out.println("Hi student "+Id);
                System.out.println("enter your password Or Back");
                while (Home){
                    System.out.print(StrAddCLI(StrLobbyCLI(),"\\Password"));
                    String s =sc.next();
                    if (s.equals("Back")){
                        Home = false;
                    } else if (s.equals(User.GetStudent(Id).getPassStudent())) {
                        setIdOnline(Id);
                        System.out.println("Wellcome sir "+"You login With Id "+ getIdOnline());
                        LoginedStudent();
                    }else {
                        System.out.println("Incorrect Password");
                    }
                }

            }
        } else if (Id.equals("SignUp")) {
            SignUp();
        } else {
            System.out.println("There is no such ID.");
        }
    }
    public static void SignUp(){
        while (Home){
            System.out.println("type your UserName / Or / Back");
            System.out.print(StrAddCLI(StrLobbyCLI(),"\\SignUp"));
            String s = sc.next();
            if (s.equals("Back")){

            }else {
                while (Home){
                    System.out.println("type your Password / Or / Back /Home");
                    System.out.print(StrAddCLI(StrLobbyCLI(),"\\SignUp"));
                    String s1 = sc.next();
                    if(s1.equals("Back")){
                        break;
                    } else if (s1.equals("Home")) {
                        Home =false;
                    }else {
                        User.AddStudent(s,s1);
                        Home =false;
                        System.out.println("Add New Student");
                    }
                }
            }
        }
    }
    public static void LoginedAdmin(){
        while (Home){
            System.out.println("You can use this order name : SaveAll/Import/(you can type the List of college)/Home");
            University.PrintCollege();
            System.out.print(StrAddCLI(StrLobbyCLI(),getIdOnline()));
            String s = sc.next();
            if (s.equals("SaveAll")){
                System.out.println("Saved");
            } else if (s.equals("Import")) {
                System.out.println("Imported");
            } else if (s.equals("Home")) {
                Home =false;
            } else if (University.GetCollege(s)!=null) {
                ShowCourseForAdmin(University.GetCollege(s).getCollegeName());
            }else {
                Noorder();
            }
        }
    }
    public static void ShowCourseForAdmin(String NameCollege){
        while (Home){
            System.out.println("You can use this order name : AddCourse/(you can chose course for see all student)/Home/Back");
            University.GetCollege(NameCollege).PrintAllCourse();
            System.out.print(StrAddCLI(StrLobbyCLI(), getIdOnline() + "\\University"));
            String s = sc.next();
            if (s.equals("AddCourse")){
                AddCourseWithAdmin(NameCollege);
            } else if (s.equals("Home")) {
                Home = false;
            }else if(s.equals("Back")){
                break;
            } else if (University.GetCollege(NameCollege).GetGeneral(s)!=null) {
                ShowStudentInCourseGeneral(NameCollege,s);
            } else if (University.GetCollege(NameCollege).GetDedicated(s)!=null ) {
                ShowStudentInCourseDedicated(NameCollege,s);
            } else {
                Noorder();
            }
        }
    }
    public static void ShowStudentInCourseGeneral(String NameCollege,String IdCourse){
        University.GetCollege(NameCollege).GetGeneral(IdCourse).PrintCourseEveryThing();
        out :while (Home){
            University.GetCollege(NameCollege).GetGeneral(IdCourse).PrintStudentInCourse();
            System.out.println("You can use this order name : RemoveStudent/REMOVECOURSE/AddStudent/IncreaseMember/Home/Back");
            System.out.print(StrAddCLI(StrLobbyCLI(), getIdOnline() + "\\University\\"+NameCollege+"\\"+University.GetCollege(NameCollege).GetGeneral(IdCourse).getNameCourse()));
            String s = sc.next();
            if (s.equals("RemoveStudent")){
                while (Home){
                    System.out.println("You can use this order name : IdStudent(if Student in course)/Home/Back");
                    System.out.print(StrAddCLI(StrLobbyCLI(), getIdOnline() + "\\University\\"+NameCollege+"\\"+University.GetCollege(NameCollege).GetGeneral(IdCourse).getNameCourse()));
                    String s1 = sc.next();
                    if (s1.equals("Home")){
                        Home =false;
                    } else if (s1.equals("Back")) {
                        break;
                    } else if (University.GetCollege(NameCollege).GetGeneral(IdCourse).GetStudent(s1)!=null) {
                        User.GetStudent(s1).RemoveStudentGeneral(NameCollege,IdCourse);
                    }else {
                        System.out.println("this student haven't been in course ");
                        Noorder();
                    }
                }

            }
            else if (s.equals("Home")) {
                Home = false;
            }
            else if(s.equals("Back")){
                break;
            }
            else if (s.equals("REMOVECOURSE")) {
                System.out.println("Are You Sure For REMOVE The Course ? Yes/No");
                while (Home){
                    System.out.print(StrAddCLI(StrLobbyCLI(), getIdOnline() + "\\University\\"+NameCollege+"\\"+University.GetCollege(NameCollege).GetGeneral(IdCourse).getNameCourse()+"\\REMOVECOURSE"));
                    String s1 = sc.next();
                    if (s1.equals("Yes")){
                        int oop = University.GetCollege(NameCollege).GetGeneral(IdCourse).getListStudentInCourse().size();
                        for (int i =0;i<oop ;i++){
                            User.GetStudent(University.GetCollege(NameCollege).GetGeneral(IdCourse).getListStudentInCourse().getFirst().getIDStudent()).RemoveStudentGeneral(NameCollege,IdCourse);
                        }
                        int opo = University.GetCollege(NameCollege).GetGeneralPortocol(IdCourse);
                        University.GetCollege(NameCollege).ListCourseGeneral.remove(opo);
                        System.out.println("REMOVED COURSE");
                        break out;
                    } else if (s1.equals("No")) {
                        break;
                    }else {
                        Noorder();
                    }
                }
            }
            else if (s.equals("AddStudent")) {
                System.out.println("Rules :\n" +
                        "1- The maximum course unit that can be taken is 20 units.\n" +
                        "2- None of the courses should interfere with the time of the exam and the class.\n" +
                        "3- If the lesson is full, you cannot take that lesson.\n" +
                        "4- A maximum of 5 units of general courses can be taken.");
                while (Home){
                    System.out.println("You can use this order name : IdStudent(should the use the rule)/Home/Back");
                    System.out.print(StrAddCLI(StrLobbyCLI(), getIdOnline() + "\\University\\"+NameCollege+"\\"+University.GetCollege(NameCollege).GetGeneral(IdCourse).getNameCourse()));
                    String s1 = sc.next();
                    if (s1.equals("Home")){
                        Home =false;
                    } else if (s1.equals("Back")) {
                        break;
                    } else if (User.GetStudent(s1)!=null) {
                        setIdOnline(User.GetStudent(s1).getIDStudent());
                        if (CanAddOrNo(NameCollege,IdCourse)){
                            User.GetStudent(getIdOnline()).AddCourseGeneralInList(NameCollege,IdCourse);
                            System.out.println("Added Student "+getIdOnline());
                        }
                        setIdOnline("Admin");
                    }else {
                        Noorder();
                    }
                }
            }
            else if (s.equals("IncreaseMember")) {
                while (Home){
                    System.out.println("You can use this order name : type Number (for Increase Member)/Home/Back");
                    System.out.print(StrAddCLI(StrLobbyCLI(), getIdOnline() + "\\University\\"+NameCollege+"\\"+University.GetCollege(NameCollege).GetGeneral(IdCourse).getNameCourse()));
                    String s1 = sc.next();
                    if (s1.equals("Home")){
                        Home =false;
                    } else if (s1.equals("Back")) {
                        break;
                    } else {
                        try {
                            Integer p =Integer.parseInt(s1);
                            University.GetCollege(NameCollege).GetGeneral(IdCourse).IncreaseMember(p);
                            System.out.println("Increased Member");
                            break ;
                        }catch (NumberFormatException e){
                            Noorder();
                        }
                    }
                }
            }
            else {
                Noorder();
            }
        }
    }
    public static void ShowStudentInCourseDedicated(String NameCollege,String IdCourse){
        University.GetCollege(NameCollege).GetDedicated(IdCourse).PrintCourseEveryThing();
        out :while (Home){
            University.GetCollege(NameCollege).GetDedicated(IdCourse).PrintStudentInCourse();
            System.out.println("You can use this order name : RemoveStudent/REMOVECOURSE/AddStudent/IncreaseMember/Home/Back");
            System.out.print(StrAddCLI(StrLobbyCLI(), getIdOnline() + "\\University\\"+NameCollege+"\\"+University.GetCollege(NameCollege).GetDedicated(IdCourse).getNameCourse()));
            String s = sc.next();
            if (s.equals("RemoveStudent")){
                while (Home){
                    System.out.println("You can use this order name : IdStudent(if Student in course)/Home/Back");
                    System.out.print(StrAddCLI(StrLobbyCLI(), getIdOnline() + "\\University\\"+NameCollege+"\\"+University.GetCollege(NameCollege).GetDedicated(IdCourse).getNameCourse()));
                    String s1 = sc.next();
                    if (s1.equals("Home")){
                        Home =false;
                    } else if (s1.equals("Back")) {
                        break;
                    } else if (University.GetCollege(NameCollege).GetDedicated(IdCourse).GetStudent(s1)!=null) {
                        User.GetStudent(s1).RemoveStudentDedicated(NameCollege,IdCourse);
                    }else {
                        System.out.println("this student haven't been in course ");
                        Noorder();
                    }
                }

            }
            else if (s.equals("Home")) {
                Home = false;
            }
            else if(s.equals("Back")){
                break;
            }
            else if (s.equals("REMOVECOURSE")) {
                System.out.println("Are You Sure For REMOVE The Course ? Yes/No");
                while (Home){
                    System.out.print(StrAddCLI(StrLobbyCLI(), getIdOnline() + "\\University\\"+NameCollege+"\\"+University.GetCollege(NameCollege).GetDedicated(IdCourse).getNameCourse()+"\\REMOVECOURSE"));
                    String s1 = sc.next();
                    if (s1.equals("Yes")){
                        int oop = University.GetCollege(NameCollege).GetDedicated(IdCourse).getListStudentInCourse().size();
                        for (int i =0;i<oop ;i++){
                            User.GetStudent(University.GetCollege(NameCollege).GetDedicated(IdCourse).getListStudentInCourse().getFirst().getIDStudent()).RemoveStudentDedicated(NameCollege,IdCourse);
                        }
                        int opo = University.GetCollege(NameCollege).GetDedicatedPortocol(IdCourse);
                        University.GetCollege(NameCollege).ListCourseDedicated.remove(opo);
                        System.out.println("REMOVED COURSE");
                        break out;
                    } else if (s1.equals("No")) {
                        break;
                    }else {
                        Noorder();
                    }
                }
            }
            else if (s.equals("AddStudent")) {
                System.out.println("Rules :\n" +
                        "1- The maximum course unit that can be taken is 20 units.\n" +
                        "2- None of the courses should interfere with the time of the exam and the class.\n" +
                        "3- If the lesson is full, you cannot take that lesson.\n" +
                        "4- A maximum of 5 units of general courses can be taken.");
                while (Home){
                    System.out.println("You can use this order name : IdStudent(should the use the rule)/Home/Back");
                    System.out.print(StrAddCLI(StrLobbyCLI(), getIdOnline() + "\\University\\"+NameCollege+"\\"+University.GetCollege(NameCollege).GetDedicated(IdCourse).getNameCourse()));
                    String s1 = sc.next();
                    if (s1.equals("Home")){
                        Home =false;
                    } else if (s1.equals("Back")) {
                        break;
                    } else if (User.GetStudent(s1)!=null) {
                        setIdOnline(User.GetStudent(s1).getIDStudent());
                        if (CanAddOrNo(NameCollege,IdCourse)){
                            User.GetStudent(getIdOnline()).AddCourseDedicatedInList(NameCollege,IdCourse);
                            System.out.println("Added Student "+getIdOnline());
                        }
                        setIdOnline("Admin");
                    }else {
                        Noorder();
                    }
                }
            }
            else if (s.equals("IncreaseMember")) {
                while (Home){
                    System.out.println("You can use this order name : type Number (for Increase Member)/Home/Back");
                    System.out.print(StrAddCLI(StrLobbyCLI(), getIdOnline() + "\\University\\"+NameCollege+"\\"+University.GetCollege(NameCollege).GetDedicated(IdCourse).getNameCourse()));
                    String s1 = sc.next();
                    if (s1.equals("Home")){
                        Home =false;
                    } else if (s1.equals("Back")) {
                        break;
                    } else {
                        try {
                            Integer p =Integer.parseInt(s1);
                            University.GetCollege(NameCollege).GetDedicated(IdCourse).IncreaseMember(p);
                            System.out.println("Increased Member");
                            break ;
                        }catch (NumberFormatException e){
                            Noorder();
                        }
                    }
                }
            }
            else {
                Noorder();
            }
        }
    }
    public static void AddCourseWithAdmin(String NameCollege){
        String TeacherName;
        String NameCourse;
        String IdCourse;
        Integer SizeMember;
        Integer SizeUnit;
        Integer TimeClassStart;
        Integer TimeClassFinish;
        String TimeFinal;
        out :while (Home){
            System.out.println("You can use this order name : Home/Back");
            System.out.println("Type the TeacherName :");
            System.out.print(StrAddCLI(StrLobbyCLI(), getIdOnline() + "\\University\\"+NameCollege+"\\AddCourse"));
            String s1 =sc.next();
            if (s1.equals("Home")){
                Home =false;
            }else if (s1.equals("Back")){
                break;
            }else {
                TeacherName = s1;
                System.out.println("You set TeacherName "+TeacherName);
                while (Home){
                    System.out.println("You can use this order name : Home/Back");
                    System.out.println("Type the NameCourse :");
                    System.out.print(StrAddCLI(StrLobbyCLI(), getIdOnline() + "\\University\\"+NameCollege+"\\AddCourse"));
                    String s2 =sc.next();
                    if (s2.equals("Home")){
                        Home =false;
                    }else if (s2.equals("Back")){
                        break;
                    }else {
                        NameCourse = s2;
                        System.out.println("You set NameCourse "+NameCourse);
                        while (Home){
                            System.out.println("You can use this order name : Home/Back");
                            System.out.println("For TimeFinal you should to use 8 Number yer+mount+day");
                            System.out.println("For example :> 14020304 <");
                            System.out.println("Type the TimeFinal :");
                            System.out.print(StrAddCLI(StrLobbyCLI(), getIdOnline() + "\\University\\"+NameCollege+"\\AddCourse"));
                            String s3 =sc.next();
                            if (s3.equals("Home")){
                                Home =false;
                            }else if (s3.equals("Back")){
                                break;
                            }else if (s3.length() == 8 && TimeFinal(s3)){
                                TimeFinal = s3;
                                System.out.println("You set TimeFinal "+TimeFinal);
                                while (Home) {
                                    System.out.println("You can use this order name : Home/Back");
                                    System.out.println("Type the SizeMember :");
                                    System.out.print(StrAddCLI(StrLobbyCLI(), getIdOnline() + "\\University\\" + NameCollege + "\\AddCourse"));
                                    String s4 = sc.next();
                                    if (s4.equals("Home")){
                                        Home =false;
                                        break;
                                    }else if (s4.equals("Back")){
                                        break;
                                    }else {
                                        try {
                                            SizeMember = Integer.parseInt(s4);
                                            if (SizeMember <0 ){
                                                Noorder();
                                                break;
                                            }
                                            System.out.println("You set SizeMember: "+SizeMember);
                                            while (Home) {
                                                System.out.println("You can use this order name : Home/Back");
                                                System.out.println("Type the SizeUnit :");
                                                System.out.print(StrAddCLI(StrLobbyCLI(), getIdOnline() + "\\University\\" + NameCollege + "\\AddCourse"));
                                                String s5 = sc.next();
                                                if (s5.equals("Home")) {
                                                    Home = false;
                                                    break;
                                                } else if (s5.equals("Back")) {
                                                    break;
                                                }else {
                                                    try {
                                                        SizeUnit = Integer.parseInt(s5);
                                                        if (SizeUnit <0 ){
                                                            Noorder();
                                                            break;
                                                        }
                                                        System.out.println("You set SizeUnit: "+SizeUnit);
                                                        while (Home) {
                                                            System.out.println("You can use this order name : Home/Back");
                                                            System.out.println("Type the TimeClassStart :");
                                                            System.out.print(StrAddCLI(StrLobbyCLI(), getIdOnline() + "\\University\\" + NameCollege + "\\AddCourse"));
                                                            String s6 = sc.next();
                                                            if (s6.equals("Home")) {
                                                                Home = false;
                                                                break;
                                                            } else if (s6.equals("Back")) {
                                                                break;
                                                            }else {
                                                                try {
                                                                    TimeClassStart = Integer.parseInt(s6);
                                                                    if (TimeClassStart<0 ||TimeClassStart >24){
                                                                        Noorder();
                                                                        break;
                                                                    }
                                                                    System.out.println("You set TimeClassStart: "+TimeClassStart);
                                                                    while (Home) {
                                                                        System.out.println("You can use this order name : Home/Back");
                                                                        System.out.println("Type the TimeClassFinish :");
                                                                        System.out.print(StrAddCLI(StrLobbyCLI(), getIdOnline() + "\\University\\" + NameCollege + "\\AddCourse"));
                                                                        String s7 = sc.next();
                                                                        if (s7.equals("Home")) {
                                                                            Home = false;
                                                                            break;
                                                                        } else if (s7.equals("Back")) {
                                                                            break;
                                                                        }else {
                                                                            try {
                                                                                TimeClassFinish = Integer.parseInt(s7);
                                                                                if (TimeClassFinish<0 || TimeClassFinish > 24 ||TimeClassFinish< TimeClassStart){
                                                                                    Noorder();
                                                                                    break;
                                                                                }
                                                                                System.out.println("You set TimeClassFinish: "+TimeClassFinish);
                                                                                while (Home) {
                                                                                    System.out.println("You can use this order name : Home/Back");
                                                                                    System.out.println("Type the IdCourse :");
                                                                                    System.out.print(StrAddCLI(StrLobbyCLI(), getIdOnline() + "\\University\\" + NameCollege + "\\AddCourse"));
                                                                                    String s8 = sc.next();
                                                                                    if (s8.equals("Home")) {
                                                                                        Home = false;
                                                                                        break;
                                                                                    } else if (s8.equals("Back")) {
                                                                                        break;
                                                                                    } else if (Without(s8)) {
                                                                                        IdCourse = s8;
                                                                                        System.out.println("You set IdCourse: "+IdCourse);
                                                                                        while (Home) {
                                                                                            System.out.println("You set IdCourse: "+IdCourse);
                                                                                            System.out.println("You set TimeClassFinish: "+TimeClassFinish);
                                                                                            System.out.println("You set TimeClassStart: "+TimeClassStart);
                                                                                            System.out.println("You set SizeUnit: "+SizeUnit);
                                                                                            System.out.println("You set SizeMember: "+SizeMember);
                                                                                            System.out.println("You set TimeFinal "+TimeFinal);
                                                                                            System.out.println("You set TeacherName "+TeacherName);
                                                                                            System.out.println("You set NameCourse "+NameCourse);
                                                                                            System.out.println("You can use this order name : Home/Back");
                                                                                            System.out.println("Type the Yes/No :");
                                                                                            System.out.print(StrAddCLI(StrLobbyCLI(), getIdOnline() + "\\University\\" + NameCollege + "\\AddCourse"));
                                                                                            String s9 = sc.next();
                                                                                            if (s9.equals("Home")) {
                                                                                                Home = false;
                                                                                                break;
                                                                                            } else if (s9.equals("Back")) {
                                                                                                break;
                                                                                            } else if (s9.equals("Yes")) {
                                                                                                while (Home) {
                                                                                                    System.out.println("You can use this order name : Home/Back");
                                                                                                    System.out.println("Type the General Or Dedicated :");
                                                                                                    System.out.print(StrAddCLI(StrLobbyCLI(), getIdOnline() + "\\University\\" + NameCollege + "\\AddCourse"));
                                                                                                    String s10 = sc.next();
                                                                                                    if (s10.equals("Home")) {
                                                                                                        Home = false;
                                                                                                        break;
                                                                                                    } else if (s10.equals("Back")) {
                                                                                                        break;
                                                                                                    } else if (s10.equals("General")) {
                                                                                                        University.GetCollege(NameCollege).AddCourseGeneral(TeacherName,NameCourse,IdCourse,SizeMember,SizeUnit,TimeClassStart,TimeClassFinish,TimeFinal);
                                                                                                        System.out.println("seted Course");
                                                                                                        break out;
                                                                                                    } else if (s10.equals("Dedicated")) {
                                                                                                        University.GetCollege(NameCollege).AddCourseDedicated(TeacherName,NameCourse,IdCourse,SizeMember,SizeUnit,TimeClassStart,TimeClassFinish,TimeFinal);
                                                                                                        System.out.println("seted Course");
                                                                                                        break out;
                                                                                                    }else {
                                                                                                        Noorder();
                                                                                                    }
                                                                                                }
                                                                                            } else if (s9.equals("No")) {
                                                                                                break out;
                                                                                            }else {
                                                                                                Noorder();
                                                                                            }
                                                                                        }
                                                                                    }else {
                                                                                        Noorder();
                                                                                    }
                                                                                }
                                                                            }catch (NumberFormatException e ){
                                                                                Noorder();
                                                                            }
                                                                        }
                                                                    }
                                                                }catch (NumberFormatException e ){
                                                                    Noorder();
                                                                }
                                                            }
                                                        }
                                                    }catch (NumberFormatException e ){
                                                        Noorder();
                                                    }
                                                }
                                            }
                                        }catch (NumberFormatException e ){
                                            Noorder();
                                        }
                                    }
                                }
                            }else {
                                Noorder();
                            }
                        }
                    }
                }
            }
        }
    }
    public static boolean Without(String s){
        for (college i : University.ListCollege ) {
            for (General g : i.ListCourseGeneral){
                if (s.equals(g.getIdCourse())){
                    return false;
                }
            }
            for (Dedicated d : i.ListCourseDedicated){
                if (s.equals(d.getIdCourse())){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean TimeFinal(String s ){
        for (int i = 0; i < 4; i++) {
            if (!(s.charAt(i)=='0'||s.charAt(i)=='1'||s.charAt(i)=='2'||s.charAt(i)=='3'||s.charAt(i)=='4'||s.charAt(i)=='5'||s.charAt(i)=='6'||s.charAt(i)=='7'||s.charAt(i)=='8'||s.charAt(i)=='9')){
             return false;
            }
        }
        if (s.charAt(4)=='1'&&s.charAt(5)=='2'){
            if (s.charAt(6)=='0'||s.charAt(6)=='1'||s.charAt(6)=='2'){
                return true;
            }
        }if ((s.charAt(4)=='1'&&(s.charAt(5)=='1'))||(s.charAt(4)=='1'&&(s.charAt(5)=='0'))||(s.charAt(4)=='0'&&((s.charAt(5)=='7'||s.charAt(5)=='8'||s.charAt(5)=='9')))){
            if((s.charAt(6)=='1'||s.charAt(6)=='0'||s.charAt(6)=='2')){
                return true;
            }
            if (s.charAt(6)=='3'&&s.charAt(7)=='0'){
                return true;
            }
        }if ((s.charAt(4)=='0'&&((s.charAt(5)=='6'||s.charAt(5)=='5'||s.charAt(5)=='4'||s.charAt(5)=='3'||s.charAt(5)=='2'||s.charAt(5)=='1')))){
            if((s.charAt(6)=='1'||s.charAt(6)=='0'||s.charAt(6)=='2')){
                return true;
            }
            if ((s.charAt(6)=='3'&&s.charAt(7)=='0')||(s.charAt(6)=='3'&&s.charAt(7)=='1')){
                return true;
            }
        }
        return false;
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