package stringlist;

import exception.InvalidStringListInitialCapacityException;
import exception.StringListElementNotFoundException;
import exception.StringListIndexOutOfBoundsException;
import exception.StringListNullPointerException;

import java.util.Arrays;

public class StringListRealization implements StringList {

    private String[] elementData;
    private int size;
    private final double LOAD_FACTOR = 0.75d;
    private final int CAPACITY_DECOMPRESS_VALUE = 10;
    private final int DEFAULT_CAPACITY_VALUE = 10;

    public StringListRealization() {
        elementData = new String[DEFAULT_CAPACITY_VALUE];
        size = 0;
    }

    public StringListRealization(int initialCapacity) {
        if (initialCapacity >= 0) {
            elementData = new String[initialCapacity];
            size = 0;
        } else throw new InvalidStringListInitialCapacityException();
    }

    @Override
    public String add(String item) {
        notNullParamCheckPlease(item);
        decompressElementDataCapacityPlease();
        elementData[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        notNullParamCheckPlease(item);
        decompressElementDataCapacityPlease();
        if (index < 0) {
            throw new StringListIndexOutOfBoundsException();
        }
        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }
        elementData[index] = item;
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        notNullParamCheckPlease(item);
        if (index >= size || index < 0) {
            throw new StringListIndexOutOfBoundsException();
        }
        elementData[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        notNullParamCheckPlease(item);
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(item)) {
                for (int j = i; j < size - 1; j++) {
                    elementData[j] = elementData[j + 1];
                }
                elementData[--size] = null;
                return item;
            }
        }
        throw new StringListElementNotFoundException();
    }

    @Override
    public String remove(int index) {
        if (index >= size || index < 0) {
            throw new StringListIndexOutOfBoundsException();
        }
        trimToSizePlus10Please();
        String result = elementData[index];
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        elementData[--size] = null;
        return result;
    }

    @Override
    public boolean contains(String item) {
        notNullParamCheckPlease(item);
        return Arrays.stream(elementData).limit(size).anyMatch(s -> s.equals(item));
    }

    @Override
    public int indexOf(String item) {
        notNullParamCheckPlease(item);
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        notNullParamCheckPlease(item);
        for (int i = size - 1; i >= 0; i--) {
            if (elementData[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index >= size || index < 0) {
            throw new StringListIndexOutOfBoundsException();
        }
        return elementData[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        notNullParamCheckPlease(otherList);
        if (size != otherList.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!elementData[i].equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return !(size > 0);
    }

    @Override
    public void clear() {
        elementData = new String[DEFAULT_CAPACITY_VALUE];
        size = 0;
    }

    @Override
    public String[] toArray() {
        String[] result = new String[size];
        System.arraycopy(elementData, 0, result, 0, size);
        return result;
    }

    private void notNullParamCheckPlease(Object param) {
        if (param == null) {
            throw new StringListNullPointerException();
        }
    }

    private void decompressElementDataCapacityPlease() {
        if ((size + 1) > (elementData.length * LOAD_FACTOR)) {
            elementData = Arrays.copyOf(elementData, elementData.length + CAPACITY_DECOMPRESS_VALUE);
        }
    }

    private void trimToSizePlus10Please() {
        if ((size * 2) < elementData.length) {
            elementData = Arrays.copyOf(elementData, size + DEFAULT_CAPACITY_VALUE);
        }
    }
}
