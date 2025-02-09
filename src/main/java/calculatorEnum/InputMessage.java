package calculatorEnum;

public enum InputMessage {

    SelectCalculator("원하는 계산기를 입력하세요(일반계산기, 공학용계산기 둘 중 하나를 입력하세요): "),
    SelectMethodNormal("""
            어떤 연산을 하고 싶습니까?
            가능한 연산
            * 더하기
            * 빼기
            * 곱하기
            * 나누기"""),
    SelectMethodScientific("""
            어떤 연산을 하고 싶습니까?
            가능한 연산
            * 더하기
            * 빼기
            * 곱하기
            * 나누기
            * 사인(입력단위 : degree)
            * 코사인(입력단위 : degree)
            * 탄젠트(입력단위 : degree)"""),
    SelectOneNumber("정수를 한 개 입력하세요 : "),
    SelectTwoNumberFirst("첫번째 정수를 입력하세요 : "),
    SelectTwoNumberSecond("두번째 정수를 입력하세요 : ");

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
