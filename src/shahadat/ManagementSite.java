package shahadat;

import java.util.Scanner;
import java.util.SortedMap;

public class ManagementSite implements Runnable {
    private Scanner sc;
    private Teacher teacher;
    private Student student;
    private String s ;

    @Override
    public void run() {
        this.student = new Student();
        initScanner();
        s = StrCli.StrLobbyCLI();
        while (true) {
            System.out.print(s);
            System.out.println(StrCli.StrAddCLI(s, (student.IsCorrectID(sc.next())).toString()));
        }
    }
    private void initScanner() {
        sc = new Scanner(System.in);
    }

}
