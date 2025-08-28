package file.control;

import java.io.IOException;

public class File {
    private String name;
    private String extension;
    private String path;
    private java.io.File fileRef;

    public File(String name, String extension) {
        this.name = name;
        this.extension = extension;
        this.path = System.getProperty("user.dir") + "/files";
        String fullPath = this.path + "/" + name + "." + extension;
        this.fileRef = new java.io.File(fullPath);

        create();
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getExtension() {
        return extension;
    }

    public String getFullName() {
        return name + "." + extension;
    }

    public String getPath() {
        return path;
    }

    public java.io.File getFileRef() {
        return fileRef;
    }

    // Create the file on the filesystem
    public void create() {
        try {
            if (!fileRef.exists()) {
                fileRef.createNewFile();
                return;
            }

            this.path = fileRef.getParent();
            String fileName = fileRef.getName();
            int dotIndex = fileName.lastIndexOf('.');
            if (dotIndex > 0 && dotIndex < fileName.length() - 1) {
                this.name = fileName.substring(0, dotIndex);
                this.extension = fileName.substring(dotIndex + 1);
            } else {
                this.name = fileName;
                this.extension = "";
            }
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }
    }

    // Reads the file and prints its content to the console
    public void read() {
        try (java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(fileRef))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (java.io.IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Edits (overwrites) the file with new content
    public void edit(String newContent) {
        try (java.io.BufferedWriter writer = new java.io.BufferedWriter(new java.io.FileWriter(fileRef, false))) {
            writer.write(newContent);
            writer.flush();
        } catch (java.io.IOException e) {
            System.out.println("Error editing file: " + e.getMessage());
        }
    }

}
