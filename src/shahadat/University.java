package shahadat;

import java.util.ArrayList;
import java.util.Objects;


public class University {
    static ArrayList<college> ListCollege = new ArrayList<>();

    public University() {
    }
    public static void AddCollege(String NameCollege){
        ListCollege.add(new college(NameCollege));
    }
    public static void HardCode(){
        AddCollege("MathematicalScience");
        AddCollege("Physics");
        AddCollege("ComputerEngineering");
        AddCollege("IslamicKnowledge&Education");
        GetCollege("MathematicalScience").AddCourseDedicated("Dr.Moghadasi","Math1","000",5,4,10,12,"14030309");
        GetCollege("MathematicalScience").AddCourseDedicated("Dr.SHahshahani","Algebra Liner","001",2,4,13,15,"14030315");
        GetCollege("MathematicalScience").AddCourseGeneral("Dr.ArashAckmall","Persian the literature","002",8,3,15,17,"14030228");
        GetCollege("MathematicalScience").AddCourseDedicated("Dr.Boomari","AP","003",5,4,13,15,"14030316");
        //set college1
        GetCollege("Physics").AddCourseDedicated("Dr.kargarian","Physics1","100",3,3,12,14,"14030309");
        GetCollege("Physics").AddCourseDedicated("Dr.Bagheri","Physics2","101",6,3,8,10,"14030320");
        GetCollege("Physics").AddCourseDedicated("Dr.rezaee","Atomic","102",1,3,18,20,"14030317");
        GetCollege("Physics").AddCourseGeneral("Dr.ArashAkmal","Persian the literature","103",3,3,17,19,"14030319");
        //Physics Seted
        GetCollege("ComputerEngineering").AddCourseDedicated("Dr.Rahimi","database","201",1,3,20,22,"14030320");
        GetCollege("ComputerEngineering").AddCourseDedicated("Dr.Sharieaty","Linux","202",3,3,14,16,"14030318");
        GetCollege("ComputerEngineering").AddCourseGeneral("Dr.Mortazavy","English","203",4,3,12,14,"14030313");
        //CE seted
        GetCollege("IslamicKnowledge&Education").AddCourseGeneral("Rohani","How to find key","301",1,2,12,14,"14030329");
        GetCollege("IslamicKnowledge&Education").AddCourseGeneral("Raeesy","How to find God","302",4,2,6,8,"14030327");
        GetCollege("IslamicKnowledge&Education").AddCourseGeneral("Helali","Islamic in iran","303",2,2,8,10,"14030305");
        //IslamicSet
        //Example
        User.GetStudent("402109742").AddCourseGeneralInList("IslamicKnowledge&Education","303");
//
//        University.GetCollege("Islamic Knowledge & Education").GetGeneral("303").PrintStudentInCourse();
//
//        User.GetStudent("402109742").RemoveStudentGeneral("Islamic Knowledge & Education","303");
//
//        University.GetCollege("Islamic Knowledge & Education").GetGeneral("303").PrintStudentInCourse();
    }
    public static college GetCollege(String college){
        for (college i : ListCollege) {
            if (i.getCollegeName().equals(college)) {
                return i;
            }
        }
        return null;
    }
    public static void PrintCollege(){
        System.out.println("##############################################################################");
        System.out.println("LIST OF College: ");
        int l =1 ;
        for (college i : ListCollege){
            System.out.println(l +"_ "+i.getCollegeName());
            l++;
        }
        System.out.println("##############################################################################");
    }
}
