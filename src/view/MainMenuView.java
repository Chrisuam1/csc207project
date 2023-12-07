package view;

import interface_adapter.take_quiz.TakeQuizController;
import view.custom_components.MenuItemJLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.concurrent.TimeUnit;

public class MainMenuView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "main menu";
    Color themeColor = new Color(208, 244, 98);

    ImageIcon backgroundImage = new ImageIcon("src/view/images/main_menu_bg.png");
    ImageIcon startQuizIcon = new ImageIcon("src/view/images/start_quiz.png");

    JLabel backgroundLabel = new JLabel(backgroundImage);

    private final int MENU_ITEM_WIDTH = 300;
    private final int MENU_ITEM_HEIGHT = 400;
    private final int BUTTONS_CENTRE = 500;
    private final int NUM_BUTTONS_START = 100;
    private final int NUM_BUTTONS_WIDTH = 100;

    MenuItemJLabel startQuizButton = new MenuItemJLabel("start quiz", startQuizIcon, MENU_ITEM_WIDTH, MENU_ITEM_HEIGHT, 50);
    MenuItemJLabel exitButton = new MenuItemJLabel("exit", 200);
    MenuItemJLabel numButton1 = new MenuItemJLabel("5", 100);
    MenuItemJLabel numButton2 = new MenuItemJLabel("10", 100);
    MenuItemJLabel numButton3 = new MenuItemJLabel("20", 100);

    private int numQuestions = 5;

    public MainMenuView(TakeQuizController controller) {
        this.setLayout(null);
        backgroundLabel.setBounds(0,0,1920,1080);
        this.add(backgroundLabel);

        backgroundLabel.setLayout(null);

        JLabel label1 = new JLabel();
        label1.setBackground(Color.red);
        label1.setOpaque(true);
        label1.setPreferredSize(new Dimension(100,100));

        backgroundLabel.add(startQuizButton);
        startQuizButton.setBounds(1000-MENU_ITEM_WIDTH/2,425,MENU_ITEM_WIDTH,MENU_ITEM_HEIGHT);

        backgroundLabel.add(exitButton);
        backgroundLabel.add(numButton1);
        backgroundLabel.add(numButton2);
        backgroundLabel.add(numButton3);

        exitButton.setBounds(1400, BUTTONS_CENTRE, 250, 100);
        numButton1.setBounds(NUM_BUTTONS_START, BUTTONS_CENTRE, NUM_BUTTONS_WIDTH + 50, NUM_BUTTONS_WIDTH);
        numButton2.setBounds(NUM_BUTTONS_START + 200, BUTTONS_CENTRE, NUM_BUTTONS_WIDTH + 50, NUM_BUTTONS_WIDTH);
        numButton3.setBounds(NUM_BUTTONS_START + 400, BUTTONS_CENTRE, NUM_BUTTONS_WIDTH + 50, NUM_BUTTONS_WIDTH);


        // By default, the first button is enabled
        numButton1.setLocation(NUM_BUTTONS_START, BUTTONS_CENTRE - 25);
        numButton1.setEnabled(false);

        startQuizButton.button.addMouseListener(
                new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        controller.execute(numQuestions);
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }
                }
        );

        numButton1.button.addMouseListener(
                new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        numButton1.setLocation(NUM_BUTTONS_START, BUTTONS_CENTRE - 25);
                        numButton1.setEnabled(false);
                        numQuestions = 5;
                        numButton2.setEnabled(true);
                        numButton3.setEnabled(true);
                        numButton2.setLocation(NUM_BUTTONS_START + 200, BUTTONS_CENTRE);
                        numButton3.setLocation(NUM_BUTTONS_START + 400, BUTTONS_CENTRE);
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }
                }
        );

        numButton2.button.addMouseListener(
                new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        numButton2.setLocation(NUM_BUTTONS_START + 200, BUTTONS_CENTRE - 25);
                        numButton2.setEnabled(false);
                        numQuestions = 10;
                        numButton1.setEnabled(true);
                        numButton3.setEnabled(true);
                        numButton1.setLocation(NUM_BUTTONS_START, BUTTONS_CENTRE);
                        numButton3.setLocation(NUM_BUTTONS_START + 400, BUTTONS_CENTRE);
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }
                }
        );

        numButton3.button.addMouseListener(
                new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        numButton3.setLocation(NUM_BUTTONS_START + 400, BUTTONS_CENTRE -25);
                        numButton3.setEnabled(false);
                        numQuestions = 20;
                        numButton2.setEnabled(true);
                        numButton1.setEnabled(true);
                        numButton2.setLocation(NUM_BUTTONS_START + 200, BUTTONS_CENTRE);
                        numButton1.setLocation(NUM_BUTTONS_START, BUTTONS_CENTRE);
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }
                }
        );

        exitButton.button.addMouseListener(
                new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        try {
                            TimeUnit.SECONDS.sleep(2);
                        } catch (Exception exception) {
                            System.out.println(exception.getMessage());
                        }
                        System.exit(1);
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }
                }
        );
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
