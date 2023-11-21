package freePractise.classResearching.collections.selfCreatedCollection.linkedList;

import java.util.LinkedList;
import java.util.List;

import static helpers.Helpers.*;

public class LinkedListCollection {
    public static void linkedListCollection() {
        printArticle("LinkedList, my realisation");

        List<Integer> list = new LinkedList<>();
        LL<Integer> ll = new LL<>();

        ll.add(100);
        ll.add(101);
        ll.add(102);
        System.out.println("ll = " + ll);

        ll.add(200);
        System.out.println("ll = " + ll);

        ll.add(300);
        System.out.println("ll = " + ll);

        ll.addToStart(550);
        ll.addToStart(560);
        ll.addToStart(570);
        System.out.println("ll = " + ll);

        System.out.println("ll.add(0,777) = " + ll.add(0, 777));
        System.out.println("ll.add(4,666) = " + ll.add(4, 666));
        System.out.println("ll = " + ll);

//        System.out.println("ll.size() = " + ll.size());
//        System.out.println("ll.indexOf(100) = " + ll.indexOf(100));
//        System.out.println("ll.indexOf(101) = " + ll.indexOf(101));
//        System.out.println("ll.indexOf(102) = " + ll.indexOf(102));
//        System.out.println("ll.indexOf(300) = " + ll.indexOf(300));
//        System.out.println("ll.indexOf(200) = " + ll.indexOf(200));
//        System.out.println("ll.indexOf(555) = " + ll.indexOf(555));
//
//        System.out.println("ll.contains(444) = " + ll.contains(444));
//        System.out.println("ll.contains(300) = " + ll.contains(300));
//
//        System.out.println("ll.get(-1) = " + ll.get(-1));
//        System.out.println("ll.get(0) = " + ll.get(0));
//        System.out.println("ll.get(4) = " + ll.get(4));

        printArticleEnding();
    }
}

class LL<T> {

    private Node<T> firstNode;
    private Node<T> lastNode;

    public LL() {
    }

    private class Node<T> {
        private T element;
        private Node<T> previousNode;
        private Node<T> nextNode;

        Node(T element, Node<T> previousNode, Node<T> nextNode) {
            this.element = element;
            this.previousNode = null;
            this.nextNode = nextNode;
        }

        T getElement() {
            return element;
        }

        void setElement(T element) {
            this.element = element;
        }

        Node<T> getPreviousNode() {
            return previousNode;
        }

        void setPreviousNode(Node<T> previousNode) {
            this.previousNode = previousNode;
        }

        Node<T> getNextNode() {
            return nextNode;
        }

        void setNextNode(Node<T> nextNode) {
            this.nextNode = nextNode;
        }

        boolean hasNextNode() {
            return nextNode != null;
        }

        boolean isLastNode() {
            return this.nextNode == null;
        }

    }

    public boolean add(T element) {
//        Если список пустой
        if (firstNode == null) {
            firstNode = new Node<>(element, null, null);
            return true;
        }
//        Если список с одним элементом с в firstNode
        if (lastNode == null) {
            lastNode = new Node<>(element, firstNode, null);
            firstNode.setNextNode(lastNode);
            return true;
        }

        Node<T> newNode = new Node<>(element, lastNode, null);

        lastNode.setNextNode(newNode);
        lastNode = newNode;

        return true;
    }

    public boolean addToStart(T element) {
//        Если список пустой
        if (firstNode == null) {
            firstNode = new Node<>(element, null, null);
            return true;
        }

        if (lastNode == null) {
            lastNode = firstNode;
            lastNode.setNextNode(null);
            firstNode = new Node<>(element, null, lastNode);
            return true;
        }

        Node<T> newNode = new Node<>(element, null, firstNode);

        firstNode.setPreviousNode(newNode);
        firstNode = newNode;

        return true;
    }

    public boolean add(int index, T element) {
//        Выход за границы
        if (index >= this.size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }
//        Если индекс в начале
        if (index == 0) {
            this.addToStart(element);
            return true;
        }
//        Если индекс - последний элемент
        if (index == (size() - 1)) {
            this.add(element);
            return true;
        }
//        Для остальных позиций
        Node<T> priviousNode = getNode(index-1);
        Node<T> nextNode = getNode(index);
        Node<T> newNode = new Node<>(element, getNode(index - 1), getNode(index));

        priviousNode.setNextNode(newNode);
        nextNode.setPreviousNode(newNode);

        return true;
    }

    public int size() {
        if (firstNode == null) {
            return 0;
        }

        if (lastNode == null) {
            return 1;
        }

        if (lastNode.getPreviousNode() == firstNode.getNextNode()) {
            return 2;
        }

        int counter = 1;
        Node<T> tempNode = firstNode;

        while (tempNode.hasNextNode()) {
            ++counter;
            tempNode = tempNode.getNextNode();
        }

        return counter;
    }

    public int indexOf(T element) {
        if (this.size() == 0) {
            return -1;
        }

        if (this.size() == 1) {
            return firstNode.getElement().equals(element) ? 0 : -1;
        }

        Node<T> tempNode = this.firstNode;
        int index = 0;

        if (tempNode.getElement().equals(element)) {
            return index;
        }

        while (tempNode.hasNextNode()) {
            ++index;
            tempNode = tempNode.getNextNode();
            if (tempNode.getElement().equals(element)) {
                return index;
            }
        }

        return -1;
    }

    boolean contains(T element) {
        return this.indexOf(element) != -1;
    }

    T get(int index) {
        if (index >= this.size() || index < 0) {
            return null;
        }

        Node<T> tempNode = this.firstNode;

        if (index == 0) {
            return tempNode.element;
        }

        for (int i = 0; i < index; i++) {
            tempNode = tempNode.getNextNode();
        }

        return tempNode.element;
    }

    private Node<T> getNode(int index) {
        if (index >= this.size() || index < 0) {
            return null;
        }

        Node<T> tempNode = this.firstNode;

        if (index == 0) {
            return tempNode;
        }

        for (int i = 0; i < index; i++) {
            tempNode = tempNode.getNextNode();
        }

        return tempNode;
    }

    @Override
    public String toString() {
        if (firstNode == null) {
            return null;
        }

        if (lastNode == null) {
            return firstNode.getElement().toString();
        }

        StringBuilder stringBuilder = new StringBuilder("[");
        Node<T> tempNode = firstNode;

        while (tempNode.hasNextNode()) {
            stringBuilder.append(tempNode.getElement().toString()).append(" ");
            tempNode = tempNode.getNextNode();
        }

        stringBuilder.append(tempNode.getElement().toString());
        stringBuilder.append("]");

        return stringBuilder.toString();
    }

}





























