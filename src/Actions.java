import CustomSystem.SystemGetInfo;
import file.control.File;

public class Actions {
    public File createAction(File contextFile) {
        System.out.println("[Acción 1: Select or create a file]");

        // Get file name and extension from user
        SystemGetInfo nameFile = new SystemGetInfo("Enter the name of the file (without extension):");
        String fileName = nameFile.getResponse();
        SystemGetInfo extensionFile = new SystemGetInfo("Enter the extension of the file (e.g., txt, json):");
        String fileExtension = extensionFile.getResponse();

        System.out.println('\n');
        return contextFile = new File(fileName, fileExtension);
    }

    public void readAction(File contextFile) {
        System.out.println("[Acción 2: Read file contents]");
        if(contextFile == null) {
            System.out.println("No file selected. Please select or create a file first.");
            System.out.println('\n');
            return;
        }
        System.out.println("Reading file: " + contextFile.getFullName() + " contents:");

        System.out.println('\n');
        contextFile.read();

        System.out.println('\n');
    }

    public void editAction(File contextFile) {
        System.out.println("[Acción 3: Edit file contents]");
        if(contextFile == null) {
            System.out.println("No file selected. Please select or create a file first.");
            System.out.println('\n');
            return;
        }

        SystemGetInfo newContent = new SystemGetInfo("Enter the new content to write to the file:");
        String content = newContent.getResponse();

        contextFile.edit(content);

        System.out.println("Editing file: " + contextFile.getFullName());
        System.out.println("File editing functionality is not yet implemented.");

        System.out.println('\n');
    }

    public void cleanUpAction(File contextFile) {
        System.out.println("[Acción 4: Clean up file]");
        if(contextFile == null) {
            System.out.println("No file selected. Please select or create a file first.");
            System.out.println('\n');
            return;
        }

        contextFile.edit("");

        System.out.println("File cleaned: " + contextFile.getFullName());

        System.out.println('\n');
    }

    public void deleteAction(File contextFile) {
        System.out.println("[Acción 5: Delete file]");
        if(contextFile == null) {
            System.out.println("No file selected. Please select or create a file first.");
            System.out.println('\n');
            return;
        }

        java.io.File fileRef = contextFile.getFileRef();
        if (fileRef.delete()) {
            System.out.println("File deleted: " + contextFile.getFullName());
        } else {
            System.out.println("Failed to delete the file: " + contextFile.getFullName());
        }

        System.out.println('\n');
    }
}
