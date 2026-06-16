package ClonedBasic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static ClonedBasic.TokenType.*;
import static org.junit.Assert.assertEquals;


public class ScannerTest {

    private final String PRINT_HELLO_WORLD = "PRINT \"HELLO WORLD\"";
    private final String PRINT_NUMBERS = "PRINT 1,2,3,4,5";
    private final String DIM_INTEGER = "DIM a as INTEGER";
    private final String INIT_INTEGER = "number = 12";
    private final String DIM_INTEGER_ARRAY = "DIM myArray(10) as INTEGER";
    private final String INPUT_WITH_SEMICOLON = "INPUT \"What is your name\"; name$";
    private final String INPUT_WITHOUT_SEMICOLON = "INPUT \"What is your age\", age";
    private final String ADDITION = "e = a + b";
    private final String SUBTRACTION = "e = a - b";
    private final String MULTIPLICATION = "e = a * b";
    private final String DIVISION = "e = a / b";
    private final String CLEAR_SCREEN = "CLS";
    private Scanner scanner;

    @Test
    public void testPrintHelloWorld_HappyPath() {
        List<Token> expectedTokens = new ArrayList<>();
        expectedTokens.add(new Token(PRINT, "PRINT", null, 1));
        expectedTokens.add(new Token(STRING, "\"HELLO WORLD\"", "HELLO WORLD", 1));
        expectedTokens.add(new Token(EOF, "", null, 1));

        scanner = new Scanner(PRINT_HELLO_WORLD);
        assertTokens(expectedTokens, scanner.scanTokens());
    }

    @Test
    public void testPrintNumbers_HappyPath() {
        List<Token> expectedTokens = new ArrayList<>();

        expectedTokens.add(new Token(PRINT, "PRINT", null, 1));
        expectedTokens.add(new Token(NUMBER, "1", 1.0, 1));
        expectedTokens.add(new Token(COMMA, ",", null, 1));
        expectedTokens.add(new Token(NUMBER, "2", 2.0, 1));
        expectedTokens.add(new Token(COMMA, ",", null, 1));
        expectedTokens.add(new Token(NUMBER, "3", 3.0, 1));
        expectedTokens.add(new Token(COMMA, ",", null, 1));
        expectedTokens.add(new Token(NUMBER, "4", 4.0, 1));
        expectedTokens.add(new Token(COMMA, ",", null, 1));
        expectedTokens.add(new Token(NUMBER, "5", 5.0, 1));
        expectedTokens.add(new Token(EOF, "", null, 1));

        scanner = new Scanner(PRINT_NUMBERS);
        assertTokens(expectedTokens, scanner.scanTokens());
    }

    @Test
    public void testClearScreen_HappyPath() {
        List<Token> expectedTokens = new ArrayList<>();
        expectedTokens.add(new Token(CLS, "CLS", null, 1));
        expectedTokens.add(new Token(EOF, "", null, 1));

        scanner = new Scanner(CLEAR_SCREEN);
        assertTokens(expectedTokens, scanner.scanTokens());
    }

    @Test
    public void testDimInteger_HappyPath() {
        List<Token> expectedTokens = new ArrayList<>();

        expectedTokens.add(new Token(DIM, "DIM", null, 1));
        expectedTokens.add(new Token(IDENTIFIER, "a", null, 1));
        expectedTokens.add(new Token(AS, "as", null, 1));
        expectedTokens.add(new Token(INTEGER_TYPE, "INTEGER", null, 1));
        expectedTokens.add(new Token(EOF, "", null, 1));


        scanner = new Scanner(DIM_INTEGER);
        assertTokens(expectedTokens, scanner.scanTokens());
    }

    @Test
    public void testInitInteger_HappyPath() {
        List<Token> expectedTokens = new ArrayList<>();

        expectedTokens.add(new Token(IDENTIFIER, "number", null, 1));
        expectedTokens.add(new Token(EQUAL, "=", null, 1));
        expectedTokens.add(new Token(NUMBER, "12", 12.0, 1));
        expectedTokens.add(new Token(EOF, "", null, 1));


        scanner = new Scanner(INIT_INTEGER);
        assertTokens(expectedTokens, scanner.scanTokens());
    }

