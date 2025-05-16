package classtasks;

import java.io.*;
import java.util.Arrays;

public class FileExercise {

    public static void main(String... args){
        File file = new File("C:\\Users\\Dell\\Desktop\\SemiColon-Assignment\\ChibuzorTasks\\classTasks\\src\\classtasks\\File.txt");
        try(
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                FileInputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                ){



            User user = new User();
            user.setEmail("ollunimati@gmail.com");
            user.setPassword("1234");
            user.setFirstName("Olumide");
            user.setLastName("Fakorede");
            objectOutputStream.writeObject(user);

//            User foundUser = (User) objectInputStream.readObject();

//            objectOutputStream.write(65);
//            byte[] value = objectOutputStream.readAllBytes();
//            System.out.println(Arrays.toString(value));
//            String message = new String(value);
//            System.out.println(message);






        }catch (IOException error ){
            error.printStackTrace();
        }
    }
}
