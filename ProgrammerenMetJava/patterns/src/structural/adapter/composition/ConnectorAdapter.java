package structural.adapter.composition;

/**
 * Using composition
 */
public class ConnectorAdapter {
    Plug5AMP plug5;

    public ConnectorAdapter(Plug5AMP plug) {
        this.plug5 = plug;
    }

    public static void main(String[] args) {
        // Taking output from the Socket
        Socket socket = new Socket();
        String outputFromSocket = socket.getOutput();

        // Giving away input to the Plug
        ConnectorAdapter adapter = new ConnectorAdapter(new Plug5AMP());
        String inputToPlug = adapter.getAdapterOutput(outputFromSocket);
        System.out.println("New output by adapter is: " + inputToPlug);
    }

    public String getAdapterOutput(String outputFromScoket) {
        /*
         * if output is same, return
         */
        if (outputFromScoket.equals(plug5.getInput())) {
            return outputFromScoket;
        }
        /*
         * Else, override the value by adapterOutput
         */
        else {
            String adapterOutput = plug5.getInput();
            return adapterOutput;
        }
    }
}// End of class