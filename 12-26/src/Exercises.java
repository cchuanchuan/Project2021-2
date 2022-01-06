import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Exercises {

    private final List<Equation> list;
    private final int max = 100;
    private int nowIndex = 0;

    public Exercises() {
        list = new ArrayList<>();
        // 默认生成100道题目
        addHundredEquation(100);
    }

    public void addHundredEquation(int num) {
        Random random = new Random();
        int count = 0;
        while (count < num) {
            int a = random.nextInt(max);
            int b = random.nextInt(max);
            boolean isAdd = random.nextBoolean();
            if (isAdd) {
                Equation equation = new Equation(a + " + " + b);
                if (equation.getResult() >= 0 && equation.getResult() <= max) {
                    list.add(equation);
                    count++;
                }
            } else {
                Equation equation = new Equation(a + " - " + b);
                if (equation.getResult() >= 0 && equation.getResult() <= max) {
                    list.add(equation);
                    count++;
                }
            }
        }
    }

    public Equation getEquation() {
        return list.size() > nowIndex ? list.get(nowIndex) : null;
    }

    public boolean nextEquation() {
        if (list.size() - 1 > nowIndex) {
            nowIndex++;
            return true;
        } else {
            return false;
        }
    }

    public Integer getResult() {
        return list.size() > nowIndex ? list.get(nowIndex).getResult() : null;
    }

    public boolean hasNext() {
        return list.size()-1 > nowIndex;
    }


}
