package classtasks;

import java.io.*;

public class DateInputStream {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\Dell\\Desktop\\SemiColon-Assignment\\ChibuzorTasks\\classTasks\\src\\classtasks\\NewFile.txt");

        try(
                FileInputStream fis = new FileInputStream(file);
                DataInputStream dis = new DataInputStream(fis);
                FileOutputStream fos = new FileOutputStream(file);
                DataOutputStream dos = new DataOutputStream(fos);


        ){
            dos.writeUTF("Hello, world!");
            byte[] word = dis.readUTF().getBytes();
            System.out.println(new String(word));
        }catch (IOException e){
            e.printStackTrace();
        }

    }


}
