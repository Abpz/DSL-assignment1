package main;

import main.metamodel.Machine;
import main.metamodel.State;
import main.metamodel.Transition;

public class MachineInterpreter {

	private Machine machine;
	private State currentState;

	public void run(Machine m) {
		machine = m;
		currentState = machine.getInitialState();
	}

	public State getCurrentState() {
		return currentState;
	}

	public void processEvent(String string) {
		for (Transition transition: currentState.getTransitions()) {
			if (string.equals(transition.getEvent())) {
				if (processCondition(transition)) {
					processOperation(transition);
					currentState = transition.getTarget();
					return;
				}
			}
		}
	}

	private boolean processCondition(Transition transition) {
		if (transition.isConditional()) {
			String variableName = transition.getConditionVariableName();
			int variableValue = transition.getConditionComparedValue();

			if (transition.isConditionEqual()) {
				return getInteger(variableName) == variableValue;
			} else if (transition.isConditionGreaterThan()) {
				return getInteger(variableName) > variableValue;
			} else if (transition.isConditionLessThan()) {
				return getInteger(variableName) < variableValue;
			} else {
				return false;
			}
		}

		return true;
	}

	private void processOperation(Transition transition) {
		if (transition.hasOperation()) {
			String varName = transition.getOperationVariableName();
			int varValue = transition.getOperationVariableValue();
			int currentVal = getInteger(transition.getOperationVariableName());

			if (transition.hasSetOperation()) {
				machine.getIntegers().put(varName, varValue);
			} else if (transition.hasIncrementOperation()) {
				machine.getIntegers().put(varName, ++currentVal);
			} else if (transition.hasDecrementOperation()) {
				machine.getIntegers().put(varName, --currentVal);
			}
		}
	}

	public int getInteger(String string) {
		return machine.getIntegers().get(string);
	}

}
