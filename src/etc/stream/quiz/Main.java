package etc.stream.quiz;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class Main {
    
    public static void main(String[] args) {
        
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        
        List<Transaction> transactions = List.of(
                new Transaction(brian, 2021, 300),
                new Transaction(raoul, 2022, 1000),
                new Transaction(raoul, 2021, 400),
                new Transaction(mario, 2021, 710),
                new Transaction(mario, 2022, 700),
                new Transaction(alan, 2022, 950)
        );
        
        // 연습 1: 2021년에 발생한 모든 거래를 찾아 거래액 오름차 정렬(작은 값에서 큰 값).
        transactions.stream()
                .filter(transaction -> transaction.getYear() == 2021)
                .sorted(comparing(Transaction::getValue))
                .toList()
                .forEach(System.out::println);
        
        // 연습 2: 거래자가 근무하는 모든 도시 이름을 중복 없이 나열하시오.
        System.out.println("======== 근무 도시 이름 ========");
        transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .toList()
                .forEach(System.out::println);
        
        // 연습 3: Cambridge에 근무하는 모든 거래자를 찾아 거래자 리스트로 이름순으로 오름차 정렬.
        System.out.println("======== Cambridge에 근무하는 모든 거래자 리스트 (이름 오름차순) ========");
        transactions.stream()
                .map(Transaction::getTrader)
                .filter(td -> td.getCity().equals("Cambridge"))
                .sorted(comparing(Trader::getName))
                .toList()
                .forEach(System.out::println);
        
        // 연습 4: 모든 거래자의 이름을 리스트에 모아서 알파벳순으로  오름차 정렬하여 반환
        System.out.println("======== 모든 거래자 리스트 (이름 오름차순) ========");
        transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .toList()
                .forEach(System.out::println);
                
        
        // 연습 5: Milan에 거주하는 거래자가 한명이라도 있는지 여부 확인?
        System.out.println("======== Milan에 거주하는 거래자가 한명이라도 있는지 ========");
        boolean falg = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        
//        boolean falg = transactions.stream()
//                .anyMatch(transaction -> transaction.getTrader().getCity().equalsIgnoreCase("milan"));
        
        System.out.println("falg = " + falg);
        
        
        // 연습 6: Cambridge에 사는 거래자의 모든 거래액의 총합 출력.
        System.out.println("======== Cambridge에 거주하는 거래자가 거래 총액 ========");
        int cambridgeTotal = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .mapToInt(Transaction::getValue)
                .sum();
        
        System.out.println("cambridgeTotal = " + cambridgeTotal);
        /*
        List<Integer> list = transactions.stream()
                .filter(trs -> trs.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .toList();
        
        int total = 0;
        for (Integer i : list) {
            total += i;
        }
        
        System.out.println("total = " + total);
        
        int totalValue = transactions.stream()
                .filter(trs -> trs.getTrader().getCity().equalsIgnoreCase("cambridge"))
                .mapToInt(Transaction::getValue)
                .sum();
        
        System.out.println("totalValue = " + totalValue);
        */
        
        // 연습 7: 모든 거래에서 최고 거래액은 얼마인가?
        System.out.println("======== 최고 거래액 ========");
        int max = transactions.stream()
                .mapToInt(Transaction::getValue)
                .max()
                .getAsInt();
        
        System.out.println("최고 거래액 = " + max);
        
       /*
        Transaction transaction = transactions.stream()
                .max(comparing(Transaction::getValue))
                .get();
        
        System.out.println("maxValue: " + transaction.getValue());
        
        int maxValue = transactions.stream()
                .mapToInt(Transaction::getValue)
                .max()
                .getAsInt();
        
        System.out.println("maxValue = " + maxValue);
        */
        
        // 연습 8. 가장 작은 거래액을 가진 거래정보 탐색
        System.out.println("======== 최저 거래액 거래정보 ========");
        /*
        transactions.stream()
                .min(comparing(Transaction::getValue))
                .ifPresent(System.out::println);
        */
        Transaction transaction = transactions.stream()
                .min(comparing(Transaction::getValue))
                .get();
        
        System.out.println("transaction = " + transaction);
    
    }
    
}
