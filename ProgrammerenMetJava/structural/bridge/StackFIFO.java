class StackFIFO extends StackArray {
    private final StackArray stackArray = new StackArray();
    public int pop() {
        while (!isEmpty()) {
            stackArray.push(super.pop());
        }
        int ret = stackArray.pop();
        while (!stackArray.isEmpty()) {
            push(stackArray.pop());
        }
        return ret;
    }
}