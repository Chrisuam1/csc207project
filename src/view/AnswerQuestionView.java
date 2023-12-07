package view;

import interface_adapter.answer_question.AnswerQuestionViewModel;
import interface_adapter.answer_question.AnswerQuestionController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AnswerQuestionView extends JPanel implements ActionListener, PropertyChangeListener {

    public static String viewName = "question";


    public AnswerQuestionView(AnswerQuestionController answerQuestionController, AnswerQuestionViewModel answerQuestionViewModel) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
