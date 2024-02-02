package lab1;

public class Main {
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
