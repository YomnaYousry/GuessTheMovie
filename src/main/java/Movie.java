import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Movie {

    private String Title;

    public void setHiddenTitle(String hiddenTitle) {
        this.hiddenTitle = hiddenTitle;
    }

    private String hiddenTitle;

    public Movie(String title) {

        Title = title;
        hiddenTitle = replaceWithUnderscores();
    }

    private String replaceWithUnderscores() {
        hiddenTitle = Title.replaceAll("[A-Za-z]", " _ ");
        //System.out.println(ConvertedChosenMovie);
        return hiddenTitle;

    }

    public String getHiddenTitle() {

        return hiddenTitle;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getTitle() {
        return Title;
    }

    public boolean titleContainsLetter(char userInput) {
        if (getTitle().indexOf(userInput) >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public String replaceHiddenCharacters(char userInput) {
        System.out.println("hhhhhhhh");

        char[] hiddenTitlearray = hiddenTitle.toCharArray();
        for (int i = 0; i < this.Title.length(); i++) {
            if (this.Title.charAt(i) == userInput) {
                System.out.println("hena" + i);


                hiddenTitlearray[i] = userInput;


            }
        }

        hiddenTitle = hiddenTitlearray.toString();
        System.out.println(hiddenTitle);
        return hiddenTitle;
    }


}





