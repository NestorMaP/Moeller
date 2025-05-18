import utils.Calculator;

public class Main {
    public static void main(String[] args) {

        int ATOMIC_NUMBER = 35;

        Calculator calculator = new Calculator();

        calculator.print(calculator.calculate(ATOMIC_NUMBER));

    }
}