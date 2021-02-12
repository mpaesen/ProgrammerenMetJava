package behavioral.state.example;

public class RequestedState implements State {
    public void grantPermission(StateContext ctx) {
        System.out.println("Granting Permission");
        ctx.setState(ctx.getGrantedState());
    }

    public void requestPermission(StateContext ctx) {
        System.out.println("Permission already requested");
    }

    public String getStatus() {
        return "Requested permission";
    }
}