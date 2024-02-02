# Лабораторная работа №2 - LinkedList

<h1>Реализация</h1>
<h2>Методы класса MyLinkedList</h2>

```public MyLinkedList()```


Этот конструктор создает пустой MyLinkedList. Он инициализирует поле mSize значением 0 и создает сторожевые узлы для головы и хвоста списка.

```public final int size()```


Этот метод возвращает количество элементов в MyLinkedList.

```public void addLast(T value)```


Этот метод добавляет указанный элемент value в конец MyLinkedList. Он создает новый узел, содержащий value, вставляет его в список и увеличивает поле mSize.

```public void addFirst(T value)```


Этот метод добавляет указанный элемент value в начало MyLinkedList. Он создает новый узел, содержащий value, вставляет его в список и увеличивает поле mSize.

```public void removeFirst()```


Этот метод удаляет первый элемент из MyLinkedList. Он удаляет узел в голове списка, уменьшает поле mSize и обновляет ссылки соседних узлов.

```public void removeLast()```


Этот метод удаляет последний элемент из MyLinkedList. Он удаляет узел в хвосте списка, уменьшает поле mSize и обновляет ссылки соседних узлов.


```public T getFirst()```


Этот метод возвращает первый элемент в MyLinkedList. Он проверяет, что список не пуст, а затем возвращает данные узла в голове списка.

```public T getLast()```

Этот метод возвращает последний элемент в MyLinkedList. Он проверяет, что список не пуст, а затем возвращает данные узла в хвосте списка.

```public Iterator<T> iterator()```
Этот метод реализует интерфейс Iterator<T>, возвращая объект ListIterator. Этот объект можно использовать для итерирования по элементам MyLinkedList в прямом или обратном направлении.

```public void remove(T value)```

Этот метод удаляет все вхождения указанного элемента value из MyLinkedList. Он итерирует по списку с помощью итератора и удаляет каждый узел, содержащий **value**.

Реализация интерфейса Iterable

Класс MyLinkedList реализует интерфейс Iterable<T>, что позволяет итерироваться по его элементам с помощью цикла for-each. Итератор итерирует по элементам в порядке от головы списка к хвосту.

**Дополнительные комментарии**

1. Класс MyLinkedList использует сторожевые узлы для упрощения реализации методов добавления и удаления элементов. Сторожевые узлы - это специальные узлы, которые всегда находятся в начале и в конце списка. Они используются для упрощения ссылок на соседние узлы.
2. Методы addLast() и addFirst() работают аналогично, но они различаются в том, где они добавляют новый узел. Метод addLast() добавляет новый узел в конец списка, а метод addFirst() добавляет новый узел в начало списка.
3. Методы removeFirst() и removeLast() также работают аналогично, но они различаются в том, какой узел они удаляют. Метод removeFirst() удаляет узел в голове списка, а метод removeLast() удаляет узел в хвосте списка.
4. Метод getFirst() возвращает первый элемент в списке. Он проверяет, что список не пуст, прежде чем возвращать данные узла в голове списка.

<h2>Реализация ListIterator</h2>


Этот класс реализует интерфейс ```Iterator<T>``` и предоставляет методы для итерирования по ```MyLinkedList``` в прямом или обратном направлении. Он поддерживает ссылку mCurrentNode на текущий обрабатываемый узел. Метод ```value()``` возвращает данные текущего узла, а методы ```hasNext()``` и ```hasPrevious()``` указывают, есть ли еще элементы для обработки в прямом или обратном направлении соответственно. Метод ```next()``` перемещает **mCurrentNode** к следующему узлу и возвращает его данные, а метод ```previous()``` перемещает mCurrentNode к предыдущему узлу и возвращает его данные.

<h2> Проверка работоспособности</h2>
Для проверки работоспособности программы в классе Main использованы реализованные методы:

```public class Main {
	public static void main(String[] args) {
		MyLinkedList<Integer> testList = new MyLinkedList<Integer>();
		for(int i = 0; i < 6; i++) {
			testList.addLast(i);
		}
		testList.addFirst(5);
		testList.addFirst(5);
		System.out.println("Size:" + testList.size());
		System.out.println("-----Elements:--------");
		for(Integer el : testList) {
			System.out.println(el);
		}
		System.out.println("----------------------");
		
		testList.remove(5);
		System.out.println("-----Removed (5):-----");
		for(Integer el : testList) {
			System.out.println(el);
		}
		System.out.println("----------------------");
	}
}
```
Также реализован класс для тестов:

```
class MyTestClass {

	@Test
    public void addFirst() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.addFirst(1);
        assertEquals(1, linkedList.getFirst());
    }

    @Test
    public void addLast() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.addLast(1);
        assertEquals(1, linkedList.getLast());
    }

    @Test
    public void removeFirst() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.addFirst(1);
        linkedList.removeFirst();
        assertEquals(0, linkedList.size());
    }

    @Test
    public void removeLast() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.addFirst(1);
        linkedList.removeLast();
        assertEquals(0, linkedList.size());
    }
}

```


<h2> </h2>
<h1>Результат работы программы</h1>
Вывод после работы main:
<image 
	src = "Java2324_res.png"
	></image>
Результат прохождения тестов:
<image 
	src = "Java2324_test.png">
</image>
