import java.util.Arrays;
import java.util.List;

public class ExpressionParser {

    public static List<String> parse(String expression){
        return Arrays.asList(expression.split(" "));
    }

}