    @Test
    public void testDimIntegerArray_HappyPath() {
        List<Token> expectedTokens = new ArrayList<>();

        expectedTokens.add(new Token(DIM, "DIM", null, 1));
        expectedTokens.add(new Token(IDENTIFIER, "myArray", null, 1));
        expectedTokens.add(new Token(LEFT_PARENTHESIS, "(", null, 1));
        expectedTokens.add(new Token(NUMBER, "10", 10.0, 1));
        expectedTokens.add(new Token(RIGHT_PARENTHESIS, ")", null, 1));
        expectedTokens.add(new Token(AS, "as", null, 1));
        expectedTokens.add(new Token(INTEGER_TYPE, "INTEGER", null, 1));
        expectedTokens.add(new Token(EOF, "", null, 1));


        scanner = new Scanner(DIM_INTEGER_ARRAY);
        assertTokens(expectedTokens, scanner.scanTokens());
    }

    @Test
    public void testAddition_HappyPath() {
        List<Token> expectedTokens = new ArrayList<>();

        expectedTokens.add(new Token(IDENTIFIER, "e", null, 1));
        expectedTokens.add(new Token(EQUAL, "=", null, 1));
        expectedTokens.add(new Token(IDENTIFIER, "a", null, 1));
        expectedTokens.add(new Token(PLUS, "+", null, 1));
        expectedTokens.add(new Token(IDENTIFIER, "b", null, 1));
        expectedTokens.add(new Token(EOF, "", null, 1));


        scanner = new Scanner(ADDITION);
        assertTokens(expectedTokens, scanner.scanTokens());
    }

    @Test
    public void testSubtraction_HappyPath() {
        List<Token> expectedTokens = new ArrayList<>();

        expectedTokens.add(new Token(IDENTIFIER, "e", null, 1));
        expectedTokens.add(new Token(EQUAL, "=", null, 1));
        expectedTokens.add(new Token(IDENTIFIER, "a", null, 1));
        expectedTokens.add(new Token(MINUS, "-", null, 1));
        expectedTokens.add(new Token(IDENTIFIER, "b", null, 1));
        expectedTokens.add(new Token(EOF, "", null, 1));


        scanner = new Scanner(SUBTRACTION);
        assertTokens(expectedTokens, scanner.scanTokens());
    }

    @Test
    public void testMultiplication_HappyPath() {
        List<Token> expectedTokens = new ArrayList<>();

        expectedTokens.add(new Token(IDENTIFIER, "e", null, 1));
        expectedTokens.add(new Token(EQUAL, "=", null, 1));
        expectedTokens.add(new Token(IDENTIFIER, "a", null, 1));
        expectedTokens.add(new Token(STAR, "*", null, 1));
        expectedTokens.add(new Token(IDENTIFIER, "b", null, 1));
        expectedTokens.add(new Token(EOF, "", null, 1));


        scanner = new Scanner(MULTIPLICATION);
        assertTokens(expectedTokens, scanner.scanTokens());
    }

    @Test
    public void testDivision_HappyPath() {
        List<Token> expectedTokens = new ArrayList<>();

        expectedTokens.add(new Token(IDENTIFIER, "e", null, 1));
        expectedTokens.add(new Token(EQUAL, "=", null, 1));
        expectedTokens.add(new Token(IDENTIFIER, "a", null, 1));
        expectedTokens.add(new Token(SLASH, "/", null, 1));
        expectedTokens.add(new Token(IDENTIFIER, "b", null, 1));
        expectedTokens.add(new Token(EOF, "", null, 1));


        scanner = new Scanner(DIVISION);
        assertTokens(expectedTokens, scanner.scanTokens());
    }

    private void assertTokens(List<Token> expected, List<Token> actual) {
        assertEquals(expected.size(), actual.size());

        for (int i = 0; i < expected.size(); i++) {
            Token expectedToken = expected.get(i);
            Token actualToken = actual.get(i);
            assertEquals(expectedToken.toString(), actualToken.toString());
        }
    }

}
