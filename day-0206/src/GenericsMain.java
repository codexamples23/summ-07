import java.util.*;


public class GenericsMain {
    public static void main(String[] args) {

        // как ведет себя наследование

        // создать класс коробка, в котором можно будет хранить
        // значение разных типов (в разных коробках)
        Box<String> b1 = new Box<>();

        b1.setT("box1");
        String s = b1.getT();

        Box<Integer> b2 = new Box<>();
        b2.setT(2);
        int x = b2.getT();

        System.out.println(s + " " + x);


        Pair<String, Integer> result = findMostFrequentWord(new String[] {"1", "2"});
        String word = result.getE1();
        System.out.println(result.getE1() + " " + result.getE2());
        Pair<Customer, Long> result2 = findMostFrequentCustomer(new Customer[0]);


        // наследование + дженерики
        // extends, super, PECS



    }

    // метод находит самое часто встречающееся слово в тексте и возвращает его
    // И кол-во его вхождений
    public static Pair<String, Integer> /* заменить void на... Что? */ findMostFrequentWord(String[] text) {
        int count = 0;
        String word = "!";
        // как-то работает!!!!
        // а как вернуть результат?
        // return count and word
        int maxCount = 10;
        String maxWord = "!!!";
        return new Pair<>(maxWord, maxCount);
    }

    // метод находит самого часто встречающегося посетителя и возвращает его
    // И кол-во его вхождений
    public static Pair<Customer, Long> /* заменить void на... Что? */ findMostFrequentCustomer(Customer[] customers) {
        return new Pair<>(new Customer(), (long) 100);
    }
}