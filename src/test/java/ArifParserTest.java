import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArifParserTest {

    @Test
    public void divideByZero() throws Exception {
        String expression = "1/0";
        Double result = 0.0;
        ArifParser ap = new ArifParser(expression);
        Assertions.assertThrows(ArithmeticException.class, () -> ap.ArifParserToAnswer());
    }

    @Test
    void SimpleMath() throws Exception{
        String expression = "5+2/2+5";
        Double result = 11.0;
        ArifParser ap = new ArifParser(expression);
        Double answer = ap.ArifParserToAnswer();
        Assertions.assertEquals(result, answer);
    }
}