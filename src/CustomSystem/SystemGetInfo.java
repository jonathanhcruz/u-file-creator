package CustomSystem;

import java.util.Scanner;

public class SystemGetInfo {
  final private String stringToPrint;

    public SystemGetInfo(String stringToPrint) {
        this.stringToPrint = stringToPrint;
    }

    public String getResponse () {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(stringToPrint);
        return scanner.nextLine();
    }
}
