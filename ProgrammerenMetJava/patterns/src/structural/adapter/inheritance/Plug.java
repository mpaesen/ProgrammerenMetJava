package structural.adapter.inheritance;

/**
 * The input for the plug is 5 AMP. which is a mismatch for a 15 AMP socket.
 * The Plug is the client. We need to cater to the requirements of the Plug.
 */
public class Plug {
    private String specification = "5 AMP";

    public String getInput() {
        return specification;
    }

}// End of class