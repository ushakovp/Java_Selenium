import java.util.Arrays;
import java.util.List;

public class Collections {

    public static void main(String[] args) {
        String[] langs = new String[4];
        langs[0] = "Java";
        langs[1] = "C#";
        langs[2] = "Python";
        langs[3] = "JavaScript";

        for (int i = 0; i < langs.length; i++) {
            System.out.println(langs[i]);
        }

        List<String> languages = Arrays.asList("Java", "C#", "Python", "JavaScript");

        for (String l : languages) {
            System.out.println(l);
        }
    }
}
