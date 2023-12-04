package use_case.take_quiz;

public class TakeQuizInteractor implements TakeQuizInputBoundary{

    final TakeQuizOutputBoundary takeQuizPresenter;
    final TakeQuizDataAccessInterface takeQuizDataAccessObject;

    public TakeQuizInteractor(TakeQuizOutputBoundary takeQuizPresenter,
                              TakeQuizDataAccessInterface takeQuizDataAccessObject) {
        this.takeQuizPresenter = takeQuizPresenter;
        this.takeQuizDataAccessObject = takeQuizDataAccessObject;
    }

    @Override
    public void execute(TakeQuizInputData inputData) {
        if (takeQuizDataAccessObject.getNumSongs() == 0) {
            takeQuizPresenter.prepareFailView("No songs in database.");
        } else if (inputData.getNumQuestions() > takeQuizDataAccessObject.getNumSongs()) {
            takeQuizPresenter.prepareFailView("Not enough songs in database.");
        } else {

            //TakeQuizOutputData outputData = new TakeQuizOutputData();
            // chose an appropriate amount of songs
            //takeQuizPresenter.prepareSuccessView();
        }
    }
    public void execute() {
        // STEP 0: Creating an ApiHandlerClient object to use to make SongFactory
        ApiHandlerClient apiHandlerClient = new ApiHandlerClient("994142c178534fd69a48aad3e8fd54ba",
                "1854b844f8634b759a5b0ed4918cb016");

        // STEP 1: Create a SongFactory object to use to make DAO
        // IMPORTANT NOTE: FIX THIS!!
        SpotifyApiSongFactory songFactory = new SpotifyApiSongFactory(apiHandlerClient); // FIX!!!

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // STEP 2: Use DAO to create masterlist of Songs from DAO
        QuizDataAccessObject quizDao = new QuizDataAccessObject(songFactory);

        // IMPORTANT NOTE: below code "try/catch", etc. is to handle the case where Quiz.readcsv throws an exception
            try {
                quizDao.readCSV();  // Setting quizDao.songlist attribute to be the masterlist
            } catch (IOException e) {
                System.out.println(e.getMessage());
        }// Setting quiz's songlist attribute using csv
        ArrayList<Song> masterlist = quizDao.getSongList();

        //////////////////////////////////////////////////////////////////////////////////////////////////////////

        // STEP 3: Create Quiz Object
        Quiz quiz = new Quiz(50); // PLACEHOLDER INT FOR NOW
        // IMPORTANT NOTE: Below quiz.setNumQuestions method doesn't work unless...
        // you put {} around it, it's because it returns void.
        // Find a way to set limit of input to be <= 50.


        /////////////////////////////////////////////////////////////////////////////////////////////////////////

        // STEP 4: Helper method for GENERATING 2 RANDOM SONGS FROM MASTERLIST
        // See above method

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // STEP 5: Generate all questions and store in Quiz.questions attribute
        int i = 0;
        ArrayList<Question> questionList = new ArrayList<Question>();
        // Loop through as many times as num_questions
            while (i <= quiz.getNumQuestions()) {
                // Create a Question object, answer, pointsAwarded, and song1 and song2 are set
                Question question = new Question(this.generate2RandomSongs(masterlist));
                // Adding Question object to ArrayList
                questionList.add(question);
                i++;
            }
            // Storing list of ALL QUESTIONS in Quiz object
            quiz.setQuestions(questionList);
        }

        /////////////////////////////////////////////////////////////////////////////////////////////////////////

        // STEP 6: CONTINUE...
    }
