package classtasks;

import javax.swing.*;

public class GUIExercise {

    public static void main(String[] args) {
        home();
    }

    public static void home() {
        JFrame frame = new JFrame("DashBoard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        frame.add(panel);
    }


}
