import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

/**
 * КЛасс реализации ArrayList
 *
 * @param <E>
 */
public class Arrayy<E> {

    private Object[] elements;  //массив
    private int size;  //поле-счетчик, которое указывает на количество элементов в массиве
    private static final int DEFAULT_CAPACITY = 10;  //размер массива по умолчанию

    //конструктор без параметров, который создает массив на 10 элементов, если размер не был указан
    public Arrayy() {  //
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    //создает массив указанной емкости
    public Arrayy(int initialCapacity) {
        if (initialCapacity >= 0) {
            this.elements = new Object[initialCapacity];
        } else {
            throw new IllegalStateException("Capacity can't be less than 0!");
        }
    }

    //получает элемент по указанному индексу
    public Object get(int index) {
        isIndexExist(index);  //проверка корректности введенного индекса
        return elements[index];
    }

    //возвращает количество элементов в списке
    public int size() {
        return size;
    }

    //добавляем элемент в конец списка
    public void add(Object value) {
        if (size == elements.length) {  //если в массиве места нет
            elements = increaseCapacity(); //вызываем метод, который отвечает за увеличение массива
        }
        elements[size] = value; //записываем в конец списка новое значение
        size++;  //увеличиваем значение переменной размера списка
    }

    //дополнительный закрытый метод для увеличения емкости массива
    private Object[] increaseCapacity() {
        Object[] temp = new Object[(elements.length * 2)];  //создаем новый массив большего размера
        System.arraycopy(elements, 0, temp, 0, elements.length);  //копируем в новый массив элементы из старого массива
        return temp;
    }

    //устанавливает элемент на указанную позицию
    public Object set(Object value, int index) {
        isIndexExist(index);
        Object temp = elements[index];
        elements[index] = value;
        return temp;
    }

    //переопределил метод для красивого вывода списка на экран, иначе будут выводиться значения незаполненных ячеек [1, 10] вместо [1, 10, 0, 0...]
    @Override
    public String toString() {
        Object[] temp = new Object[size];
        System.arraycopy(elements, 0, temp, 0, size);
        return Arrays.toString(temp);
    }

    //проверяем индексы, не выходят ли они за границы массива
    private void isIndexExist(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Element can't be found! "
                    + "Number of elements in array = " + size
                    + ". Total size of array = " + elements.length);
        }
    }

    //проверяем, есть ли элементы в списке
    public boolean isEmpty() {
        return (size == 0);
    }

    //удаляем элемент по индексу
    public Object remove(int index) {
        isIndexExist(index);  //проверяем индекс
        Object[] temp = elements;  //во временный массив заносим ссылку на текущий массив
        elements = new Object[temp.length - 1];  //полю elements присваиваем ссылку на новый массив размером меньше на 1
        Object value = temp[index];  //сохраняем в доп. переменную значение удаляемого элемента
        System.arraycopy(temp, 0, elements, 0, index);  //копируем левую часть массива до указанного индекса
        System.arraycopy(temp, index + 1, elements, index, temp.length - index - 1);  //копируем правую часть массива после указанного индекса
        size--;  //уменьшаем значение переменной
        return value;
    }

    public void update(int index, Object values) {
        elements[index] = values;
    }
}
