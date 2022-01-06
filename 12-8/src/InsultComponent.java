import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InsultComponent {

    private static List<String> insult;
    static {
        insult = new ArrayList<>();
        insult.add("insult1");
        insult.add("insult2");
        insult.add("insult3");
        insult.add("insult4");
        insult.add("insult5");
    }

    public static String getRandomInsult(){
        Random random = new Random();
        int i = random.nextInt(insult.size());

        return insult.get(i);
    }

}
