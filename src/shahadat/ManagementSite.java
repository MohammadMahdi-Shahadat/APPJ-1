package shahadat;

import java.util.Objects;
import java.util.Scanner;
import java.util.SortedMap;

public class ManagementSite implements Runnable {
    private Scanner sc;
    public User user;
    private String s ;

    @Override
    public void run() {
        RunFirst();
        s = StrCli.StrLobbyCLI();
        while (true) {
            System.out.print(s);
            System.out.println(StrCli.StrAddCLI(s, (user.IsCorrectID(sc.next())).toString()));
        }
    }
    private void RunFirst(){
        this.user = new User();
        User.HardCodeUser();
        University.HardCode();
        initScanner();
    }
    private void initScanner() {
        sc = new Scanner(System.in);
    }

}
