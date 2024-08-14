public class CustomArrayList {

    public interface ListInterface {
        void createList(int n);
        void insertFirst(Object ob);
        void insertAfter(Object item, Object pos);
        Object deleteFirst();
        Object deleteAfter(Object pos);
        boolean isEmpty();
        int size();
    }

    static class Node {
        Object data;
        int next;

        Node(Object ob, int i) {
            data = ob;
            next = i;
        }
    }

    int MAXSIZE;
    Node[] list;
    int head, count;

    public CustomArrayList(int s) {
        MAXSIZE = s;
        list = new Node[MAXSIZE];
        head = -1;
        count = 0;
    }

    public void initializeList() {
        for (int p = 0; p < MAXSIZE - 1; p++) {
            list[p] = new Node(null, p + 1);
        }
        list[MAXSIZE - 1] = new Node(null, -1);
    }

    public void createList(int n) {
        if (n > MAXSIZE) {
            System.out.println("*Cannot create more nodes than MAXSIZE");
            return;
        }

        for (int p = 0; p < n; p++) {
            list[p] = new Node(11 + 11 * p, p + 1);
            count++;
        }
        list[n - 1].next = -1;
        head = 0;
    }

    public void insertFirst(Object item) {
        if (count == MAXSIZE) {
            System.out.println("*List is FULL");
            return;
        }
        int p = getNode();
        if (p != -1) {
            list[p].data = item;
            list[p].next = head;
            head = p;
            count++;
        }
    }

    public void insertAfter(Object item, Object x) {
        if (count == MAXSIZE) {
            System.out.println("*List is FULL");
            return;
        }

        int q = getNode();
        int p = find(x);

        if (p == -1) {
            System.out.println("*Element " + x + " not found in the list");
            return;
        }

        if (q != -1) {
            list[q].data = item;
            list[q].next = list[p].next;
            list[p].next = q;
            count++;
        }
    }

    public int getNode() {
        for (int p = 0; p < MAXSIZE; p++) {
            if (list[p] != null && list[p].data == null) {
                return p;
            }
        }
        return -1;
    }

    public int find(Object ob) {
        int p = head;
        while (p != -1) {
            if (list[p] != null && list[p].data.equals(ob)) {
                return p;
            }
            p = list[p].next;
        }
        return -1;
    }

    public Object deleteFirst() {
        if (isEmpty()) {
            System.out.println("List is empty: no deletion");
            return null;
        }
        Object tmp = list[head].data;
        head = list[head].next;
        count--;
        return tmp;
    }

    public Object deleteAfter(Object x) {
        int p = find(x);
        if (p == -1 || list[p].next == -1) {
            System.out.println("No deletion");
            return null;
        }
        int q = list[p].next;
        Object tmp = list[q].data;
        list[p].next = list[q].next;
        count--;
        return tmp;
    }

    public void display() {
        int p = head;
        if (isEmpty()) {
            System.out.println("\nList is empty.");
            return;
        }

        System.out.print("\nList: [ ");
        while (p != -1) {
            System.out.print(list[p].data + " ");
            p = list[p].next;
        }
        System.out.println("]");
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public static void main(String[] args) {
        CustomArrayList linkedList = new CustomArrayList(10);

        linkedList.initializeList();
        linkedList.createList(4);
        linkedList.display();

        System.out.print("InsertFirst 55: ");
        linkedList.insertFirst(55);
        linkedList.display();

        System.out.print("Insert 66 after 33: ");
        linkedList.insertAfter(66, 33);
        linkedList.display();

        Object item = linkedList.deleteFirst();
        System.out.println("Deleted node: " + item);
        linkedList.display();

        System.out.println("InsertFirst 77: ");
        linkedList.insertFirst(77);
        linkedList.display();

        item = linkedList.deleteAfter(33);
        System.out.println("Deleted node: " + item);
        linkedList.display();

        System.out.println("size(): " + linkedList.size());
    }
}
