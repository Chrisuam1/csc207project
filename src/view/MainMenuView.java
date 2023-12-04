package view;

import view.custom_components.MenuItemJLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuView extends JPanel implements ActionListener {

    public final String viewName = "main menu";
    Color themeColor = new Color(208, 244, 98);

    ImageIcon backgroundImage = new ImageIcon("src/view/images/main_menu_bg.png");
    ImageIcon startQuizIcon = new ImageIcon("src/view/images/start_quiz.png");

    JLabel backgroundLabel = new JLabel(backgroundImage);
    JLabel exitButton = new JLabel("exit");
    MenuItemJLabel startQuizButton = new MenuItemJLabel("start quiz", startQuizIcon);

    // TODO: make constructor with controller and viewModel argument
    public MainMenuView() {
        this.setLayout(null);
        backgroundLabel.setBounds(0,0,1920,1080);
        this.add(backgroundLabel);

        backgroundLabel.setLayout(null);

        JLabel label1 = new JLabel();
        label1.setBackground(Color.red);
        label1.setOpaque(true);
        label1.setPreferredSize(new Dimension(100,100));

        backgroundLabel.add(startQuizButton);
        startQuizButton.setBackground(Color.green);
        startQuizButton.setOpaque(true);

        startQuizButton.setBounds(0,0,250,250);




//        this.setBackground(themeColor);
//        this.setLayout(new BorderLayout());
//
//        JLabel title = new JLabel("presented by");
//        this.add(title);
//        title.setHorizontalAlignment(SwingConstants.CENTER);
//        title.setVerticalAlignment(SwingConstants.CENTER);
//        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
//        title.setHorizontalTextPosition(JLabel.CENTER);
//        title.setVerticalTextPosition(JLabel.TOP);
//        title.setForeground(Color.black);
//        title.setIcon(icon);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
