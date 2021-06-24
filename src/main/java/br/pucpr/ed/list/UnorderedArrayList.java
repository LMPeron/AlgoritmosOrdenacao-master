package br.pucpr.ed.list;

import java.util.StringJoiner;

public class UnorderedArrayList<T> implements List<T> {
    protected T[] array;
    protected Integer size;

    protected UnorderedArrayList(){
        this.size = 0;
    }

    public UnorderedArrayList(Integer capacity) {
        this();
        array = (T[]) new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T element) {
        if(size == array.length){
            throw new IndexOutOfBoundsException();
        }
        array[size++] = element;
    }

    @Override
    public T remove(T element) {
        for(int i = 0; i < array.length - 1; i++){
            if(array[i].equals(element)){
                return remove(i);
            }
        }
        return null;
    }

    @Override
    public T remove(int index) {
        T registroExcluido = array[index];
        for(int i = index; i < array.length - 1; i++){
            array[i] = array[i + 1];
        }
        size--;
        array[size] = null;
        return registroExcluido;
    }

    @Override
    public T find(T key) {
        for(var i = 0; i < size; i++){
            if(array[i].equals(key)){
                return array[i];
            }
        }
        return null;
    }

    @Override
    public boolean exists(T key) {
        return find(key) != null;
    }

    @Override
    public T get(int index) {
        if(index >= array.length){
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    @Override
    public void set(int index, T element) {
        array[index] = element;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        if(size == 0) return null;
        StringJoiner joiner = new StringJoiner(", ");
        for(int i = 0; i < size; i++){
            joiner.add(array[i].toString());
        }
        return "{" + joiner.toString() + "}";
    }
}
