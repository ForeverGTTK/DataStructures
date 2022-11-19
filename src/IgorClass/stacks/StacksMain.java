package IgorClass.stacks;

public class StacksMain {

    public static void main(String[] args) {
        int[] array = {1,5,7,9};
        Stack2 stack2 = new Stack2(10,array);
        System.out.println(stack2.top());
        System.out.println(stack2.pop());
        System.out.println(stack2.top());

        int[] data = {5, 3, 15, 4, 2, 12, 10, 4};
        Stack stack = new Stack(data, 10);
        stack.printStack();
        stack.printStack();

    }

}
