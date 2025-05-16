package classtasks;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class FileExercise {

    public static void main(String... args){
        File file = new File("C:\\Users\\Dell\\Desktop\\SemiColon-Assignment\\ChibuzorTasks\\classTasks\\src\\classtasks\\File.txt");
        try(
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                FileInputStream fileInputStream = new FileInputStream(file);
                ){
            objectOutputStream.write(65);
            byte[] value = objectOutputStream.readAllBytes();
            System.out.println(Arrays.toString(value));
            String message = new String(value);
            System.out.println(message);






        }catch (IOException error){
            exception.printStackTrace();
        }
    }
}
