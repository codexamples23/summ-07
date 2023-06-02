import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GenInheritMain {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>(List.of(1, 2, 3, 4));
        // так написать нельзя, потому что наследование Number <- Integer не переходит в параметр
        // List<Number> numbers = integers;

        // это лист of Number. В нём может быть ссылка на лист потомков Number, которые по сути являются Number
        List<? extends Number> numbers = integers;
        // numbers.add(Integer.valueOf(10)); а что если там другой потомок, не Integer. Например List<X>




        Integer i = 1;
        Number n = i;
        System.out.println(n);
    }
}
