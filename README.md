# 2-gray-chang-thread-week2

## 회고
### 1. 1주차 과제 리팩토링
- 1주차 과제에 대한 후회부터 시작한 것 같다. 나름 객체화를 잘 시켰다고 생각했는데 다시 확인해보니 단순히 메서드 분리였을 뿐이고, 파라미터를 받아서 재사용할 수 있게 메서드를 구현해야 하는데 파이썬으로 실험하듯이 절차식으로만 구현했다.
- 그래서 2주차의 절반 이상을 1주차 과제 리팩토링에 집중한 것 같다.(사실 많이 하지는 못했다..)
    - 주로 손댄 곳은 InputView 클래스이다. 먼저 한 연산 사이클이 끝나면 다시 연산을 할 것인지 물어보는 로직을 추가했다.
    - 또한 기존에 메서드 내에서 새로 생성하던 객체들을 파라미터로 받는 방식으로 수정했다.
    - Controller에도 연산을 반복할지 묻는 메서드를 적용했다.
- 내 코드의 고질적인 문제는 InputView가 너무 많은 연산을 담당한다는 것이다.
    - 원래 의도는 Input으로 값을 받으면 이걸 간단하게 객체화해서 컨트롤러로 옮기는 것을 원했는데, 여기서 문제가 발생했다.
    - Input에서 객체화를 시키려니까 검증도 해야하고, 객체로 감싸서 리턴도 해야하고, 본디 업무에 비해 많은 임무를 담당하게 되었다.
    - DTO를 적용해보려고 했으나 제출일이 촉박하여 여기까지 리팩토링을 하지는 못했다.
        - 1주차에 DTO에 대해 질문한 적이 있었는데, '사용 이유에 대해 알아도 잘 체감이 안될것이다'라는 답변을 받은 바가 있다.
        - 아..이래서 DTO를 사용하나?라는 생각이 들었다. 과제 제출 후에 혹시 리팩토링이 가능하다면 DTO를 사용해서 객체를 전달하는 것을 해봐야겠다.

### 2. 스레드에 대한 고민
- 스레드에 대한 이론적인 공부 후 실제로 적용하려니 더욱 막막했다. 계산기에 어떻게 스레드를 적용하지? 싶었다.
- 팀원들에게 상담받은 결과 계산기에 넣을만한 가장 적합한 스레드는 음악 재생이라는 결과를 얻었다.
    - 식상하지만, 사실 CLI 프로그램에서 스레드라는 것을 체감할 수 있는 가장 좋은 예제라는 생각이 들었다.
    - 추가로 현재 시간을 알려주는 스레드도 구현하였지만 적용하지는 않았다.
    - 터미널로는 이전에 구현한 계산기 로직이 돌아가고, 이와 동시에 음악을 재생하는 스트리밍 과정
- 음악 재생을 위해 간단한 스레드를 구현하였고, (물론 음악이 나오지만) 스레드의 시작을 알리기 위한 문구를 추가했다.
  - 사실 스레드가 하나인 상황이고 반복적으로 실행되는 상황도 아니어서 적당한 객체를 만들어 노래를 재생해도 되지만, 공부한걸 써먹기 위해 Thread-safe한 스레드 객체를 구현하려고 했다.
    - 스레드 안전하게 설계하기 위한 방법 중 하나는 객체를 싱글톤 패턴으로 구현하는 방법이다.(다른 방법 : concurrent 라이브러리 사용, 동기화 블럭에서 연산 수행, 인스턴스 변수 두지 않는 법 등)
    - 일반 싱글톤 패턴은 ```getInstance()```를 위해 인스턴스가 있는지 검증하는 로직을 시행하다가 동시성 이슈가 발생할 수 있다.
    - 이를 대비하기 위한 싱글톤 방식에는 Synchronized 메서드 선언, DCL방식(인스턴스 생성 로직에만 synchronized 키워드로 락을 걸음), volatile, enum 클래스, 그리고 Bill Pugh Singleton 방식이 있다.
    - 이번 실습에서 사용한 패턴은 Bill Pugh 패턴으로, enum 클래스 사용과 동시에 권장되는 방식이다.
      - 홀더 역할을 하는 private static class를 inner class로 만들어 메서드 영역으로 할당시키고 내부의 인스턴스 영역도 final 키워드로 불변성을 보장하는 방식이다.

### 3. 1~2주 종합회고
- 스레드에 대한 이론공부에 비해 '그래서 어떻게 써먹는데?'라는 질문에는 쉽게 대답하지 못함을 깨닫는 과제였다.
- 아무래도 구현하는 코딩에 대한 경험부족이 큰 것 같다. 이제 많이 경험하면서 역량을 키워나가야 겠다.
- 클린코드에 대한 생각을 많이 하게 되었다. 객체지향적인 코드에 대한 생각을 하면서 구현했지만, 정작 이 코드를 읽었을 때 깨끗해보이지는 않는다. 좀 공부해봐야겠다.