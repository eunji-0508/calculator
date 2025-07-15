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

    // enum은 이미 객체를 가지고 있음
    // enum TestEnum {
    //    private char operator;
    //    public char getOperator() {
    //        return this.operator;
    //    }
    //    public TestEnum(char operator) {
    //
    //    }
    //    TEST1('+'), TEST2('-')
    //}
    //TestEnum.TEST1.getOperator();

    /// / 타입       //변수   // 값
    //TestClass clazz = new TestClass();
    //int        i    =  0;
    //TestEnum test1 = TestEnum.TEST1;
    //test1.getOperator();
    //
    //clazz.getValue();
    //TestClass.getValue2();
    //
    //TestClass {
    //    public void getValue() {
    //
    //    }
    //
    //    static void getValue2() {
    //
    //    }
    //}


    // static 안쓰고는 구현할 방법이 없는 거 같은데..
    // values() - enum 자체 메서드. 모든 enum 상수들을 배열로 반환
//    public static OperatorType changeType(char operator) {
//        for (OperatorType operatorType : OperatorType.values()) {
//            if (operatorType.getOperator() == operator) {
//                return operatorType;
//            }
//        }
//        throw new IllegalArgumentException("잘못된 연산 기호입니다.");
//    }
}
