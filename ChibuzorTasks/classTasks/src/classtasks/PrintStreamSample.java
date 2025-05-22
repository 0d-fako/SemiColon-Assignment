package classtasks;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamSample {
    public static void main(String[] args) {
        String path = "C:\\Users\\Dell\\Desktop\\SemiColon-Assignment\\ChibuzorTasks\\classTasks\\src\\classtasks\\File.txt";

        try(PrintStream printStream = new PrintStream(path)){

            System.setOut(printStream);

            System.out.println("Here is to becoming a great engineer");

        }catch(FileNotFoundException error){
            error.printStackTrace();
        }

        try(FileInputStream fileInputStream = new FileInputStream(path)){
            fileInputStream.transferTo(System.out);

        }catch (IOException error){
            error.printStackTrace();
        }
    }
}
