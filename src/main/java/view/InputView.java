package view;

import calculatorEnum.CalculatorName;
import calculatorEnum.InputMessage;
import calculatorEnum.MethodName;
import calculatorEnum.WarningMessage;
import calculatorService.MethodNameMapper;
import orderObject.Order;
import java.util.Scanner;

public class InputView {

    public Order getCalcInput(){
        Scanner scanner = new Scanner(System.in);

        CalculatorName calcType = getCalculator(scanner);

        MethodName methodName = matchMethodName(calcType, scanner);

        return createOrder(methodName, scanner, calcType);
    }

    private Order createOrder(MethodName methodName, Scanner scanner, CalculatorName calcType) {
        if (isTriMethod(methodName)){
            System.out.print(InputMessage.SelectOneNumber.getMessage());
            int firstNum = parseInteger(scanner);
            return new Order(calcType, methodName, firstNum);
        } else {
            System.out.print(InputMessage.SelectTwoNumberFirst.getMessage());
            int firstNum = parseInteger(scanner);
            System.out.print(InputMessage.SelectTwoNumberSecond.getMessage());
            int secondNum = parseInteger(scanner);
            return new Order(calcType, methodName, firstNum, secondNum);
        }
    }


    private int parseInteger(Scanner scanner) {
        while(true){
            try{
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e){
                System.out.print(WarningMessage.IntegerTypeWarning.getMessage());
            }
        }
    }

    private String getMethodNameInput(CalculatorName calcType, Scanner scanner) {
        if (calcType.equals(CalculatorName.Normal_calculator)){
            System.out.println(InputMessage.SelectMethodNormal.getMessage());
        } else if (calcType.equals(CalculatorName.Scientific_calculator)){
            System.out.println(InputMessage.SelectMethodScientific.getMessage());
        }
        return scanner.nextLine().trim();
    }

    private CalculatorName getCalculator(Scanner scanner) {
        while (true){
            System.out.print(InputMessage.SelectCalculator.getMessage());
            String calcTypeInput = scanner.nextLine().trim();

            CalculatorName calcType = parseCalculatorType(calcTypeInput);
            if (calcType != null){
                return calcType;
            }
            System.out.println(WarningMessage.CalculatorTypeWarning.getMessage());
        }
    }

    private CalculatorName parseCalculatorType(String input) {
        if ("일반계산기".equals(input)) {
            return CalculatorName.Normal_calculator;
        } else if ("공학용계산기".equals(input)) {
            return CalculatorName.Scientific_calculator;
        }
        return null;
    }

    private MethodName matchMethodName(CalculatorName calcType, Scanner scanner) {
        while (true) {
            String input = getMethodNameInput(calcType, scanner);
            MethodName methodName = MethodNameMapper.getMethodName(input);
            if (calcType.equals(CalculatorName.Normal_calculator) &&
                    isTriMethod(methodName)) {
                System.out.println(WarningMessage.MethodTypeWarning.getMessage());
                continue;
            }
            if (methodName != null) {
                return methodName;
            }
            System.out.println(WarningMessage.MethodTypeWarning.getMessage());
        }
    }

    private boolean isTriMethod(MethodName methodName) {
        return methodName.equals(MethodName.sin) || methodName.equals(MethodName.cos) || methodName.equals(MethodName.tan);
    }

    public String wantToStop(){
        System.out.println(InputMessage.WantToStop.getMessage());
        while (true){
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine().trim();
            if (input.equals("Y") || input.equals("N")){
                return input;
            } else{
                System.out.println(WarningMessage.WantToStomWarning.getMessage());
                continue;
            }
        }

    }
}
