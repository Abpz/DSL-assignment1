package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.metamodel.Machine;
import main.metamodel.State;
import main.metamodel.Transition;

public class StateMachine {

	private List<State> states;
	private Map<String, Integer> integers;
	private State initialState;
	private State state;
	private Map<Transition, String> transitions;
	private Transition transition;

	public StateMachine() {
		this.states = new ArrayList<>();
		this.integers = new HashMap<>();
		this.transitions = new HashMap<>();
	}

	public Machine build() {
		for (Map.Entry<Transition, String> transition: transitions.entrySet()) {
			String targetName = transition.getValue();

			for (State state: states) {
				if (targetName.equals(state.getName())) {
					transition.getKey().setTarget(state);
				}
			}
		}

		return new Machine(states, initialState, integers);
	}

	public StateMachine state(String string) {
		state = new State(string);
		states.add(state);
		return this;
	}

	public StateMachine initial() {
		initialState = state;
		return this;
	}

	public StateMachine when(String string) {
		transition = new Transition(string);
		state.addTransition(transition);
		return this;
	}

	public StateMachine to(String string) {
		transitions.put(transition, string);
		return this;
	}

	public StateMachine integer(String string) {
		integers.put(string, 0);
		return this;
	}

	public StateMachine set(String string, int i) {
		transition.setOperation(string, i);
		return this;
	}

	public StateMachine increment(String string) {
		transition.incrementOperation(string);
		return this;
	}

	public StateMachine decrement(String string) {
		transition.decrementOperation(string);
		return this;
	}

	public StateMachine ifEquals(String string, int i) {
		transition.setConditionalEqual(string, i);
		return this;
	}

	public StateMachine ifGreaterThan(String string, int i) {
		transition.setConditionalGreaterThan(string, i);
		return this;
	}

	public StateMachine ifLessThan(String string, int i) {
		transition.setConditionalLessThan(string, i);
		return this;
	}

}
