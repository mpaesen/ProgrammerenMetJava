/**
 *
 */
package model;

/**
 * @author mpaesen
 */
public class Rekening {
    private static int current = 0;
    private final String rekening;
    private int beginBalans;
    private int stortingen;
    private int totaalToegekendKrediet;
    private int kredietLimiet;

    /**
     * @param beginBalans
     * @param stortingen
     * @param totaalToegekendKrediet
     * @param kredietLimiet
     */
    public Rekening(final int beginBalans, final int stortingen, final int totaalToegekendKrediet, final int kredietLimiet) {
        super();
        current++;
        this.rekening = "Rekening: " + String.valueOf(current);
        this.beginBalans = beginBalans;
        this.stortingen = stortingen;
        this.totaalToegekendKrediet = totaalToegekendKrediet;
        this.kredietLimiet = kredietLimiet;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Rekening [rekening=" + rekening + "\n beginBalans=" + beginBalans +
                "\n stortingen=" + stortingen + "\n totaalToegekendKrediet=" + totaalToegekendKrediet +
                "\n kredietLimiet=" + kredietLimiet + "]";
    }

    /**
     * @return the rekening
     */
    public String getRekening() {
        return rekening;
    }

    /**
     * @return the beginBalans
     */
    public int getBeginBalans() {
        return beginBalans;
    }

    /**
     * @param beginBalans the beginBalans to set
     */
    public void setBeginBalans(final int beginBalans) {
        this.beginBalans = beginBalans;
    }

    /**
     * @return the stortingen
     */
    public int getStortingen() {
        return stortingen;
    }

    /**
     * @param stortingen the stortingen to set
     */
    public void setStortingen(final int stortingen) {
        this.stortingen = stortingen;
    }

    /**
     * @return the totaalToegekendKrediet
     */
    public int getTotaalToegekendKrediet() {
        return totaalToegekendKrediet;
    }

    /**
     * @param totaalToegekendKrediet the totaalToegekendKrediet to set
     */
    public void setTotaalToegekendKrediet(final int totaalToegekendKrediet) {
        this.totaalToegekendKrediet = totaalToegekendKrediet;
    }

    /**
     * @return the kredietLimiet
     */
    public int getKredietLimiet() {
        return kredietLimiet;
    }

    /**
     * @param kredietLimiet the kredietLimiet to set
     */
    public void setKredietLimiet(final int kredietLimiet) {
        this.kredietLimiet = kredietLimiet;
    }

    public String kredietStatus() {
        return "Credit Limiet overschreden!";
    }

    public int getNieuweBalans() {
        return getBeginBalans() + getStortingen() - getTotaalToegekendKrediet();
    }

    private boolean isKredietOverschreven() {
        return getNieuweBalans() > getKredietLimiet();
    }

    public String getCurrentStatus() {
        if (this.isKredietOverschreven()) {
            return this.toString() + "\n" + this.kredietStatus();
        }
        return this.toString();
    }
}
