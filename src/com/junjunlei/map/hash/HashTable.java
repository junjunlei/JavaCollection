package com.junjunlei.map.hash;

/**
 * @author junjun.lei
 * @create 2020-04-01 14:08
 */
public class HashTable {

    private DataItem[] hashArrary;
    private int arraySize;
    private DataItem nonItem;

    public HashTable(int size) {
        this.arraySize = size;
        hashArrary = new DataItem[arraySize];
        nonItem = new DataItem(-1);
    }

    public void displayTable() {
        System.out.println("Table:");
        for (int j = 0; j < arraySize; j++) {
            if (hashArrary[j] != null) {
                System.out.println(hashArrary[j].getKey() + " ");
            } else {
                System.out.println("** ");
            }
            System.out.println();
        }
    }

    public void insert(DataItem item) {
        int key = item.getKey();
        int hashVal = hashFunc(key);

        while (hashArrary[hashVal] != null && hashArrary[hashVal].getKey() != -1) {
            ++hashVal;
            hashVal %= arraySize;
        }
        hashArrary[hashVal] = item;
    }

    public DataItem delete(int key) {
        int hashVal = hashFunc(key);
        while (hashArrary[hashVal] != null) {
            if (hashArrary[hashVal].getKey() == key) {
                DataItem temp = hashArrary[hashVal];
                hashArrary[hashVal] = nonItem;
                return temp;
            }
            ++hashVal;
            hashVal %= arraySize;
        }
        return null;
    }

    public DataItem find(int key) {
        int hashVal = hashFunc(key);
        while (hashArrary[hashVal] != null) {
            if (hashArrary[hashVal].getKey() == key) {
                return hashArrary[hashVal];
            }
            ++hashVal;
            hashVal %= arraySize;
        }
        return null;
    }

    private int hashFunc(int key) {
        int i = hashCode();
        return key;
    }
}
