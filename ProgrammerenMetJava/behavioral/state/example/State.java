package behavioral.state.example;

public interface State {
	 public void grantPermission(StateContext ctx);
	 public void requestPermission(StateContext ctx);
	 public String getStatus();
	}