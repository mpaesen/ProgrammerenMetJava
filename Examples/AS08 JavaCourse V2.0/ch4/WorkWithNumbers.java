package ch4;
public class WorkWithNumbers {
    private int sum = 0, count = 0;

    public void initWithFor() {
        for (int currNbr = 0; currNbr != -9999; ) {
            currNbr = ReadIntegers.readNextInteger();
            if (currNbr != -9999) {
                sum += currNbr;
                count++;
            }
        }
    }

    public void initWithWhile() {
        int currNbr = 0;
        while (currNbr != -9999) {
            currNbr = ReadIntegers.readNextInteger();
            if (currNbr != -9999) {
                sum += currNbr;
                count++;
            }
        }
    }

    public void initWithDoWhile() {
        int currNbr = 0;
        do {
            currNbr = ReadIntegers.readNextInteger();
            if (currNbr != -9999) {
                sum += currNbr;
                count++;
            }
        } while (currNbr != -9999);
    }

    public static void main(String[] args) {
        WorkWithNumbers number = new WorkWithNumbers();
        //number.initWithFor();
        //number.initWithWhile();
        number.initWithDoWhile();
        System.out.println("total numbers: " + number.getCount());
        System.out.println("total sum: " + number.getSum());
        int average = (number.getCount() == 0 ? 0 : number.getSum() / number.getCount());
        System.out.println("average number: " + average);
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
