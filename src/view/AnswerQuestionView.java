package view;

import interface_adapter.answer_question.AnswerQuestionState;
import interface_adapter.answer_question.AnswerQuestionViewModel;
import interface_adapter.answer_question.AnswerQuestionController;
import view.custom_components.MenuItemJLabel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;

public class AnswerQuestionView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "question";
    private final AnswerQuestionViewModel answerQuestionViewModel;
    private final AnswerQuestionController answerQuestionController;

    ImageIcon backgroundImage1 = new ImageIcon("src/view/images/answer_question_bg1.png");
    JLabel backgroundLabel;

    final int HEADER_Y = 200;
    final int CONTENT_Y = 500;
    final int MIDDLE_X = 960;
    final int LEFT_X = 1920;
    final int FONT_SIZE = 50;

    JLabel questionLabel;
    JLabel scoreLabel;
    JLabel questionNumberLabel;
    MenuItemJLabel songLabel1;
    MenuItemJLabel songLabel2;

    public AnswerQuestionView(AnswerQuestionController answerQuestionController, AnswerQuestionViewModel answerQuestionViewModel) {
        this.setLayout(null);
        this.answerQuestionController = answerQuestionController;
        this.answerQuestionViewModel = answerQuestionViewModel;
        this.answerQuestionViewModel.addPropertyChangeListener(this);

        // TODO: TESTING VALUES FOR VIEW MODEL
        AnswerQuestionState state = new AnswerQuestionState();
        state.setScore(1234.0);
        state.setQuestionNumber(5);
        state.setArtistName1("Artist1");
        state.setArtistName2("Artist2");
        state.setSongName1("SongTitle1");
        state.setSongName2("SongTitle2");
        state.setAlbumName1("AlbumTitle1");
        state.setAlbumName2("AlbumTitle2");

        // TODO: TESTING RESOURCES
        BufferedImage songIcon = null;
        try {
            songIcon = ImageIO.read(new File("src/view/images/start_quiz.png"));
            state.setCoverImage1(songIcon);
            state.setCoverImage2(songIcon);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        //this.answerQuestionViewModel.setState(state);

        // TODO: randomize background somehow
        backgroundLabel = new JLabel(backgroundImage1);
        backgroundLabel.setBounds(0,0,1920,1080);
        this.add(backgroundLabel);
        backgroundLabel.setLayout(null);

        questionLabel = new JLabel(this.answerQuestionViewModel.QUESTION_LABEL);
        backgroundLabel.add(questionLabel);
        questionLabel.setBounds(MIDDLE_X - 350, HEADER_Y, 700, FONT_SIZE + 10);
        questionLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, FONT_SIZE));

        scoreLabel = new JLabel(this.answerQuestionViewModel.SCORE_LABEL + " " + String.format("%.0f", this.answerQuestionViewModel.getState().getScore()));
        backgroundLabel.add(scoreLabel);
        scoreLabel.setBounds(LEFT_X - 300, HEADER_Y, 200, FONT_SIZE + 10);
        scoreLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, FONT_SIZE));

        questionNumberLabel = new JLabel(this.answerQuestionViewModel.QUESTION_NUMBER_LABEL + Integer.toString(this.answerQuestionViewModel.getState().getQuestionNumber()));
        backgroundLabel.add(questionNumberLabel);
        questionNumberLabel.setBounds(120, HEADER_Y, 120, FONT_SIZE + 10);
        questionNumberLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, FONT_SIZE));

        // using html to format text and include multiple lines in a single JLabel
        String songHtml1 = getSong1Html(answerQuestionViewModel.getState());
        songLabel1 = new MenuItemJLabel(songHtml1, new ImageIcon(state.getCoverImage1()), 300, 600, 30);
        backgroundLabel.add(songLabel1);
        songLabel1.setBounds(MIDDLE_X - 500, CONTENT_Y, 300, 600);

        String songHtml2 = getSong1Html(answerQuestionViewModel.getState());
        songLabel2 = new MenuItemJLabel(songHtml2, new ImageIcon(state.getCoverImage2()), 300, 600, 30);
        backgroundLabel.add(songLabel2);
        songLabel2.setBounds(MIDDLE_X + 150, CONTENT_Y, 300, 600);

        // TODO: DEBUG
        boolean TEST = false;
        if (TEST) {
            questionLabel.setBackground(Color.white);
            questionLabel.setOpaque(true);
            scoreLabel.setBackground(Color.white);
            scoreLabel.setOpaque(true);
            questionNumberLabel.setBackground(Color.white);
            questionNumberLabel.setOpaque(true);
        }

        songLabel1.button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                boolean correct =
                    answerQuestionViewModel.getState().getQuizTaker().getCurrentQuestion().getSong1() ==
                            answerQuestionViewModel.getState().getQuizTaker().getCurrentQuestion().getAnswer();
                if (correct) {
                    answerQuestionController.executeCorrectAnswer(answerQuestionViewModel.getState().getQuizTaker(),
                            answerQuestionViewModel.getState().getQuizTaker().getCurrentQuestion().getPointsAwarded());
                } else {
                    answerQuestionController.executeIncorrectAnswer(answerQuestionViewModel.getState().getQuizTaker(),
                            0.0);
                }
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

        songLabel2.button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                boolean correct =
                        answerQuestionViewModel.getState().getQuizTaker().getCurrentQuestion().getSong2() ==
                                answerQuestionViewModel.getState().getQuizTaker().getCurrentQuestion().getAnswer();
                if (correct) {
                    answerQuestionController.executeCorrectAnswer(answerQuestionViewModel.getState().getQuizTaker(),
                            answerQuestionViewModel.getState().getQuizTaker().getCurrentQuestion().getPointsAwarded());
                } else {
                    answerQuestionController.executeIncorrectAnswer(answerQuestionViewModel.getState().getQuizTaker(),
                            0.0);
                }
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
    public void actionPerformed(ActionEvent e) {
    }

    private String getSong1Html(AnswerQuestionState state) {
        return "<html>" + state.getSongName1()
                + "<br><font size=\"+2\"><em>" +  state.getArtistName1()
                + "</em></font><br><font size=\"+0\">" +  state.getAlbumName1()
                + "</font></html>";
    }

    private String getSong2Html(AnswerQuestionState state) {
        return "<html>" + state.getSongName2()
                + "<br><font size=\"+2\"><em>" +  state.getArtistName2()
                + "</em></font><br><font size=\"+0\">" +  state.getAlbumName2()
                + "</font></html>";
    }

    private void updateFields() {
        this.songLabel1.updateLabel(getSong1Html(answerQuestionViewModel.getState()),
                new ImageIcon(answerQuestionViewModel.getState().getCoverImage1()), 250, 250);
        this.songLabel2.updateLabel(getSong2Html(answerQuestionViewModel.getState()),
                new ImageIcon(answerQuestionViewModel.getState().getCoverImage2()), 250, 250);
        this.scoreLabel.setText(answerQuestionViewModel.SCORE_LABEL + String.format("%.0f", answerQuestionViewModel.getState().getScore()));
        this.questionNumberLabel.setText(answerQuestionViewModel.QUESTION_NUMBER_LABEL + Integer.toString(answerQuestionViewModel.getState().getQuestionNumber()));
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        updateFields();
    }
}
