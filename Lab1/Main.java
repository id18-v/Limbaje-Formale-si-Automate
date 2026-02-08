package Lab1;
public class Main {
    public static void main(String[] args) {
        Grammar grammar = new Grammar();
        FiniteAutomaton automaton = grammar.toFiniteAutomaton();
        for (int i = 0; i < 5; i++) {
            String word = grammar.generateString(); 
            boolean isValid = automaton.stringBelongToLanguage(word);    
            System.out.println("Cuvant generat: " + word);
            System.out.println("Este valid conform Automatului? " + (isValid ? "DA" : "NU"));
        }

        String badWord = "aaabbb";
        System.out.println("Test cuvant invalid manual ('" + badWord + "'): " + 
                           automaton.stringBelongToLanguage(badWord));
    }
}