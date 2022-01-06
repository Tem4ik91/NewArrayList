import java.util.Collections;
import java.util.Map;
import java.util.Comparator;
import java.util.Random;

/**
 * Быстрая сорртировка Quicksort
 *
 * @param <E>
 */
public class Quicksort<E> {

    public void qsort(Arrayy<E> arrayList,
                      int left,
                      int right,
                      Comparator<Object> comp) { //параметризованный метод qsort

        int i = left; //первый индекс
        int j = right;//последний индекс

        if (j > i) {
            Object pivot = arrayList.get((i + j) / 2);// pivot элемент
            while (i <= j) {

                while (i < right && comp.compare(arrayList.get(i), pivot) < 0) { //сравнение с pivot больше или меньше чем элемент
                    i += 1;
                }
                while (j > left && comp.compare(arrayList.get(j), pivot) > 0) {
                    j -= 1;
                }
                if (i <= j) {
                    swap(arrayList, i, j); //поменять местами элементы в ArrayList
                    i += 1;
                    j -= 1;
                }
            }
            if (left < j) {
                qsort(arrayList, left, j, comp);

            }
            if (i < right) {
                qsort(arrayList, i, right, comp);
            }
        }
    }


    public void swap(Arrayy<E> arrayList, int index1, int index2) {
        Object temp = arrayList.get(index1); //Временная переменная для значения
        arrayList.update(index1, arrayList.get(index2)); //поменять местами значения в индексах
        arrayList.update(index2, temp);
    }
}
