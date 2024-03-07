package shahadat;
import java.util.HashSet;

public class User {
    static HashSet<String> ID= new HashSet<String>();
    User(){
    }

    Boolean IsCorrectID (String id){
       return ID.contains(id);
    }
}
