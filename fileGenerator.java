import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class fileGenerator {

    public static void generateDirectory() {

        try {

            // Set a path of the directory to save
            Path path = Paths.get("C:/Users/jeons/OneDrive/Desktop/CSE_Slide_Sample");
        
            //java.nio.file.Files;
            Files.createDirectories(path);
        
            // Success message
            System.out.println("Directory is created!");
        
          } catch (IOException e) {
        
            System.err.println("Failed to create directory!" + e.getMessage());
        
          }

    }
    public static void main(String[] args) throws FileNotFoundException {
       
    

    }
}
