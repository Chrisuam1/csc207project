package view;

import javax.swing.*;
import java.awt.*;

public class LoadingScreenView extends JPanel {
    public final String viewName = "loading screen";

    public LoadingScreenView() {

        Color themeColor = new Color(208, 244, 98);
        ImageIcon icon = new ImageIcon("src/view/images/load.png");
        this.setBackground(Color.black);
        this.setLayout(new BorderLayout());

        JLabel title = new JLabel("loading...");
        this.add(title);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.CENTER);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 60));
        title.setHorizontalTextPosition(JLabel.CENTER);
        title.setVerticalTextPosition(JLabel.BOTTOM);
        title.setForeground(themeColor);
        title.setIcon(icon);

        //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //title.setBackground(Color.white);
        //title.setSize((int)(screenSize.getWidth() / 2), (int)(screenSize.getHeight() / 2));
        //title.setOpaque(true);
        //this.setSize(100, 100);

    }
}
