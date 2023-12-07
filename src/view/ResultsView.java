package view;

import interface_adapter.ViewManagerModel;
import interface_adapter.answer_question.AnswerQuestionViewModel;
import view.custom_components.MenuItemJLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ResultsView extends JPanel implements PropertyChangeListener {

    public final String viewName = "results";
    private final AnswerQuestionViewModel answerQuestionViewModel;
    private final MainMenuView mainMenuView;
    private final ViewManagerModel viewManagerModel;

    ImageIcon backgroundImage = new ImageIcon("src/view/images/results_bg.png");
    JLabel backgroundLabel = new JLabel("");

    final int HEADER_Y = 200;
    final int CONTENT_Y = 500;
    final int MIDDLE_X = 960;
    final int MIDDLE_Y = 540;
    final int LEFT_X = 1920;
    final int FONT_SIZE = 50;

    JLabel scoreLabel = new JLabel("1234");
    JLabel messageLabel = new JLabel("final score");
    MenuItemJLabel mainMenuLabel = new MenuItemJLabel("main menu", 400);

    public ResultsView(ViewManagerModel viewManagerModel, MainMenuView mainMenuView, AnswerQuestionViewModel answerQuestionViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.mainMenuView = mainMenuView;
        this.answerQuestionViewModel = answerQuestionViewModel;
        this.setLayout(null);
        backgroundLabel.setBounds(0,0,1920,1080);
        backgroundLabel.setIcon(backgroundImage);
        this.add(backgroundLabel);

        messageLabel.setBounds(MIDDLE_X - 200, MIDDLE_Y - 200, 400, FONT_SIZE + 10);
        backgroundLabel.add(messageLabel);
        messageLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, FONT_SIZE));

        scoreLabel.setBounds(MIDDLE_X - 200, MIDDLE_Y - 100, 400, FONT_SIZE + 50);
        backgroundLabel.add(scoreLabel);
        scoreLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, FONT_SIZE + 40));

        mainMenuLabel.setBounds(MIDDLE_X - 250, MIDDLE_Y + 300, 500, 150);
        backgroundLabel.add(mainMenuLabel);

        mainMenuLabel.button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                viewManagerModel.setActiveView(mainMenuView.viewName);
                viewManagerModel.firePropertyChanged();
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
        });



    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.scoreLabel.setText(answerQuestionViewModel.SCORE_LABEL + String.format("%.0f", answerQuestionViewModel.getState().getScore()));
    }

    public void updateFields() {
        this.scoreLabel.setText(answerQuestionViewModel.SCORE_LABEL + String.format("%.0f", answerQuestionViewModel.getState().getScore()));
    }
}
