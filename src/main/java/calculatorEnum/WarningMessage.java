package calculatorEnum;

public enum WarningMessage {
    CalculatorTypeWarning("잘못된 입력입니다. 일반계산기 또는 공학용계산기를 입력하시기 바랍니다."),
    MethodTypeWarning("잘못된 입력입니다. 목록의 연산 이름을 정확하게 입력하세요.(예 : 더하기)"),
    IntegerTypeWarning("잘못된 입력입니다. 정수만 입력하세요.(예 : 1, 2) : ");

    private final String message;

    WarningMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }


}
