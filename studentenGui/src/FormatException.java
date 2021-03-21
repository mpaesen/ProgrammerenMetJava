public class FormatException extends Exception{
    @Override
    public String getMessage(){
        return "Het SSN moet uit zes tekens bestaan";
    }
}
