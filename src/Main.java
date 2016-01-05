import javax.swing.*;
import java.awt.*;

/**
 * Created by koolzz on 12/27/2015.
 */
public class Main {
    public static void main(String[]args){
        JFrame f=new JFrame("Game of life");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        f.setSize((int)width,(int)height);
        f.setVisible(true);
        f.add(new Canvas(100));
        f.repaint();
    }
}
