package ch13.dates;

import java.util.Date;

public final class DatFmt extends ComFmt {
    public static final int DATFMT_MDY = 0;
    public static final int DATFMT_DMY = 1;
    public static final int DATFMT_YMD = 2;
    public static final int DATFMT_JUL = 3;
    public static final int DATFMT_USA = 4;
    public static final int DATFMT_EUR = 5;
    public static final int DATFMT_ISO = 6;
    public static final int DATFMT_JIS = 7;
    private String formats[] = {
      "MM/dd/yy",   "dd/MM/yy",   "yy/MM/dd",   "yy/DDD",
      "MM/dd/yyyy", "dd/MM/yyyy", "yyyy/MM/dd", "yyyy/MM/dd"};
    private char defaultSeparators[] = {
      '/', '/', '/', '/', '/', '.', '-', '-'};

    /** Return to parent class our formats instance variable */
    protected String[] getFormats() {
        return formats;
    }

    /** Return to parent class our defaultSeparators instance variable */
    protected char[] getDefaultSeparators() {
        return defaultSeparators;
    }

    /** default constructor. Take all defaults */
    public DatFmt() {
        super();
        format = DATFMT_ISO;
    }

    /**
     *  Constructor that takes both a format and a separator
     *  @param format - one of the public int constants defined in this class
     *  @param separator - character to use for the separator
     */
    public DatFmt(int format, char separator) {
        super(format, separator);
    }

    /**
     *  Constructor that takes only a format, and uses default separator
     *  @param format - one of the public int constants defined in this class
     */
    public DatFmt(int format) {
        super(format);
    }

    /** main method to test this class */
    public static void main(String args[]) {
        DatFmt me = new DatFmt();
        Date date = new Date();
        System.out.println(me.format(date));
        System.out.println();
        for (int idx = DatFmt.DATFMT_MDY; idx <= DatFmt.DATFMT_JIS; idx++) {
            me.setFormat(idx);
            System.out.println(me.format(date));
        }
        System.out.println();
        for (int idx = DatFmt.DATFMT_MDY; idx <= DatFmt.DATFMT_JIS; idx++) {
            me.setFormat(idx);
            me.setSeparator('.');
            System.out.println(me.format(date));
        }
    }
} // end DatFmt class
