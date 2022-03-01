package main.metamodel;

import java.util.List;
import java.util.Map;

public class Machine {

	private List<State> states;
	private State initialState;
	private Map<String, Integer> integers;

	public Machine(List<State> states, State initialState, Map<String, Integer> integers) {
		this.states = states;
		this.initialState = initialState;
		this.integers = integers;
	}

	public List<State> getStates() {
		return states;
	}

	public State getInitialState() {
		return initialState;
	}

	public Map<String, Integer> getIntegers() {
		return integers;
	}

	public State getState(String string) {
		for (State state: states) {
			if (string.equals(state.getName())) {
				return state;
			}
		}
		return null;
	}

	public int numberOfIntegers() {
		return integers.size();
	}

	public boolean hasInteger(String string) {
		return integers.containsKey(string);
	}

}
