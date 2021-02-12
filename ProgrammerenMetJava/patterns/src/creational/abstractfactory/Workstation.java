package creational.abstractfactory;

public class Workstation extends Computer {
    /**
     * Method over-ridden from Computer,
     * returns the Parts ideal for Server
     *
     * @return Parts
     */
    public Parts getRAM() {
        return new Parts("1 GB");
    }

    /**
     * Method over-ridden from Computer,
     * returns the Parts ideal for Workstation
     *
     * @return Parts
     */
    public Parts getProcessor() {
        return new Parts("Intel P 3");
    }

    /**
     * Method over-ridden from Computer,
     * returns the Parts ideal for PC
     *
     * @return Parts
     */
    public Parts getMonitor() {
        return new Parts("19 inches");
    }
}// End of class