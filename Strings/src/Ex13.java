import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by belows on 2016/11/5.
 */
public class Ex13 {
    static class StartEnd {
        static public final String POEM =
                "Twas brillig, and the slithy toves\n" +
                        "Did gyre and gimble in the wabe.\n" +
                        "All mimsy were the borogoves,\n" +
                        "And the mome raths outgrabe.\n\n" +
                        "Beware the Jabberwock, my son,\n" +
                        "The jaws that bite, the claws that catch.\n" +
                        "Beware the Jubjub bird, and shun\n" +
                        "The frumious Bandersnatch.";

        public static String input =
                "As long as there is injustice, whenever a\n" +
                        "Targathian baby cries out, wherever a distress\n" +
                        "signal sounds among the stars ... We’ll be there.\n" +
                        "This fine ship, and this fine crew ...\n" +
                        "Never give up! Never surrender!";
        private static class Display {
            private boolean regexPrinted = false;
            private String regex;
            Display(String regex) { this.regex = regex; }
            void display(String message) {
                if(!regexPrinted) {
                    System.out.println(regex);
                    regexPrinted = true;
                }
                System.out.println(message);
            }
        }
        static void examine(String s, String regex) {
            Display d = new Display(regex);
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(s);
            while(m.find())
                d.display("find() ‘" + m.group() +
                        "‘ start = "+ m.start() + " end = " + m.end());
            if(m.lookingAt()) // No reset() necessary
                d.display("lookingAt() start = "
                        + m.start() + " end = " + m.end());
            if(m.matches()) // No reset() necessary
                d.display("matches() start = "
                        + m.start() + " end = " + m.end());
        }
        public static void main(String[] args) {
            for(String in : POEM.split("\n")) {
                System.out.println("input : " + in);
                for(String regex : new String[]{"\\w*ere\\w*",
                        "\\w*ever", "T\\w+", "Never.*?!"})
                    examine(in, regex);
            }
        }
    }


    public static void main(String[] args) {
        StartEnd.main(args);
    }
}
