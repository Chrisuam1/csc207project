package interface_adapter.answer_question;

import entities.QuizTaker;

import java.awt.image.BufferedImage;

public class AnswerQuestionState {

    private String questionNumber = "";
    private String score = "";
    private String songName1 = "";
    private String songName2 = "";
    private String artistName1 = "";
    private String artistName2 = "";
    private String albumName1 = "";
    private String albumName2 = "";
    private BufferedImage coverImage1 = null;
    private BufferedImage coverImage2 = null;

    public AnswerQuestionState() {}

    // Updates state depending on the current question of the QuizTaker.
    // DOES NOT UPDATE SCORE
    public void setQuizTaker(QuizTaker quiz) {
        this.setQuestionNumber(Integer.toString(quiz.getCurrentQuestionNumber()));
        this.setSongName1(quiz.getCurrentQuestion().getSong1().getTitle());
        this.setSongName2(quiz.getCurrentQuestion().getSong2().getTitle());
        this.setAlbumName1(quiz.getCurrentQuestion().getSong1().getAlbum().getTitle());
        this.setAlbumName2(quiz.getCurrentQuestion().getSong2().getAlbum().getTitle());
        this.setArtistName1(quiz.getCurrentQuestion().getSong1().getArtists().get(0));
        this.setArtistName2(quiz.getCurrentQuestion().getSong2().getArtists().get(0));
        this.setCoverImage1(quiz.getCurrentQuestion().getSong1().getAlbum().getCoverImages().get(0));
        this.setCoverImage2(quiz.getCurrentQuestion().getSong2().getAlbum().getCoverImages().get(0));

    }

    public String getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(String questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getSongName1() {
        return songName1;
    }

    public void setSongName1(String songName1) {
        this.songName1 = songName1;
    }

    public String getSongName2() {
        return songName2;
    }

    public void setSongName2(String songName2) {
        this.songName2 = songName2;
    }

    public String getArtistName1() {
        return artistName1;
    }

    public void setArtistName1(String artistName1) {
        this.artistName1 = artistName1;
    }

    public String getArtistName2() {
        return artistName2;
    }

    public void setArtistName2(String artistName2) {
        this.artistName2 = artistName2;
    }

    public String getAlbumName1() {
        return albumName1;
    }

    public void setAlbumName1(String albumName1) {
        this.albumName1 = albumName1;
    }

    public String getAlbumName2() {
        return albumName2;
    }

    public void setAlbumName2(String albumName2) {
        this.albumName2 = albumName2;
    }

    public BufferedImage getCoverImage1() {
        return coverImage1;
    }

    public void setCoverImage1(BufferedImage coverImage1) {
        this.coverImage1 = coverImage1;
    }

    public BufferedImage getCoverImage2() {
        return coverImage2;
    }

    public void setCoverImage2(BufferedImage coverImage2) {
        this.coverImage2 = coverImage2;
    }
}
