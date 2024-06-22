package stringlist;

import exception.InvalidStringListInitialCapacityException;
import exception.StringListIndexOutOfBoundsException;
import exception.StringListNullPointerException;

import java.util.Arrays;

public class StringListRealization implements StringList {

    private String[] elementData;
    private int size;

    public StringListRealization(int initialCapacity) {
        if (initialCapacity > 0) {
            elementData = new String[initialCapacity];
            size = 0;
        } else throw new InvalidStringListInitialCapacityException();
    }

    @Override
    public String add(String item) {
        notNullParamChecker(item);
        if (size >= elementData.length) {
            throw new StringListIndexOutOfBoundsException();

        }
        elementData[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        notNullParamChecker(item);
        if (index >= elementData.length || size == elementData.length) {
            throw new StringListIndexOutOfBoundsException();
        }
        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }
        elementData[index] = item;
        size++;
        System.out.println(Arrays.toString(elementData));
        return item;
    }

    @Override
    public String set(int index, String item) {
        notNullParamChecker(item);
        if (index < size) {
            elementData[index] = item;
            return item;
        } else {
            throw new StringListIndexOutOfBoundsException();
        }
    }

    @Override
    public String remove(String item) {
        notNullParamChecker(item);
        return "";
    }

    @Override
    public String remove(int index) {
        return "";
    }

    @Override
    public boolean contains(String item) {
        notNullParamChecker(item);
        return false;
    }

    @Override
    public int indexOf(String item) {
        notNullParamChecker(item);
        return 0;
    }

    @Override
    public int lastIndexOf(String item) {
        notNullParamChecker(item);
        return 0;
    }

    @Override
    public String get(int index) {
        return "";
    }

    @Override
    public boolean equals(StringList otherList) {
        notNullParamChecker(otherList);
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

    private void notNullParamChecker(Object param) {
        if (param == null) {
            throw new StringListNullPointerException();
        }
    }
}
