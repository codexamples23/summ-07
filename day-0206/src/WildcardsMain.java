import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WildcardsMain {
    public static void main(String[] args) {

        List<Integer> listOfInts = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        listOfInts.add(10); // autoboxing

        List<Bit> listOfBits = new LinkedList<>();
        listOfBits.add(new Bit());
        // listOfBits.add(10); // no autoboxing!!!!



        // мы можем присвоить сюда любой лист of Number
        // или его потомков
        List<? extends Number> listExtends = listOfBits;
        // List<? extends Number> listExtends = listOfInts;


        Number number = listExtends.get(0);
        // мы не можем понять, это листОфБитс или листОфИнтс
        // здесь мы не знаем, лист ЧЕГО мы используем. Это может быть лист интегеров с автоупаковкой
        // а может быть листОфБитс
        // listExtends.add(10);


        // мы можем положить null, потому что он является валидным значением любого типа
        listExtends.add(null);


        // мы можем записать в listSuper лист оф ПРЕДОК ИНТЕДЖЕРА
        List<? super Integer> listSuper = listOfInts; // мы можем положить и лист обжектов, и лист намберов

        // с этим примером у нас вылетает ClassCastException на 46й строке
        // List<? super Integer> listSuper = new ArrayList<>(List.of(new Object()));

        Object o = listSuper.get(0);


        // а так нельзя, потому что непонятно лист ЧЕГО наш listSuper
        // Integer i = listSuper.get(0);

        Integer i = (Integer) o;
        System.out.println(i);


        // PECS
        // producer extends, consumer super
        // если у нас есть коллекция-продьюсер, то она будет extends
        // если у нас есть коллекция-консьюмер, то она будет super


        System.out.println(sumNumbers(listOfInts));
        System.out.println(asDouble(10)); // автоупаковался в интеджер, привёлся к классу-предку
    }

    public static double asDouble(Number number) { // наш интеджер привёлся к классу-предку Number
        return number.doubleValue();
    }



    // даём коллекцию, даём числа 5 и 10, он добавляет туда 5, 6, 7, 8, 9
    // это CONSUMER. Мы хотим видеть коллекцию, способную ПРИНИМАТЬ Ingeger
    // любая коллекция предков Integer может принимать Integer
    // (потому что Integer можно привести к любому его предку)
    public static void fillWithIntegers(List<? super Integer> numbers, int start, int end) {
        for (int i = start; i < end; i++) {
            numbers.add(i); // автоупаковка в Integer, затем ВОЗМОЖНО приведение типа
        }
    }

    // мы можем принять коллекцию намберов
    // является """родительской коллекцией"""
    // можем """приводить""" коллекции of потомки
    //
    // это PRODUCER. Мы хотим видеть коллекцию, способную ВЫДАВАТЬ Number
    // любая коллекция потомков Number может выдать объект, который можно привести к Number
    // (к классу-предку)
    public static double sumNumbers(List<? extends Number> numbers) {
        double sum = 0;
        // мы точно знаем, что содержимое numbers наследуется от Number
        // мы работает с листом List<Number>
        for (Number n: numbers) {
            sum += n.doubleValue();
        }
        return sum;
    }
}
