package org.example.lv3;

import java.util.ArrayList;
import java.util.List;

public class Calculator <T> {
    // 속성(필드)
    // 나중에 변환하게 되면 편하게 하기 위해 List로 작성함 (사실 지금은 상관없음)
    private List<Integer> resultsList = new ArrayList<>();

    // double 타입의 값을 전달 받아도 연산이 수행하도록 만들기 (제네릭)
    private T num1;
    private T num2;
    private OperatorType operator;
    private T result;

    // 생성자 - 기본 생성자 사용함

    // 기능
    // 사칙연산을 수행 후, 결과값 반환 메서드 구현
    public T calculate(T num1, T num2, OperatorType operator) {
        char op = operator.getOperator();

        try {
            switch (op) {
                case '+':
                    result = num1 + num2;
                    break;

                case '-':
                    result = num1 - num2;
                    break;

                case '*':
                    result = num1 * num2;
                    break;

                case '/':
                    if (num2 == 0) {
                        throw new ArithmeticException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    }
                    result = num1 / num2;
                    break;
            }
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage()); // 에러 메시지 출력 기능
        }
        resultsList.add(result);
        return result;
    }

    // Getter 메서드
    public T getResult() {
        System.out.println("계산 결과: " + result);
        return result;
    }

    // Setter 메서드
    public void setResult(T num1, T num2, OperatorType operator) {
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
    }
}
