import java.util.Stack;

public class Problem9 {

    public static void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty()) return;
        int top = stack.pop();
        sortStack(stack);
        sortStack(stack, top);
    }

    public static void sortStack(Stack<Integer> stack, int val) {
        if (stack.isEmpty() || stack.peek() >= val) {
            stack.push(val);
            return;
        }
        int top = stack.pop();
        sortStack(stack, val);
        stack.push(top);
    }
}
