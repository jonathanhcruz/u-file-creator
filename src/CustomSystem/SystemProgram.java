package CustomSystem;

public class SystemProgram {
  public SystemProgram() {
    System.out.println("welcome ");
  }

  public int Run(){
    System.out.println("What do you want to do?");
    System.out.println("1. Create new file or set file");
    System.out.println("2. Read file content");
    System.out.println("3. Edit file content");
    System.out.println("4. Clean up file");
    System.out.println("5. Delete file");
    System.out.println("6. Exit");

    final SystemGetInfo systemGetInfo = new SystemGetInfo("Enter the number of the action you want to perform");
    final String action = systemGetInfo.getResponse();
    final int actionNumber = Integer.parseInt(action);

    return actionNumber;
  }
}
