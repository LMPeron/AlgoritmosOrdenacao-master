package br.pucpr.ed;

import br.pucpr.ed.list.SortableArrayList;
import br.pucpr.ed.list.List;
import br.pucpr.ed.list.ListSort;

public class SearchApp {

    public static void main(String[] args) {
        List<Integer> numberList = createSortableList();
        System.out.println("Lista não ordenada: " + numberList);
        SortableArrayList listaOrdenada = ListSort.bubbleSort((SortableArrayList) numberList);
        System.out.println("Lista ordenada com bubble-sort: " + listaOrdenada);

        // numberList = createSortableList();
        // System.out.println("Lista não ordenada: " + numberList);
        // listaOrdenada = ListSort.mergeSort((SortableArrayList) numberList);
        // System.out.println("Lista ordenada com merge-sort: " + listaOrdenada);
    }

    /**
     * Retorna uma lista não ordenada com 10 elementos.
     * @return
     */
    private static List<Integer> createSortableList() {
        List<Integer> numberList = new SortableArrayList<>(10);
        numberList.add(60);
        numberList.add(12);
        numberList.add(37);
        numberList.add(33);
        numberList.add(79);
        numberList.add(24);
        numberList.add(82);
        numberList.add(66);
        numberList.add(82);
        numberList.add(9);
        return numberList;
    }
}
