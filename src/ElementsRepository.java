import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ElementsRepository {

    public static final List<String> SUPPORTED_OPERATORS = Arrays.asList("mm", "cm", "dm", "m", "km");
    public static final List<String> REVERSED_SUPPORTED_OPERATORS = Arrays.asList("km", "m", "dm", "cm", "mm");

    private List<String> operators;
    private List<Double> numbers;
    private List<String> units;

    public ElementsRepository(){
        this.operators = new ArrayList<>();
        this.numbers = new ArrayList<>();
        this.units = new ArrayList<>();
    }

    public void addOperator(String operator){
        this.operators.add(operator);
    }

    public void addNumber(Double number){
        this.numbers.add(number);
    }

    public void addUnit(String unit){
        this.units.add(unit);
    }

    public List<String> getOperators() {
        return operators;
    }

    public List<Double> getNumbers() {
        return numbers;
    }

    public List<String> getUnits() {
        return units;
    }
}
