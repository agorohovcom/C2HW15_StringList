package stringlist;

import exception.InvalidStringListInitialCapacity;

public class StringListRealization implements StringList {

    private String[] elementData;
    private int size;

    public StringListRealization(int initialCapacity) {
        if (initialCapacity > 0) {
            elementData = new String[initialCapacity];
            size = 0;
        } else throw new InvalidStringListInitialCapacity();
    }

    @Override
    public String add(String item) {
        return "";
    }

    @Override
    public String add(int index, String item) {
        return "";
    }

    @Override
    public String set(int index, String item) {
        return "";
    }

    @Override
    public String remove(String item) {
        return "";
    }

    @Override
    public String remove(int index) {
        return "";
    }

    @Override
    public boolean contains(String item) {
        return false;
    }

    @Override
    public int indexOf(String item) {
        return 0;
    }

    @Override
    public int lastIndexOf(String item) {
        return 0;
    }

    @Override
    public String get(int index) {
        return "";
    }

    @Override
    public boolean equals(StringList otherList) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public String[] toArray() {
        return new String[0];
    }
}
