package app;

import interface_adapter.ViewManagerModel;
import view.LoadingScreenView;
import view.LogoScreenView;
import view.MainMenuView;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        //Test environment variables
        String ID = System.getenv("ID");
        String SECRET = System.getenv("SECRET");
        System.out.println("ID=" + ID + "; SECRET=" + SECRET);

        // Build the main program window, the main panel containing the
        // various cards, and the layout, and stitch them together.

        // The main application window.
        JFrame application = new JFrame("Spotify Quiz");
        application.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        //application.setSize(1000, 800);

        application.setExtendedState(JFrame.MAXIMIZED_BOTH);
        application.setUndecorated(true);
        //device.setFullScreenWindow(application);

        CardLayout cardLayout = new CardLayout();

        // The various View objects. Only one view is visible at a time.
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        LoadingScreenView loadingScreenView = new LoadingScreenView();
        views.add(loadingScreenView, loadingScreenView.viewName);

        LogoScreenView logoScreenView = new LogoScreenView();
        views.add(logoScreenView, logoScreenView.viewName);

        MainMenuView mainMenuView = new MainMenuView();
        views.add(mainMenuView, mainMenuView.viewName);


        // This keeps track of and manages which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);


        /** CHANGE setActiveView argument to test different views **/


        viewManagerModel.setActiveView(mainMenuView.viewName);
        viewManagerModel.firePropertyChanged();

        application.setVisible(true);
//
//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//
//        viewManagerModel.setActiveView(logoScreenView.viewName);
//        viewManagerModel.firePropertyChanged();
//
//        application.setVisible(true);
//
//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//
//        viewManagerModel.setActiveView(loadingScreenView.viewName);
//        viewManagerModel.firePropertyChanged();
//
//        application.setVisible(true);

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
