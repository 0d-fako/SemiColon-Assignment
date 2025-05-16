package classtasks;

import java.io.*;
import java.util.Arrays;

public class FileExercise {

    public static void main(String... args){
        File file = new File("C:\\Users\\Dell\\Desktop\\SemiColon-Assignment\\ChibuzorTasks\\classTasks\\src\\classtasks\\NewFile.txt");
        try(
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
      //          FileInputStream fileInputStream = new FileInputStream(file);
    //            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                ){

            User user = new User();
            user.setEmail("ollunimati@gmail.com");
            user.setPassword("1234");
            user.setFirstName("Olumide");
            user.setLastName("Fakorede");
            objectOutputStream.writeObject(user);

            System.out.println(user);

        }catch (IOException  error ){
            error.printStackTrace();
        }

        try(    FileInputStream newFile = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(newFile)){

            User foundUser = (User) objectInputStream.readObject();
            System.out.println(foundUser);

        }catch(ClassNotFoundException error){
            error.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
