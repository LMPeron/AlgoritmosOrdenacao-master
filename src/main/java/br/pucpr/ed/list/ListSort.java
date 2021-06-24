package br.pucpr.ed.list;

public class ListSort {
    /**
     * Exercício 1
     */
    public static SortableArrayList bubbleSort(SortableArrayList list) {
        int size = list.size();
        for (var i = 0; i < size - 1; i++) {
            for (var j = 0; j < size - i - 1; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    var order = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, order);
                }
            }
        }
        return list;
    }

    /**
     * Exercício 2
     */
    public static SortableArrayList mergeSort(SortableArrayList list) {

        var left = new SortableArrayList<>(list.size());
        var right = new SortableArrayList<>(list.size());

        int center;

        if (list.size() == 1)
            return list;

        else {
            center = list.size() / 2;

            for (var i = 0; i < center; i++)
                left.add(list.get(i));

            for (int i = center; i < list.size(); i++)
                right.add(list.get(i));

            left = mergeSort(left);
            right = mergeSort(right);
            list = merge(left, right);
        }

        return list;
    }

    /**
     * Método usado para mesclar as listas ordenadas list1 e list2.
     *
     * Dicas: 1. Crie uma lista com tamanho igual a soma dos tamanhos de list1 e
     * list2. 2. Itere sobre a lista recém criada, a cada iteração um elemento de
     * list1 ou list2 é selecionado (aquele que for menor) para ser incluído na nova
     * lista. a. Utilize os métodos add e remove para mover os elementos de uma
     * lista para outra. b. Utilize um índice para cada uma das 2 listas para saber
     * qual o próximo elemento que deve ser inserido. Por exemplo: l1Index e
     * l2Index. c. Tome cuidado para não acessar uma posição não alocada de list1 ou
     * list2, o que causará IndexArrayOfBoundsException. 3. Retorne a lista.
     * 
     * @param list1 Lista ordenada 1
     * @param list2 Lista ordenada 2
     * @return Lista ordenada com a combinação de todos os elementos de list1 e
     *         list2
     */
    private static SortableArrayList merge(SortableArrayList list1, SortableArrayList list2) {

        var list = new SortableArrayList<>(list1.size() + list2.size());

        var left = 0;
        var right = 0;
        var index = 0;

        while (left < list1.size() && right < list2.size()) {
            if (list1.get(left).compareTo(list2.get(right)) < 0) {
                list.set(index, list1.get(left));
                left++;
            } else {
                list.set(index, list2.get(right));
                right++;
            }
            index++;
        }

        while (left < list1.size()) {
            list.set(index, list1.get(left));
            index++;
            left++;
        }

        while (right < list2.size()) {
            list.set(index, list2.get(right));
            index++;
            right++;
        }

        return list;
    }

    /**
     * Exercício 3
     */
    public static SortableArrayList shellSort(SortableArrayList list) {

        for (int g = list.size() / 2; g > 0; g /= 2) {
            for (int i = g; i < list.size(); i += 1) {
                var temp = list.get(i);

                int j;
                for (j = i; j >= g && list.get(j - g).compareTo(temp) > 0; j -= g)
                    list.set(j, j - g);

                list.set(j, temp);

            }
        }

        return list;
    }

    /**
     * Exercício 4
     */
    public static SortableArrayList quickSort(SortableArrayList list) {
        if (list.isEmpty())
            return list;
        var s = new SortableArrayList<>(1000);
        var g = new SortableArrayList<>(1000);
        var pivot = list.get(0);
        int i;
        Comparable j;

        for (i = 1; i < list.size(); i++) {
            j = list.get(i);
            if (j.compareTo(pivot) < 0)
                s.add(j);
            else
                g.add(j);
        }

        s = quickSort(s);
        g = quickSort(g);
        s.add(pivot);

        for (var k = 0; k < g.size() - 1; k++) {
            s.add(g.get(k));
        }
        list = s;
        return list;
    }
}
