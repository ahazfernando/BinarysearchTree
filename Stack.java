package Stack;

import Node.MorseNode;
import java.util.ArrayList;

public class Stack {
    private ArrayList<MorseNode> stack;

    public Stack() {
        stack = new ArrayList<>();
    }

    public void stack_push(MorseNode node) {
        stack.add(node);
    }

    public MorseNode stack_pop() {
        if (!empty()) {
            return stack.remove(stack.size() - 1);
        }
        return null;
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}
