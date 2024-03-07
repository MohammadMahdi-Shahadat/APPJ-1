package shahadat;

import java.util.ArrayList;


public class University {
    static ArrayList<college> ListCollege = new ArrayList<>();

    public University() {
    }
    public static void AddCollege(String NameCollege){
        ListCollege.add(new college(NameCollege));
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
