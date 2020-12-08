import java.util.Random;
public class BridgeDisc {
    public static void main(String[] args) {
        StackArray[] stacks = {new StackArray(), new StackFIFO(), new StackHanoi()};
        StackList stackList = new StackList();
        for (int i = 1, num; i < 15; i++) {
            stacks[0].push(i);
            stackList.push(i);
            stacks[1].push(i);
        }
        Random rn = new Random();
        for (int i = 1, num; i < 15; i++) {
            stacks[2].push(rn.nextInt(20));
        }
        while (!stacks[0].isEmpty()) {
            System.out.print(stacks[0].pop() + "  ");
        }
        System.out.println();
        while (!stackList.isEmpty()) {
            System.out.print(stackList.pop() + "  ");
        }
        System.out.println();
        while (!stacks[1].isEmpty()) {
            System.out.print(stacks[1].pop() + "  ");
        }
        System.out.println();
        while (!stacks[2].isEmpty()) {
            System.out.print(stacks[2].pop() + "  ");
        }
        System.out.println();
        System.out.println("total rejected is "
                + ((StackHanoi) stacks[2]).reportRejected());
    }
}