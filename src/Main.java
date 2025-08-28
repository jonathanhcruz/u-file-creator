import CustomSystem.SystemProgram;
import file.control.File;

public class Main {
    public static void main(String[] args) {
        final Actions actions = new Actions();
        executeAction(new SystemProgram(), null, actions);
    }

    public static void executeAction(SystemProgram systemProgram, File file, Actions actions) {
        final int actionNumber = systemProgram.Run();
        File contextFile = file;

        System.out.println('\n');
        System.out.println('\n');

        if (actionNumber == 6) {
            System.out.println("Goodbye");
            System.exit(0);
            return;
        }

        switch (actionNumber) {
            case 1:
                contextFile = actions.createAction(contextFile);
                executeAction(systemProgram, contextFile, actions);
                break;
            case 2:
                actions.readAction(contextFile);
                executeAction(systemProgram, contextFile, actions);
                break;
            case 3:
                actions.editAction(contextFile);
                executeAction(systemProgram, contextFile, actions);
                break;
            case 4:
                actions.cleanUpAction(contextFile);
                executeAction(systemProgram, contextFile, actions);
                break;
            case 5:
                actions.deleteAction(contextFile);
                executeAction(systemProgram, null, actions);
                return;
            default:
                System.out.println("[Opción no válida]");
                break;
        }

        System.out.println('\n');
        System.gc(); // Garbage collector to free up memory
        executeAction(systemProgram, null, actions);
    }
}
