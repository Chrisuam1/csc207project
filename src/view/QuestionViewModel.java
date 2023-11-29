package src.view;

import java.awt.image.BufferedImage;

public class QuestionViewModel extends ViewModel {
    private String questionNumber;
    private String totalQuestions;
    private String currentPoints;
    private BufferedImage cover1;
    private BufferedImage cover2;
    private String songName1;
    private String songName2;
    private String albumName1;
    private String albumName2;
    private String artistName1;
    private String artistName2;

    public QuestionViewModel(String viewName) {
        super(viewName);
    }

    @Override
    public void propertyChanged() {

    }

    public String getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(String questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(String totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public String getCurrentPoints() {
        return currentPoints;
    }

    public void setCurrentPoints(String currentPoints) {
        this.currentPoints = currentPoints;
    }

    public BufferedImage getCover1() {
        return cover1;
    }

    public void setCover1(BufferedImage cover1) {
        this.cover1 = cover1;
    }

    public BufferedImage getCover2() {
        return cover2;
    }

    public void setCover2(BufferedImage cover2) {
        this.cover2 = cover2;
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
}
