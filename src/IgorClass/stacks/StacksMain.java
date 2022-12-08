package IgorClass.stacks;

public class StacksMain {

    public static void main(String[] args) {
        int[] data = {5, 3, 15, 4, 2, 12, 10, 4};
        Stack2 stack2 = new Stack2(10,data);
        stack2.printStack();
        System.out.println(stack2.top());
        System.out.println(stack2.pop());
        System.out.println(stack2.top());

        Stack stack = new Stack(data, 10);
        stack2.printStack();
        stack.printStack();

    }

}
