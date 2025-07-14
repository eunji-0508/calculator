package org.example.lv3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// 트러블슈팅: 숫자만 입력 받아야한다.
// doubleValue() 사용하려면 Number 상속받아야 함 (Number의 메서드)
public class Calculator <T extends Number> {
    // 속성(필드)
    private List<Double> resultsList = new ArrayList<>();

    // double 타입의 값을 전달 받아도 연산이 수행하도록 만들기 (제네릭)
    // 피연산자를 여러 타입으로 받을 수 있도록 기능을 확장
    private T num1;
    private T num2;
    private OperatorType operator;

    // 트러블슈팅: T로 받으면 연산 못함
    // double형으로 받아주자
    private double result;

    // 생성자 - 기본 생성자 사용함

    // 기능
    // 사칙연산을 수행 후, 결과값 반환 메서드 구현
    public double calculate() {
        // 연산자 부호 사용하고 싶어서 넣은 객체
        char op = operator.getOperator();

        // 트러블슈팅: 제네릭 타입은 연산 못함
        // T 타입 숫자를 double로 통일 후 연산을 수행
        // 아.. 근데 이러면 메서드에서 피연산자를 여러 타입으로 받을 수 있도록 기능을 확장 조건에 안맞는데..?
        double dnum1 = num1.doubleValue();
        double dnum2 = num2.doubleValue();

        // 트러블슈팅: 제네릭 타입은 연산 못함
        try {
            switch (op) {
                case '+':
                    result = dnum1 + dnum2;
                    break;

                case '-':
                    result = dnum1 - dnum2;
                    break;

                case '*':
                    result = dnum1 * dnum2;
                    break;

                case '/':
                    if (dnum2 == 0) {
                        throw new ArithmeticException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    }
                    result = dnum1 / dnum2;
                    break;
            }
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage()); // 에러 메시지 출력 기능
        }
        resultsList.add(result);
        return result;
    }

    // Getter 메서드
    public double getResult() {
        System.out.println("계산 결과: " + result);
        return result;
    }

    // Setter 메서드
    public void setResult(T num1, T num2, OperatorType operator) {
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
    }

    // 저장된 연산 결과들 중 Scanner로 입력받은 값보다 큰 결과값들을 출력
    public List<Double> getBigResults() {
        // 트러블 슈팅: calculate()안에서만 double형으로 수정해서 여기서도 수정해야 에러 안뜸
        double dnum1 = num1.doubleValue();
        double dnum2 = num2.doubleValue();
        return resultsList.stream().filter(result -> result > dnum1 || result > dnum2).collect(Collectors.toList());
    }
}
