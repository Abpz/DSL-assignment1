package main.metamodel;

public class Transition {

	private String event;
	private State target;

	private String operationVariableName;
	private int operationVariableValue;

	private boolean hasSetOperation = false;
	private boolean hasIncrementOperation = false;
	private boolean hasDecrementOperation = false;

	private String conditionalVariableName;
	private int conditionalComparedValue;

	private boolean isEqual = false;
	private boolean isGreaterThan = false;
	private boolean isLessThan = false;

	public Transition(String event) {
		this.event = event;
	}

	public String getEvent() {
		return event;
	}

	public void setTarget(State target) {
		this.target = target;
	}

	public State getTarget() {
		return target;
	}

	public void setOperation(String string, int i) {
		hasSetOperation = true;
		operationVariableValue = i;
		operationVariableName = string;
	}

	public boolean hasSetOperation() {
		return hasSetOperation;
	}

	public void incrementOperation(String string) {
		hasIncrementOperation = true;
		operationVariableName = string;
	}

	public boolean hasIncrementOperation() {
		return hasIncrementOperation;
	}

	public void decrementOperation(String string) {
		hasDecrementOperation = true;
		operationVariableName = string;
	}

	public boolean hasDecrementOperation() {
		return hasDecrementOperation;
	}

	public boolean hasOperation() {
		return hasSetOperation() || hasIncrementOperation() || hasDecrementOperation();
	}

	public boolean isConditional() {
		return isConditionEqual() || isConditionGreaterThan() || isConditionLessThan();
	}

	public void setConditionalEqual(String string, int i) {
		isEqual = true;
		conditionalComparedValue = i;
		conditionalVariableName = string;
	}

	public boolean isConditionEqual() {
		return isEqual;
	}

	public void setConditionalGreaterThan(String string, int i) {
		isGreaterThan = true;
		conditionalComparedValue = i;
		conditionalVariableName = string;
	}

	public boolean isConditionGreaterThan() {
		return isGreaterThan;
	}

	public void setConditionalLessThan(String string, int i) {
		isLessThan = true;
		conditionalComparedValue = i;
		conditionalVariableName = string;
	}

	public boolean isConditionLessThan() {
		return isLessThan;
	}

	public String getOperationVariableName() {
		return operationVariableName;
	}

	public int getOperationVariableValue() {
		return operationVariableValue;
	}

	public String getConditionVariableName() {
		return conditionalVariableName;
	}

	public Integer getConditionComparedValue() {
		return conditionalComparedValue;
	}

}
