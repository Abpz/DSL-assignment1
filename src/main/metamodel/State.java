package main.metamodel;

import java.util.ArrayList;
import java.util.List;

public class State {

	private String name;
	private List<Transition> transitions;

	public State(String name) {
		this.name = name;
		this.transitions = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public List<Transition> getTransitions() {
		return transitions;
	}

	public Transition getTransitionByEvent(String string) {
		for (Transition transition : transitions) {
			if (string.equals(transition.getEvent())) {
				return transition;
			}
		}
		return null;
	}

	public void addTransition(Transition transition) {
		transitions.add(transition);
	}

}
