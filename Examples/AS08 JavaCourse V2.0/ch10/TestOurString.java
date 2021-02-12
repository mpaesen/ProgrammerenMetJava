package ch10;

public class TestOurString
{
    private String sentence;

    public TestOurString(String sentence) throws BadInputException
    {
       if(sentence != null)
        this.sentence = sentence;
       else
          throw new BadInputException("Passed null in constructor");
    }

    public String convertSentence(String from, String to)
    {
        return convertSentence(from, to, 0);
    }

    public String convertSentence(String from, String to, int startPos)
    {
        System.out.println();
        System.out.println("Input string  : '" + sentence + "'");
        try{
            sentence = OurString.convert(sentence, from, to, startPos);
            System.out.println("Output string : '" + sentence + "'");
        }
         catch (BadLengthException e){
               System.out.println(e.getMessage());
               e.printStackTrace();
        }
         catch (BadStartPositionException e){
               System.out.println(e.getMessage());
               e.printStackTrace();
        }
         catch (BadInputException e){
               System.out.println(e.getMessage());
               e.printStackTrace();
        }

             System.out.println();
        return sentence;
    }

    public static void main(String args[])
    {
        //            "012345678901234567890";
        try{
           TestOurString me = new TestOurString("ABCB is for Jou!");
           String from = "ABC";
           String to   = "JAV";
           me.convertSentence(from, to);
           from = "J";
           to   = "Y";
           me.convertSentence(from, to, 12);
         }
         catch (BadInputException e){
               System.out.println("Not instantiated");
               e.printStackTrace();
        }
      finally
         {
               System.out.println("Inside finally");
            }
    }
}