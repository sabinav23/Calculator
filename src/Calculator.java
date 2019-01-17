import java.util.List;

public class Calculator {
    
    private ElementsRepository elementsRepository;
    
    public Calculator(ElementsRepository elementsRepository){
        this.elementsRepository = elementsRepository;
    }
    
    public void buildElements(List<String> expressionElements){
        for (int i = 0; i < expressionElements.size(); i++) {
            try{
                this.elementsRepository.addNumber(Double.parseDouble(expressionElements.get(i)));
            }
            catch (NumberFormatException nfe){
                if(expressionElements.get(i).contains("+")) {
                    this.elementsRepository.addOperator(expressionElements.get(i));
                }
                else if (expressionElements.get(i).contains("-")) {
                    this.elementsRepository.addOperator(expressionElements.get(i));
                }
                else{
                    this.elementsRepository.addUnit(expressionElements.get(i));
                }
            }
        }
    }

    public double calculate(Boolean ascending){
        for(int i = 0; i < this.elementsRepository.getNumbers().size(); i++ ){
            String unit = this.elementsRepository.getUnits().get(i);
            int operatorPower;
            if (ascending) {
                operatorPower = ElementsRepository.SUPPORTED_OPERATORS.indexOf(unit);
            } else {
                operatorPower = ElementsRepository.REVERSED_SUPPORTED_OPERATORS.indexOf(unit);
            }

            this.elementsRepository.getNumbers().set(i, this.elementsRepository.getNumbers().get(i) * Math.pow(10,operatorPower));
        }

        double sum = this.elementsRepository.getNumbers().get(0);

        for(int i = 0; i < this.elementsRepository.getOperators().size(); i++){

            if(this.elementsRepository.getOperators().get(i).equals("+")){
                sum += this.elementsRepository.getNumbers().get(i + 1);
            }
            if(this.elementsRepository.getOperators().get(i).equals("-")){
                sum -= this.elementsRepository.getNumbers().get(i+1);
            }
        }
        return sum;
    }
}
