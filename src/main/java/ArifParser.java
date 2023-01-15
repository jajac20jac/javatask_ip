
import java.util.Stack;





public class ArifParser {
    private static String expression;

    public ArifParser(String exp) {
        expression = exp;
    }

    public static int GetPriority(char token) {
        if (token == '*' || token == '/') return 3;
        else if (token == '+' || token == '-') return 2;
        else if (token == ')') return -1;
        else if (token == '(') return 1;
        else return 0;
    }

    public static java.lang.Double ArifParserToAnswer() throws java.io.IOException {
        String ArifParser = ExpressionToArifParser();
        String operand = new String();
        Stack<Double> stack_ = new Stack<Double>();
        for (int i = 0 ;i < ArifParser.length(); i++) {

            if (ArifParser.charAt(i) == ' ') {
                continue;
            }
            if (GetPriority(ArifParser.charAt(i)) == 0) {
                while (ArifParser.charAt(i) != ' ' && GetPriority(ArifParser.charAt(i)) == 0) {
                    operand += ArifParser.charAt(i++);
                    if (i == ArifParser.length()) {
                        i--;
                        break;
                    }
                }
                stack_.push(Double.parseDouble(operand));
                operand = new String();
            }
            if (GetPriority(ArifParser.charAt(i)) > 1) {
                double a = stack_.pop();
                double b = stack_.pop();
                if (ArifParser.charAt(i) == '+') stack_.push( b + a);
                if (ArifParser.charAt(i) == '-') stack_.push(b - a);
                if (ArifParser.charAt(i) == '*') stack_.push(b * a);
                if (ArifParser.charAt(i) == '/') stack_.push(b / a);
            }
        }
        return stack_.pop();
    }
    public static java.lang.String ExpressionToArifParser() throws java.io.IOException {
        String expr = expression;
        String current = "";
        Stack<Character> stack = new Stack<Character>();

        int priority;
        for (int i = 0; i < expr.length(); i++) {
            priority = GetPriority(expr.charAt(i));
            if (priority == 0) {
                current += expr.charAt(i);
            }
            else if (priority == 1) {
                stack.push(expr.charAt(i));
            }
            else if (priority == -1) {
                current += " ";
                while (GetPriority(stack.peek()) != 1) {
                    current += stack.pop();
                }
                stack.pop();
            }
            else {
                current += " ";
                while(!stack.empty()) {
                    if (GetPriority(stack.peek()) >= priority) {
                        current += stack.pop();
                    } else {
                        break;
                    }
                }
                stack.push(expr.charAt(i));
            }

        }

        while (!stack.empty()) {
            current += stack.pop();
        }

        return current;
    }
}