import java.util.*;

public class Main {

    public static void main(String[] args) {
        String expression = "50 cm + 10 m + 1 m + 1 m";

        boolean ascending = true;

        List<String> expressionElements = ExpressionParser.parse(expression);

        ElementsRepository elementsRepository = new ElementsRepository();

        Calculator calculator = new Calculator(elementsRepository);
        calculator.buildElements(expressionElements);
        System.out.println(calculator.calculate(ascending));
    }
}

