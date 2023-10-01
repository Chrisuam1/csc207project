# CSC 207 Design Project

The problem domain our team is working on is a trivia game, the specific genre of trivia being music.
Our application would use an API to fetch song lyrics out of a list of songs, and have the user guess
which song those lyrics belongs to.

We are currently considering two methods for deciding which songs would be in the quiz.
One idea was the use the Spotify API, which accesses the user's Spotify account to get all the songs out of a specific 
playlist that the user has created. 
The other idea was to simply use a list of various popular songs curated either by us, or through a database.

Other features we were thinking of adding:
* Difficulty settings that would change how many lyrics are shown for each song
* Guessing the artist in addition to the song name
* Sorting by song genre

Lyric API:
https://lyricsovh.docs.apiary.io/#

Spotify API:
https://developer.spotify.com/documentation/web-api

Screenshot of Calling the API:


Example Output of Running the Java Code:

    {
    "error": "No lyrics found"
    }

Technical Issues: 
 * The Spotify API is written in JavaScript
 * Lyric API is far too simple; only had 1 get method