package org.example.lv3;


// 트러블슈팅 - 연산자 기호만으로 쓸 수 없다.
// 알파벳, 숫자, 언더스코어(_) 등으로 구성된 변수 이름만 올 수 있다. 상수.
//public enum OperatorType {
//    +, -, *, /
//}
// public으로 쓰려면 별도로 파일 만들어야 에러 안남
// public 안쓸거면 Calculator에서도 사용 가능하다.
// .java 파일에 public 타입은 하나만 가능하고, 파일명과 이름이 일치해야 하기 때문
public enum OperatorType {
    PLUS('+'), MINUS('-'), MULTIPLY('*'), DIVIDE('/');

    private final char operator;

    OperatorType(char operator) {
        this.operator = operator;
    }
    public char getOperator() {
        return operator;
    }
}
