package basic.array;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayDeleteQuiz {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] kakao = {"무지", "네오", "어피치", "라이언", "춘식이"};
        System.out.println("현재 저장된 친구들: " + Arrays.toString(kakao));

        /*
         1. 삭제할 친구를 입력받아서 삭제를 진행해 주세요.

         2. 입력받은 이름이 없다면 없다고 얘기해 주세요.

         - 추가
         배열의 길이가 0이 될 때까지 삭제를 반복해 보세요.
         더 이상 지울 친구가 없다면 프로그램 종료.
        */



        outer: while (true) {

            if (kakao.length == 0) {
                System.out.println("삭제할 이름이 없습니다.");
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            System.out.println("삭제할 이름을 입력하세요.");
            System.out.print("> ");
            String delName = sc.next();
            boolean flag = false;
            int idx = -1;
            int i = 0;

            for (i = 0; i < kakao.length; i++) {
                if (delName.equals(kakao[i])) {
                    idx = i;
                    break ;
                }
            }

            if (idx == -1) {
                System.out.printf("%s은(는) 없는 이름입니다.\n", delName);
                continue outer;
            }

            for (i = idx; i < kakao.length-1; i++) {
                kakao[i] = kakao[i+1];
            }

            String[] temp = new String[kakao.length-1];

            for (i = 0; i < temp.length; i++) {
                temp[i] = kakao[i];
            }

            kakao = temp;
            temp = null;

            System.out.printf("%s 삭제 후 정보: ", delName);
            System.out.println(Arrays.toString(kakao));

        }

        sc.close();

    }

}
