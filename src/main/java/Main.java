import stringlist.StringList;
import stringlist.StringListRealization;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StringList list = new StringListRealization(5);
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println("------------------------------------------------");

        System.out.println(list.add("one"));
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println("list.size() = " + list.size());
        System.out.println(list.add("two"));
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println("list.size() = " + list.size());
        System.out.println(list.add("three"));
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println("list.size() = " + list.size());
        System.out.println("------------------------------------------------");

        System.out.println("list.add(1, \"два\"): " + list.add(1, "два"));
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println("list.size() = " + list.size());
        System.out.println("list.add(0, \"я ноль\"): " + list.add(0, "я ноль"));
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println("list.size() = " + list.size());
//        list.add(0, "я ноль");
//        list.add(-1, "я минус");
        System.out.println("------------------------------------------------");

//        list.set(4, "set");
//        list.set(3, "set");
//        list.set(2, "set");
//        list.set(1, "set");
        System.out.println("list.set(0, \"set\"): " + list.set(0, "set"));
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println("list.size() = " + list.size());
//        list.set(0, null);
//        list.set(-1, "set");
//        list.set(5, "set");
        System.out.println("------------------------------------------------");

        list.set(0, "one");
        list.remove("two");
        list.remove("one");
//        list.remove("set");
//        list.remove(null);
        System.out.println("------------------------------------------------");

        System.out.println(Arrays.toString(list.toArray()));
        System.out.println("list.size() = " + list.size());
        System.out.println(list.remove(0));
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println("list.size() = " + list.size());
        System.out.println("------------------------------------------------");

        System.out.println("list.contains(\"такого нету\"): " + list.contains("такого нету"));
        System.out.println("list.contains(\"three\"): " + list.contains("three"));
//        System.out.println("list.contains(null): " + list.contains(null));
        System.out.println("------------------------------------------------");

        System.out.println(list.indexOf("два"));
        System.out.println(list.indexOf("three"));
        System.out.println(list.indexOf("thrкпкеee"));
        System.out.println("------------------------------------------------");

        list.add("three");
        list.add("ещё элемент");
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(list.lastIndexOf("два"));
        System.out.println(list.lastIndexOf("three"));
        System.out.println(list.lastIndexOf("thrrghfgee"));
        System.out.println("------------------------------------------------");

        System.out.println(list.get(0));
        System.out.println("------------------------------------------------");

        System.out.println(Arrays.toString(list.toArray()));
        StringList list2 = new StringListRealization(list.size());
        for (int i = 0; i < list.size(); i++) {
            list2.add(list.get(i));
        }
        System.out.println(Arrays.toString(list2.toArray()));
        System.out.println("list.equals(list2): " + list.equals(list2));
        list2.remove(0);
        System.out.println("list.equals(list2): " + list.equals(list2));
//        System.out.println("list.equals(null): " + list.equals(null));

        System.out.println("------------------------------------------------");
        System.out.println("list.isEmpty(): " + list.isEmpty());
        System.out.println("new StringListRealization(1).isEmpty(): " + new StringListRealization(1).isEmpty());
    }
}
