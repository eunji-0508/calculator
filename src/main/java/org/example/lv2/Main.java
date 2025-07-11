package org.example.lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        Calculator calculator = new Calculator();

        // exit 전까지 무한 반복 while문 사용
        while(true) {
            // 양의 정수(0 포함)를 입력받기
            // 양의 정수는 각각 하나씩 전달 받기
            // 양의 정수는 적합한 타입으로 선언한 변수에 저장하기
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = scanner.nextInt();

            System.out.print("두 번째 숫자를 입력하세요: ");   // 여기서는 에러 안나는 이유: nextInt()는 숫자만 읽어서 엔터 알아서 버려짐.
            int num2 = scanner.nextInt();

            if((num1 < 0) || (num2 < 0)) {
                System.out.println("양의 정수만 입력하세요!");
                continue;   // 다시 while문으로 돌아가서 반복
            }






            // 반복문을 사용하되, 반복의 종료를 알려주는 “exit” 문자열을 입력하기 전까지 무한으로 계산을 진행할 수 있도록 소스 코드를 수정하기
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String answer = scanner.nextLine();
            if(answer.equals("exit")) {
                break;
            }
        }
        scanner.close();    // 스캐너 닫기
    }

    }

