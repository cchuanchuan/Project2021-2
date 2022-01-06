import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TestCase {

    @Test
    public void testExercise(){
        Exercises exercises = new Exercises();
        Assertions.assertEquals(exercises.getEquation().getResult(),exercises.getResult());
        Assertions.assertEquals(exercises.nextEquation(),Boolean.TRUE);
    }

    @Test
    public void testAdd(){
        AddMethod addMethod = new AddMethod(20,10);
        Assertions.assertEquals(addMethod.execute(),30);
    }

    @Test
    public void testSub(){
        SubMethod subMethod = new SubMethod(20,10);
        Assertions.assertEquals(subMethod.execute(),10);
    }

    @Test
    public void testEquation(){
        Equation equation = new Equation("10 + 20");
        Assertions.assertEquals(equation.getResult(),30);
        Equation equation1 = new Equation("20 - 10");
        Assertions.assertEquals(equation1.getResult(),10);
    }



}
