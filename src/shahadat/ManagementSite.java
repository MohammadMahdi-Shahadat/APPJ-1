package shahadat;

import java.util.Objects;
import java.util.Scanner;
import java.util.SortedMap;

public class ManagementSite implements Runnable {
    private Scanner sc;
    private String s ;

    @Override
    public void run() {
        RunFirst();
        s = StrCli.StrLobbyCLI();
        while (true) {
            Runaway();
        }
    }
    private void RunFirst(){
        initScanner();
        User.HardCodeUser();
        University.HardCode();
    }
    private void initScanner() {
        sc = new Scanner(System.in);
    }
    private void Runaway(){
        System.out.println("You can use this order name : SignUp / type (user | pass) (Login with your username)");
        System.out.print(StrCli.StrAddCLI(StrCli.StrLobbyCLI(),""));
        StrCli.Login(sc.next());
    }
}
