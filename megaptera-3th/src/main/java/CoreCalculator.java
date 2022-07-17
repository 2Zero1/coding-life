public class CoreCalculator {
  public static final String[] OPERATORS = new String[]{"+", "-", "*", "/", "="};

  private long accumulator = 0;
  private long currentNumber = 0;
  private String currentOperator = "";

  public String getCurrentNumber() {
    return Long.toString(currentNumber);
  }

  public String getAccumulator() {
    return Long.toString(accumulator);
  }

  public void addNumber(String number) {
    currentNumber *= 10;
    currentNumber += Integer.valueOf(number);
  }

  public void updateOperator(String operator) {
    currentOperator = operator;
  }

  public void calculate() {
    switch (currentOperator) {
      case "" -> accumulator = currentNumber;
      case "+" -> accumulator += currentNumber;
      case "-" -> accumulator -= currentNumber;
      case "*" -> accumulator *= currentNumber;
      case "/" -> accumulator /= currentNumber;
    }
    currentNumber = 0;
  }
}
