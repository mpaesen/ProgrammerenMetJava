public class TestOurString
{
    private String sentence;

    public TestOurString(String sentence) throws BadInputException
    {
        if (sentence == null)
          throw new BadInputException("Passed null to constructor");
        else
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
        try
        {
          sentence = OurString.convert(sentence, from, to, startPos);
          System.out.println("Output string : '" + sentence + "'");
        }
        catch (BadLengthException exc)
        {
           System.out.println(exc.getMessage());
           System.out.println("from = " + from + ", to = " + to);
           exc.printStackTrace();
        }
        catch (BadStartPositionException exc)
        {
           System.out.println(exc.getMessage());
           exc.printStackTrace();
        }
        System.out.println();
        return sentence;
    }

    public static void main(String args[])
    {
        //            "012345678901234567890";
        try
        {
          //TestOurString me = new TestOurString("ABCB is for Jou!");
          TestOurString me = new TestOurString(null);
          String from = "ABC";
          String to   = "JAV";
          me.convertSentence(from, to);
          from = "J";
          to   = "Y";
          me.convertSentence(from, to, 12);
        }
        catch (BadInputException exc)
        {
          System.out.println("Not instantiated");
        }
        finally
        {
          System.out.println("Inside finally...");
        }
    }
}

