package Stack.baitap;

import java.util.*;

class Node<T> {
    private T data;
    private Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public Node<T> getNext() {
        return next;
    }
}


class Stack<T> {
    private Node<T> top;

    public Stack() {
        this.top = null;
    }

    public boolean isEmpty() {
        return this.top == null;
    }

    public void push(T data) {
        Node<T> temp = (Node<T>) new Node<>(data);
        temp.setNext(top); // temp.next = top;
        top = temp;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty!");
        }
        T data = (T) top.getData();
        top = top.getNext(); // top = top.next;
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty!");
        }
        return (T) top.getData();
    }

    public T sumOfElements() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty!");
        }
        Integer sum = new Integer(0);
        Node<T> current = top;
        while (current != null) {
            sum += Integer.parseInt(current.getData().toString());
            current = current.getNext();
        }
        return (T) sum;
    }

    public boolean search(T data) {
        Node<T> temp = top;
        while (temp != null) {
            if (temp.getData().equals(data))
                return true;
            temp = temp.getNext();
        }
        return false;
    }

    public void display() {
        Node<T> temp = top;
        while (temp != null) {
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }
        System.out.println();
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Stack<Integer> myStack = new Stack<>();
        while(true) {
            System.out.println("______________ Menu ______________");
            System.out.println("1. Them gia tri vao Stack");
            System.out.println("2. Xoa gia tri khoi Stack");
            System.out.println("3. Kiem tra rong");
            System.out.println("4. Tong cac gia tri trong Stack");
            System.out.println("5. Tim kiem gia tri trong Stack");
            System.out.println("6. Xuat danh sach Stack");
            System.out.println("7. Ket Thuc Chuong Trinh");
            System.out.println("__________________________________\n");
            System.out.print("=> Nhap lua chon: ");
            int lc = input.nextInt();
            switch (lc) {
                case 1: {
                    System.out.print("Them gia tri: ");
                    int value = input.nextInt();
                    myStack.push(value);
                    System.out.println("Da them gia tri " + value + " vao Stack !");
                    break;
                }
                case 2: {
                    myStack.pop();
                    System.out.print("Xoa thanh cong gia tri dau khoi Stack");
                    break;
                }
                case 3: {
                    if (myStack.isEmpty()){
                        System.out.println("Stack rong: true");
                    } else {
                        System.out.println("Stack khong rong: flase");
                    }
                    break;
                }
                case 4: {
                    System.out.println("Tong cac gia tri trong Stack: " + myStack.sumOfElements());
                    break;
                }
                case 5: {
                    System.out.print("Tim kiem gia tri: ");
                    int value = input.nextInt();
                    if (myStack.search(value)) {
                        System.out.println("Gia tri " + value + " ton tai trong Stack !");
                    } else {
                        System.out.println("Gia tri " + value + " khong ton tai trong Stack !");
                    }
                    break;
                }
                case 6: {
                    System.out.print("\nXuat danh sach Stack: ");
                    myStack.display();
                    break;
                }
                case 7:
                    System.out.print("Ket thuc chuong trinh !!!");
                    return;
                default:
                    System.out.println("=> Nhap lai chua chon !!!\n");
                    break;
            }
        }
    }
}
