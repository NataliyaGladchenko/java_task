package by.gsu.pms;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Ideone {
    public static Double calc(List<String> postfix) {
        Deque<Double> stack = new ArrayDeque<>();
        for (String x : postfix) {
            if (x.equals("+")) stack.push(stack.pop() + stack.pop());
            else if (x.equals("-")) {
                Double b = stack.pop(), a = stack.pop();
                stack.push(a - b);
            }
            else if (x.equals("*")) stack.push(stack.pop() * stack.pop());
            else if (x.equals("/")) {
                Double b = stack.pop(), a = stack.pop();
                stack.push(a / b);
            }
            else stack.push(Double.valueOf(x));
        }
        return stack.pop();
    }


}