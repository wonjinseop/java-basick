package etc.stream;

import java.util.Comparator;
import java.util.stream.Collectors;

import static etc.stream.Menu.menuList;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class Sorting {
    
    public static void main(String[] args) {
    
        // 음식 목록 중 칼로리가 낮은 순으로 정렬 (오름차순 정렬)
        menuList.stream()
                .sorted(comparing(Dish::getCalories))
                .toList()
                .forEach(System.out::println);
        
        System.out.println("====================================================================================");
        
        // 음식 목록 중 칼로리가 높은 순으로 정렬 (내림차순 정렬)
        menuList.stream()
                .sorted(comparing(Dish::getCalories).reversed())
                .toList()
                .forEach(System.out::println);
        
        System.out.println("====================================================================================");
        
        // 500칼로리보다 작은 요리중에 top3 필터링
        menuList.stream()
                .filter(dish -> dish.getCalories() < 500) // 칼로리가 500 미만인 애들만 걸러
                .sorted(comparing(Dish::getCalories).reversed()) // 걸른 애들 정렬 (높은 순)
                .limit(3)
                .toList()
                .forEach(System.out::println);
        
    }
    
}
