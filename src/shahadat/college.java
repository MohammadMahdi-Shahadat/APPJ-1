package shahadat;

import java.util.ArrayList;

public class college {
    private String CollegeName;
    static ArrayList<course> ListCourse = new ArrayList<>();

    public college(String CollegeName) {
        this.CollegeName = CollegeName;
    }

    public static void AddCourse(){
    }

    public String getCollegeName() {
        return CollegeName;
    }
}
