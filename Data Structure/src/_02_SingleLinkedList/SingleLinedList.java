package _02_SingleLinkedList;

import interface_form.List;

public class SingleLinedList<E> implements List<E> {

    private Node<E> head; // 노드의 첫 부분
    private Node<E> tail; // 노드의 마지막 부분
    private int size; // 데이터 개수

    // 생성자
    public SingleLinedList(Node<E> head, Node<E> tail, int size) {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // 특정 위치의 노드 반환
    private Node<E> search(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        // head가 가리키는 노드부터 시작
        Node<E> cur = this.head;

        for (int i = 0; i < index; i++) {
            cur = cur.next; // cur노드의 다음 노드를 cur에 저장한다
        }

        return cur;
    }

    public void addFirst(E data) {

        Node<E> newNode = new Node<E>(data); // 새로운 노드에 data를 넣고 생성
        newNode.next = head; // 새 노드의 다음 노드를 기존 head와 연결
        head = newNode; // head 위치 변경
        size++;


        // 다음에 가리킬 노드가 없는 경우(= 데이터가 새 노드밖에 없는 경우)
        // 데이터가 한 개(새 노드)밖에 없으므로 새 노드는 처음 시작노드이자
        // 마지막 노드다. 즉 tail = head.

        if (head.next == null) {
            tail = head;
        }
    }

    @Override
    public boolean add(E data) {
        addLast(data);
        return true;
    }

    public void addLast(E data){
        // 새 노드 생성
        Node<E> newNode = new Node<>(data);

        // 만약 데이터가 없었던 경우 addFirst 실행
        if(size == 0){
            addFirst(data);
            return;
        }

        tail.next = newNode; // 기존 마지막 노드(tail)의 다음 노드(next)가 새 노드를 가리키도록 하고
        tail = newNode; // tail위치 변경
        size++;
    }
}
