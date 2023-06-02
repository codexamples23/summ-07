import java.util.*;

public class Sets {
    public static void main(String[] args) {
        HashSet<String> setH = new HashSet<>();

        setH.add("abc");
        setH.add("bbc");
        setH.add(null);
        setH.add(null);
        System.out.println(setH);

        TreeSet<String> setNull = new TreeSet<>();
//        setNull.add(null);
//        та же причина для исключения. пытаемся сравнить null
//        String s = null;
//        System.out.println(s.compareTo("abacaba"));


        // проблема решается использованием компаратора
        TreeSet<String> setT = new TreeSet<>(new NullComparator());
        setT.add("abc");
        setT.add("bbc");
        setT.add(null);
        System.out.println(setT);


        LinkedHashSet<String> setLH = new LinkedHashSet<>();

        setLH.add("bbc");
        setLH.add("abc");
        setLH.add(null);
        setLH.add(null);
        System.out.println(setLH);

    }

    // нужно вернуть новый список без дубликатов
    public static List<String> withoutDuplicates(List<String> strings) {
        return new LinkedList<>(new HashSet<>(strings));
    }
}
