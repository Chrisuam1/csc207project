package app;

import api.ApiHandlerClient;
import data_access.FileSongsDataAccessObject;
import entities.factories.SpotifyApiSongFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.answer_question.AnswerQuestionViewModel;
import interface_adapter.take_quiz.TakeQuizController;
import interface_adapter.take_quiz.TakeQuizPresenter;
import use_case.take_quiz.TakeQuizInputBoundary;
import use_case.take_quiz.TakeQuizInteractor;
import use_case.take_quiz.TakeQuizOutputBoundary;
import view.*;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final String CSV_FILE = "topSongs.csv";

    //Test environment variables
    private static final String ID = System.getenv("ID");
    private static final String SECRET = System.getenv("SECRET");

    public static void main(String[] args) {

        System.out.println("ID=" + ID + "; SECRET=" + SECRET);

        final boolean TESTING = false;
        try {

            // Initialize API and authenticate, create DAO (still needs to be initialized)
            ApiHandlerClient api = new ApiHandlerClient(ID, SECRET);

            if (!TESTING){
                api.authenticate();
            }
            FileSongsDataAccessObject fileSongsDAO = new FileSongsDataAccessObject(CSV_FILE, new SpotifyApiSongFactory(api));

            // Build the main program window, the main panel containing the
            // various cards, and the layout, and stitch them together.
            // The main application window.
            JFrame application = new JFrame("Spotify Quiz");
            application.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            application.setExtendedState(JFrame.MAXIMIZED_BOTH);
            application.setUndecorated(true);
            CardLayout cardLayout = new CardLayout();

            // The various View objects. Only one view is visible at a time.
            JPanel views = new JPanel(cardLayout);
            application.add(views);
            ViewManagerModel viewManagerModel = new ViewManagerModel();

            LoadingScreenView loadingScreenView = new LoadingScreenView();
            views.add(loadingScreenView, loadingScreenView.viewName);

            LogoScreenView logoScreenView = new LogoScreenView();
            views.add(logoScreenView, logoScreenView.viewName);

            AnswerQuestionViewModel answerQuestionViewModel = new AnswerQuestionViewModel();
            TakeQuizOutputBoundary takeQuizPresenter = new TakeQuizPresenter(answerQuestionViewModel, viewManagerModel);
            TakeQuizInputBoundary takeQuizInteractor = new TakeQuizInteractor(takeQuizPresenter, fileSongsDAO);
            TakeQuizController takeQuizController = new TakeQuizController(takeQuizInteractor);

            MainMenuView mainMenuView = new MainMenuView(takeQuizController);
            views.add(mainMenuView, mainMenuView.viewName);

            ResultsView resultsView = new ResultsView(viewManagerModel, mainMenuView, answerQuestionViewModel);
            views.add(resultsView, resultsView.viewName);

            AnswerQuestionView answerQuestionView = AnswerQuestionUseCaseFactory.create(viewManagerModel, answerQuestionViewModel, resultsView);
            views.add(answerQuestionView, answerQuestionView.viewName);

            // This keeps track of and manages which view is currently showing.
            new ViewManager(views, cardLayout, viewManagerModel);
            application.setVisible(true);

            // PLACE ALL THE VIEWS THAT YOU WANT TO BYPASS WHEN TESTING HERE
            if (!TESTING) {

                // Display loading screen while the DAO uses the API to create a song database
                viewManagerModel.setActiveView(loadingScreenView.viewName);
                viewManagerModel.firePropertyChanged();

                fileSongsDAO.init();

                TimeUnit.SECONDS.sleep(2);

                viewManagerModel.setActiveView(logoScreenView.viewName);
                viewManagerModel.firePropertyChanged();

                TimeUnit.SECONDS.sleep(2);

                viewManagerModel.setActiveView(mainMenuView.viewName);
                viewManagerModel.firePropertyChanged();

            } else {

                viewManagerModel.setActiveView(resultsView.viewName);
                viewManagerModel.firePropertyChanged();

            }



        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /** TESTING API AND ENTITIES **/

//        ApiHandlerClient api = new ApiHandlerClient(ID, SECRET);
//        api.authenticate();
//
//        try {
//
//            // should create a new database using the csv file "topSongs.csv"
//            FileSongsDataAccessObject dao = new FileSongsDataAccessObject("topSongs.csv", new SpotifyApiSongFactory(api));
//
//            // dao.songlist should only have 10 songs in it
//            System.out.println("Number of songs in database: " + Integer.toString(dao.getSongListSize()));
//
//            // get 4 random songs from db, so we can create a quiz with 2 questions
//            ArrayList<Song> randomSongs = dao.getRandomSongs(4);
//
//            // TODO: ensure that these songs do not have equal popularity
//            Question q1 = new Question(randomSongs.get(0), randomSongs.get(1));
//            Question q2 = new Question(randomSongs.get(2), randomSongs.get(3));
//
//            Quiz testQuiz = new Quiz();
//            testQuiz.addQuestion(q1);
//            testQuiz.addQuestion(q2);
//
//            for (Question q : testQuiz.getQuestions()) {
//                System.out.println("Which is more popular: ");
//                System.out.println("\t" + q.getSong1().getTitle() + " or " + q.getSong2().getTitle());
//                System.out.println("\t" + q.getSong1().getTitle() + ": " + (q.getSong1().getPopularity()));
//                System.out.println("\t" + q.getSong2().getTitle() + ": " + (q.getSong2().getPopularity()));
//                System.out.println("\tThe correct answer is: " + q.getAnswer().getTitle());
//                System.out.println("\tPoints awarded: " + q.getPointsAwarded());
//            }
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

    }
}
