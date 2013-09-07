package behavioral.state.example;

public class StateContext {
	private State acceptedState;
	private State requestedState;
	private State grantedState;

	private State state;

	public StateContext() {
		acceptedState = new AcceptedState();
		requestedState = new RequestedState();
		grantedState = new GrantedState();
		state = null;
	}

	public void acceptApplication() {
		this.state = acceptedState;
	}

	public void requestPermission() {
		state.requestPermission(this);
	}

	public void grantPermission() {
		state.grantPermission(this);
	}

	public String getStatus() {
		return state.getStatus();
	}

	public void setState(State state) {
		this.state = state;
	}

	public State getAcceptedState() {
		return acceptedState;
	}

	public State getGrantedState() {
		return grantedState;
	}

	public State getRequestedState() {
		return requestedState;
	}

}