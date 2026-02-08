package Lab1;
import java.util.*;

public class FiniteAutomaton {
    private Set<String> states;
    private String startState;
    private String finalState;
    private Map<String, Map<Character, String>> transitions;

    public FiniteAutomaton(Set<String> states, String startState, String finalState, Map<String, Map<Character, String>> transitions) {
        this.states = states;
        this.startState = startState;
        this.finalState = finalState;
        this.transitions = transitions;
    }

    public boolean stringBelongToLanguage(String inputString) {
        String currentState = startState;

        for (char c : inputString.toCharArray()) {
            if (!transitions.containsKey(currentState)) {
                return false;
            }

            Map<Character, String> stateTransitions = transitions.get(currentState);
            if (!stateTransitions.containsKey(c)) {
                return false; 
            }

            currentState = stateTransitions.get(c);
        }

        return currentState.equals(finalState);
    }
}