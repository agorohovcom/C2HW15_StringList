import stringlist.StringList;
import stringlist.StringListRealization;

public class Main {
    public static void main(String[] args) {
        StringList list = new StringListRealization(5);
        System.out.println("------------------------------------------------");

        System.out.println(list.add("one"));
        System.out.println("list.size() = " + list.size());
        System.out.println(list.add("two"));
        System.out.println("list.size() = " + list.size());
        System.out.println(list.add("three"));
        System.out.println("list.size() = " + list.size());
        System.out.println("------------------------------------------------");

        list.add(1, "два");
        System.out.println("list.size() = " + list.size());
        list.add(0, "я ноль");
        System.out.println("list.size() = " + list.size());
        list.add(0, "я ноль");
    }
}
