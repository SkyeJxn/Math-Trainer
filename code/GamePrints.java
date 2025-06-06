package code;
import java.util.Random;

/**
 * Support class for prints in the game.
 * @author SkyeJxn
 * @version 1.0
 */
public class GamePrints{
    private static final Random rand = new Random();


    private static final String[] Compliments = {
        "Great job! Keep it up!",
        "You're doing awesome!",
        "Fantastic work!",
        "Keep pushing, you're getting better!",
        "Well done! Stay focused!",
        "Excellent effort!",
        "You nailed it!",
        "Keep going, success is near!",
        "Impressive! Keep practicing!",
        "You're on fire!"
    };

    private static final String[] Encouragements = {
    "Don't give up! Try the next one!",
    "Almost had it! Keep going!",
    "Mistakes are proof you're trying!",
    "Keep practicing, you'll get better!",
    "Stay positive! You're learning!",
    "Every error is a step forward!",
    "Don't worry, you'll nail the next one!",
    "Keep your head up! You got this!",
    "Learning takes time, keep at it!",
    "Failure is just feedback!"
};

    /**
     * Prints strings with a box of '#' around it.
     * @param title string to print in a box.
     */
    public static void printBox(String title){
        int width = title.length() + 2;
        String ln = System.lineSeparator();
        String border = "#".repeat(width);

        System.out.println(ln + border);
        System.out.println("#" + title + "#");
        System.out.println(border + ln);
    }

    /**
     * Returns a random, motivating string from a given list.
     */
    public static String Motivator(){
        int index = rand.nextInt(Compliments.length);
        return Compliments[index];
    }

    /**
     * Returns a random, encouraging string from a given list.
     */
    public static String Encourager(){
    int index = rand.nextInt(Encouragements.length);
    return Encouragements[index];
	}
}
