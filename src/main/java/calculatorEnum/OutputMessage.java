package calculatorEnum;

public enum OutputMessage {
    returnAnswer("계산된 결과입니다. : ");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
