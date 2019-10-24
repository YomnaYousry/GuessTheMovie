import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {


    private ArrayList<String> moviesList = new ArrayList<String>();

    public Game() {

        File file = new File("MoviesList.txt");

        try {

            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {

                moviesList.add(fileScanner.nextLine());
                //System.out.println(MoviesList);


            }

        } catch (FileNotFoundException e) {
            System.out.println("File does not exist");
        }
    }

    public Movie getRandomMovie() {
        int index = new java.util.Random().nextInt(moviesList.size());
        String chosenMovieTitle = moviesList.get(index);
        Movie chosenMovie = new Movie(chosenMovieTitle);
        System.out.println(chosenMovie.getTitle());
        return chosenMovie;

    }

    public char getUserInput() {
        Scanner scanner = new Scanner(System.in);
        char GuessedLetter = scanner.next().charAt(0);
        return GuessedLetter;


    }

    public boolean ValidateUserInput(char userInput) {

        if (Character.isLetter(userInput)) {
            return true;
        } else {
            return false;
        }
    }

    public void start() {

        System.out.println("Welcome to Guess The Movie Game!");
        System.out.println("Let's Start");
        Movie movie = getRandomMovie();
        System.out.println("The Movie Title has " + movie.getTitle().length() + " characters ");
        //   String hiddenTitle=movie.getHiddenTitle();
        System.out.println("The Movie is " + movie.getHiddenTitle());

        System.out.println("Start Guessing");

        User user = new User();
        user.setTrials(10);
        while (user.getTrials() > 0) {
            char guessedLetter = getUserInput();
            while (!ValidateUserInput(guessedLetter)) {
                System.out.println("Please Enter a Valid Letter ");
                guessedLetter = getUserInput();
            }
            if (movie.titleContainsLetter(guessedLetter)) {
                System.out.println("Correct");
                movie.replaceHiddenCharacters(guessedLetter);


            } else {
                System.out.println("False");
                user.setTrials(user.getTrials() - 1);
                System.out.println(user.getTrials());

            }

        }

    }


}











