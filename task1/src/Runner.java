import by.gsu.pms.ExpressionParser;
import by.gsu.pms.Ideone;

import java.util.List;

public class Runner {

    public static void main(String[] args) {
        String str = "1.56 + 2 / 3.24 + 4 * 3.2";
        ExpressionParser n = new ExpressionParser();
        List<String> expression = n.parse(str);
        boolean flag = n.flag;
        if (flag) {
            for (String x : expression) System.out.print(x + " ");
            System.out.println();
            System.out.println(Ideone.calc(expression));
        }

    }
}