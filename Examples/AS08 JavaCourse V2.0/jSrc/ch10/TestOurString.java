public class TestOurString
{
    private String sentence;

    public TestOurString(String sentence)
    {
        this.sentence = sentence;
    }

    public String convertSentence(String from, String to)
    {
        return convertSentence(from, to, 0);
    }

    public String convertSentence(String from, String to, int startPos)
    {
        System.out.println();
        System.out.println("Input string  : '" + sentence + "'");
        sentence = OurString.convert(sentence, from, to, startPos);
        System.out.println("Output string : '" + sentence + "'");
        System.out.println();
        return sentence;
    }

    public static void main(String args[])
    {
        //            "012345678901234567890";
        TestOurString me = new TestOurString("ABCB is for Jou!");
        String from = "ABC";
        String to   = "JAV";
        me.convertSentence(from, to);
        from = "J";
        to   = "Y";
        me.convertSentence(from, to, 12);
    }
}