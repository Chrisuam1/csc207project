package view;

import javax.swing.*;
import java.awt.*;

public class LogoScreenView extends JPanel {
    public final String viewName = "logo screen";

    public LogoScreenView() {

        Color themeColor = new Color(208, 244, 98);
        ImageIcon icon = new ImageIcon("src/view/images/fatcat_logo.png");
        this.setBackground(themeColor);
        this.setLayout(new BorderLayout());

        JLabel title = new JLabel("presented by");
        this.add(title);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.CENTER);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
        title.setHorizontalTextPosition(JLabel.CENTER);
        title.setVerticalTextPosition(JLabel.TOP);
        title.setForeground(Color.black);
        title.setIcon(icon);

    }
}