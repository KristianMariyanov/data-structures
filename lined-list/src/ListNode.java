public class ListNode<T>{

    public ListNode(T value) {
        this.value = value;
    }

    private T value;

    private ListNode<T> NextNode;

    private ListNode<T> PrevNode;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public ListNode<T> getNextNode() {
        return NextNode;
    }

    public void setNextNode(ListNode<T> nextNode) {
        NextNode = nextNode;
    }

    public ListNode<T> getPrevNode() {
        return PrevNode;
    }

    public void setPrevNode(ListNode<T> prevNode) {
        PrevNode = prevNode;
    }
}
