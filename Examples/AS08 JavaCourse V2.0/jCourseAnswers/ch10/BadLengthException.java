public class BadLengthException extends BadInputException
{
    public BadLengthException()
    {
        super("Inconsistent lengths");
    }
}