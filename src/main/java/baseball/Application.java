package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        String restart = "1";

        while(restart.equals("1")) {
            System.out.print("숫자를 입력 해주세요: ");
            int ball = 0;
            int strike = 0;
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            List<Integer> userNumber = new ArrayList<>();
            while(true) {
                String userInput = Console.readLine();
                if(userInput.length() != 3) {
                    System.out.println("3자리의 숫자를 입력해주세요.");
//                    Console.close();
                    continue;
                } //TODO: 수정필요
                if(Objects.equals(userInput.charAt(0),userInput.charAt(1)) || Objects.equals(userInput.charAt(0),userInput.charAt(2)) || Objects.equals(userInput.charAt(1),userInput.charAt(2))) {
                    System.out.println("서로다른 3자리의 숫자를 입력해주세요.");
//                    Console.close();
                    continue;
                }
                for(int i=0; i<userInput.length(); i++) {
                    userNumber.add(Character.getNumericValue(userInput.charAt(i))); // try catch?
                }
//                Console.close();
                break;
            }
            System.out.println(computer);
            System.out.println(userNumber);

            for(int i=0; i<3; i++) {
                if (Objects.equals(computer.get(i), userNumber.get(i))) {
                    strike++;
                } else if (computer.contains(userNumber.get(i))) {
                    ball++;
                }
            }

            StringBuilder stringbuilder = new StringBuilder("");
            if(ball == 0 && strike == 0){
                System.out.println("낫싱");
                continue;
            }
            if(ball != 0) {
                stringbuilder.append(ball).append("볼 ");
            }
            if(strike != 0){
                stringbuilder.append(strike).append("스트라이크");
            }
            System.out.println(stringbuilder.toString().trim());
            if(strike == 3){
                System.out.println("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                restart = Console.readLine();
            }
        }
    }
}
