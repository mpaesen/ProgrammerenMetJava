/** Helper methods for Strings */
public class OurString
{
    /**
     * Method for converting characters in a given string.
     * @param source string to convert
     * @param characters to convert in source string
     * @param characters to convert to, matching one-to-one the convert from characters
     * @param starting position (zero-based)
     * @return new string with given from-characters converted to given to-characters,
     *         from the given starting position
     */
    public static String convert(String source,  String fromChars,
                                 String toChars, int    start)
    {
        String resultString;
        // minimal input error checking
        if (fromChars.length() != toChars.length())
          return new String("BAD INPUT!");
        if (start > source.length() || start < 0)
          return new String("BAD INPUT!");
        // first off, get the substring to be xlated...
        resultString = source.substring(start);
        // now, xlate each char in fromChars to same pos in toChars
        for (int i = 0; i < fromChars.length(); i++)
           resultString = resultString.replace(fromChars.charAt(i),
                                               toChars.charAt(i));
        // now append xlated part to non-xlated part
        resultString = source.substring(0,start) + resultString;
        return resultString;
    } // end convert method

    /**
     * Method for converting characters in a given string.
     * @param source string to convert
     * @param characters to convert in source string
     * @param characters to convert to, matching one-to-one the convert from characters
     * @return new string with given from-characters converted to given to-characters
     */
    public static String convert(String source,  String fromChars,
                                 String toChars)
    {
        return convert(source, fromChars, toChars, 0);
    } // end convert method two

} // end OurString class

