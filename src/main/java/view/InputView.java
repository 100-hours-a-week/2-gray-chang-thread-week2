package view;

import calculatorEnum.CalculatorEnum;
import calculatorEnum.InputMessage;
import calculatorEnum.MethodName;
import calculatorEnum.WarningMessage;
import calculatorService.MethodNameMapper;
import orderObject.Order;
import java.util.Scanner;

public class InputView {

    public Order getCalcInput(){
        Scanner scanner = new Scanner(System.in);

        CalculatorEnum calcType = getCalculator(scanner);

        MethodName methodName = matchMethodName(calcType, scanner);

        return createOrder(methodName, scanner, calcType);
    }

    private Order createOrder(MethodName methodName, Scanner scanner, CalculatorEnum calcType) {
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

    private String getMethodNameInput(CalculatorEnum calcType, Scanner scanner) {
        if (calcType.equals(CalculatorEnum.Normal_calculator)){
            System.out.println(InputMessage.SelectMethodNormal.getMessage());
        } else if (calcType.equals(CalculatorEnum.Scientific_calculator)){
            System.out.println(InputMessage.SelectMethodScientific.getMessage());
        }
        return scanner.nextLine().trim();
    }

    private CalculatorEnum getCalculator(Scanner scanner) {
        while (true){
            System.out.print(InputMessage.SelectCalculator.getMessage());
            String calcTypeInput = scanner.nextLine().trim();

            CalculatorEnum calcType = parseCalculatorType(calcTypeInput);
            if (calcType != null){
                return calcType;
            }
            System.out.println(WarningMessage.CalculatorTypeWarning.getMessage());
        }
    }

    private CalculatorEnum parseCalculatorType(String input) {
        if ("일반계산기".equals(input)) {
            return CalculatorEnum.Normal_calculator;
        } else if ("공학용계산기".equals(input)) {
            return CalculatorEnum.Scientific_calculator;
        }
        return null;
    }

    private MethodName matchMethodName(CalculatorEnum calcType, Scanner scanner) {
        while (true) {
            String input = getMethodNameInput(calcType, scanner);
            MethodName methodName = MethodNameMapper.getMethodName(input);
            if (calcType.equals(CalculatorEnum.Normal_calculator) &&
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
}
