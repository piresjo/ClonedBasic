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
    private final String LOCATE_COMMAND = "LOCATE 14, 34";
    private final String COLOR_COMMAND = "COLOR 7";
    private final String DIM_STRING = "DIM a AS STRING";
    private final String DIM_LONG = "DIM a AS LONG";
    private final String DIM_DOUBLE = "DIM a AS DOUBLE";
    private final String DIM_SINGLE = "DIM a AS SINGLE";
    private final String DEFINE_TYPE = "TYPE playertype";
    private final String END_TYPE = "END TYPE";
    private final String DEFINE_TYPE_PARAM = "playername.name = \"Bob\"";
    private final String DIM_WITH_COMMENT = "DIM a as INTEGER 'Dim Integer";
    private final String WHILE_LOOP = "WHILE a <> 0";
    private final String WHILE_END = "WEND";
    private final String FOR_LOOP = "FOR count = 1 TO 5";
    private final String DO_COMMAND = "DO";
    private final String LOOP_UNTIL = "LOOP UNTIL x >= 10";
    private final String LOOP_WHILE = "LOOP WHILE x >= 10";
    private final String IF_THEN = "IF num < answer THEN PRINT \"Too big\"";
    private final String END_SELECT = "END SELECT";
    private final String CASE_STATEMENT = "CASE 1";
    private final String SELECT_CASE = "SELECT CASE answer";
    private final String END_COMMAND = "END";
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
    public void testDimSingle_HappyPath() {
        List<Token> expectedTokens = new ArrayList<>();

        expectedTokens.add(new Token(DIM, "DIM", null, 1));
        expectedTokens.add(new Token(IDENTIFIER, "a", null, 1));
        expectedTokens.add(new Token(AS, "AS", null, 1));
        expectedTokens.add(new Token(SINGLE_TYPE, "SINGLE", null, 1));
        expectedTokens.add(new Token(EOF, "", null, 1));


        scanner = new Scanner(DIM_SINGLE);
        assertTokens(expectedTokens, scanner.scanTokens());
    }

    @Test
    public void testDimDouble_HappyPath() {
        List<Token> expectedTokens = new ArrayList<>();

        expectedTokens.add(new Token(DIM, "DIM", null, 1));
        expectedTokens.add(new Token(IDENTIFIER, "a", null, 1));
        expectedTokens.add(new Token(AS, "AS", null, 1));
        expectedTokens.add(new Token(DOUBLE_TYPE, "DOUBLE", null, 1));
        expectedTokens.add(new Token(EOF, "", null, 1));


        scanner = new Scanner(DIM_DOUBLE);
        assertTokens(expectedTokens, scanner.scanTokens());
    }

    @Test
    public void testDimLong_HappyPath() {
        List<Token> expectedTokens = new ArrayList<>();

        expectedTokens.add(new Token(DIM, "DIM", null, 1));
        expectedTokens.add(new Token(IDENTIFIER, "a", null, 1));
        expectedTokens.add(new Token(AS, "AS", null, 1));
        expectedTokens.add(new Token(LONG_TYPE, "LONG", null, 1));
        expectedTokens.add(new Token(EOF, "", null, 1));


        scanner = new Scanner(DIM_LONG);
        assertTokens(expectedTokens, scanner.scanTokens());
    }

    @Test
    public void testDimString_HappyPath() {
        List<Token> expectedTokens = new ArrayList<>();

        expectedTokens.add(new Token(DIM, "DIM", null, 1));
        expectedTokens.add(new Token(IDENTIFIER, "a", null, 1));
        expectedTokens.add(new Token(AS, "AS", null, 1));
        expectedTokens.add(new Token(STRING_TYPE, "STRING", null, 1));
        expectedTokens.add(new Token(EOF, "", null, 1));


        scanner = new Scanner(DIM_STRING);
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

    @Test
    public void testInputWithVariable_HappyPath() {
        List<Token> expectedTokens = new ArrayList<>();

        expectedTokens.add(new Token(INPUT, "INPUT", null, 1));
        expectedTokens.add(new Token(STRING, "\"What is your age\"", "What is your age", 1));
        expectedTokens.add(new Token(COMMA, ",", null, 1));
        expectedTokens.add(new Token(IDENTIFIER, "age", null, 1));
        expectedTokens.add(new Token(EOF, "", null, 1));


        scanner = new Scanner(INPUT_WITHOUT_SEMICOLON);
        assertTokens(expectedTokens, scanner.scanTokens());
    }

    @Test
    public void testLocate_HappyPath() {
        List<Token> expectedTokens = new ArrayList<>();

        expectedTokens.add(new Token(LOCATE, "LOCATE", null, 1));
        expectedTokens.add(new Token(NUMBER, "14", 14.0, 1));
        expectedTokens.add(new Token(COMMA, ",", null, 1));
        expectedTokens.add(new Token(NUMBER, "34", 34.0, 1));
        expectedTokens.add(new Token(EOF, "", null, 1));


        scanner = new Scanner(LOCATE_COMMAND);
        assertTokens(expectedTokens, scanner.scanTokens());
    }

    @Test
    public void testColor_HappyPath() {
        List<Token> expectedTokens = new ArrayList<>();

        expectedTokens.add(new Token(COLOR, "COLOR", null, 1));
        expectedTokens.add(new Token(NUMBER, "7", 7.0, 1));
        expectedTokens.add(new Token(EOF, "", null, 1));


        scanner = new Scanner(COLOR_COMMAND);
        assertTokens(expectedTokens, scanner.scanTokens());
    }

    @Test
    public void testDefineType_HappyPath() {
        List<Token> expectedTokens = new ArrayList<>();

        expectedTokens.add(new Token(TYPE, "TYPE", null, 1));
        expectedTokens.add(new Token(IDENTIFIER, "playertype", null, 1));
        expectedTokens.add(new Token(EOF, "", null, 1));


        scanner = new Scanner(DEFINE_TYPE);
        assertTokens(expectedTokens, scanner.scanTokens());
    }

    @Test
    public void testEndType_HappyPath() {
        List<Token> expectedTokens = new ArrayList<>();

        expectedTokens.add(new Token(END, "END", null, 1));
        expectedTokens.add(new Token(TYPE, "TYPE", null, 1));
        expectedTokens.add(new Token(EOF, "", null, 1));


        scanner = new Scanner(END_TYPE);
        assertTokens(expectedTokens, scanner.scanTokens());
    }

    @Test
    public void testTypeParam_HappyPath() {
        List<Token> expectedTokens = new ArrayList<>();

        expectedTokens.add(new Token(IDENTIFIER, "playername", null, 1));
        expectedTokens.add(new Token(DOT, ".", null, 1));
        expectedTokens.add(new Token(IDENTIFIER, "name", null, 1));
        expectedTokens.add(new Token(EQUAL, "=", null, 1));
        expectedTokens.add(new Token(STRING, "\"Bob\"", "Bob", 1));
        expectedTokens.add(new Token(EOF, "", null, 1));


        scanner = new Scanner(DEFINE_TYPE_PARAM);
        assertTokens(expectedTokens, scanner.scanTokens());
    }

    @Test
    public void testForLoop_HappyPath() {
        List<Token> expectedTokens = new ArrayList<>();

        expectedTokens.add(new Token(FOR, "FOR", null, 1));
        expectedTokens.add(new Token(IDENTIFIER, "count", null, 1));
        expectedTokens.add(new Token(EQUAL, "=", null, 1));
        expectedTokens.add(new Token(NUMBER, "1", 1.0, 1));
        expectedTokens.add(new Token(TO, "TO", null, 1));
        expectedTokens.add(new Token(NUMBER, "5", 5.0, 1));
        expectedTokens.add(new Token(EOF, "", null, 1));


        scanner = new Scanner(FOR_LOOP);
        assertTokens(expectedTokens, scanner.scanTokens());
    }

    @Test
    public void testEnd_HappyPath() {
        List<Token> expectedTokens = new ArrayList<>();

        expectedTokens.add(new Token(END, "END", null, 1));
        expectedTokens.add(new Token(EOF, "", null, 1));


        scanner = new Scanner(END_COMMAND);
        assertTokens(expectedTokens, scanner.scanTokens());
    }

    @Test
    public void testWhileLoop_HappyPath() {
        List<Token> expectedTokens = new ArrayList<>();

        expectedTokens.add(new Token(WHILE, "WHILE", null, 1));
        expectedTokens.add(new Token(IDENTIFIER, "a", null, 1));
        expectedTokens.add(new Token(NOT_EQUAL, "<>", null, 1));
        expectedTokens.add(new Token(NUMBER, "0", 0.0, 1));
        expectedTokens.add(new Token(EOF, "", null, 1));


        scanner = new Scanner(WHILE_LOOP);
        assertTokens(expectedTokens, scanner.scanTokens());
    }

    @Test
    public void testWhileEnd_HappyPath() {
        List<Token> expectedTokens = new ArrayList<>();

        expectedTokens.add(new Token(WEND, "WEND", null, 1));
        expectedTokens.add(new Token(EOF, "", null, 1));


        scanner = new Scanner(WHILE_END);
        assertTokens(expectedTokens, scanner.scanTokens());
    }

    @Test
    public void testDo_HappyPath() {
        List<Token> expectedTokens = new ArrayList<>();

        expectedTokens.add(new Token(DO, "DO", null, 1));
        expectedTokens.add(new Token(EOF, "", null, 1));


        scanner = new Scanner(DO_COMMAND);
        assertTokens(expectedTokens, scanner.scanTokens());
    }

    @Test
    public void testLoopUntil_HappyPath() {
        List<Token> expectedTokens = new ArrayList<>();

        expectedTokens.add(new Token(LOOP, "LOOP", null, 1));
        expectedTokens.add(new Token(UNTIL, "UNTIL", null, 1));
        expectedTokens.add(new Token(IDENTIFIER, "x", null, 1));
        expectedTokens.add(new Token(GREATER_EQUAL, ">=", null, 1));
        expectedTokens.add(new Token(NUMBER, "10", 10.0, 1));
        expectedTokens.add(new Token(EOF, "", null, 1));


        scanner = new Scanner(LOOP_UNTIL);
        assertTokens(expectedTokens, scanner.scanTokens());
    }

    @Test
    public void testLoopWhile_HappyPath() {
        List<Token> expectedTokens = new ArrayList<>();

        expectedTokens.add(new Token(LOOP, "LOOP", null, 1));
        expectedTokens.add(new Token(WHILE, "WHILE", null, 1));
        expectedTokens.add(new Token(IDENTIFIER, "x", null, 1));
        expectedTokens.add(new Token(GREATER_EQUAL, ">=", null, 1));
        expectedTokens.add(new Token(NUMBER, "10", 10.0, 1));
        expectedTokens.add(new Token(EOF, "", null, 1));


        scanner = new Scanner(LOOP_WHILE);
        assertTokens(expectedTokens, scanner.scanTokens());
    }

    @Test
    public void testSelectCase_HappyPath() {
        List<Token> expectedTokens = new ArrayList<>();

        expectedTokens.add(new Token(SELECT, "SELECT", null, 1));
        expectedTokens.add(new Token(CASE, "CASE", null, 1));
        expectedTokens.add(new Token(IDENTIFIER, "answer", null, 1));
        expectedTokens.add(new Token(EOF, "", null, 1));


        scanner = new Scanner(SELECT_CASE);
        assertTokens(expectedTokens, scanner.scanTokens());
    }

    @Test
    public void testCase_HappyPath() {
        List<Token> expectedTokens = new ArrayList<>();

        expectedTokens.add(new Token(CASE, "CASE", null, 1));
        expectedTokens.add(new Token(NUMBER, "1", 1.0, 1));
        expectedTokens.add(new Token(EOF, "", null, 1));

        scanner = new Scanner(CASE_STATEMENT);
        assertTokens(expectedTokens, scanner.scanTokens());
    }

    @Test
    public void testEndSelect_HappyPath() {
        List<Token> expectedTokens = new ArrayList<>();

        expectedTokens.add(new Token(END, "END", null, 1));
        expectedTokens.add(new Token(SELECT, "SELECT", null, 1));
        expectedTokens.add(new Token(EOF, "", null, 1));


        scanner = new Scanner(END_SELECT);
        assertTokens(expectedTokens, scanner.scanTokens());
    }

    @Test
    public void testIfThen_HappyPath() {
        List<Token> expectedTokens = new ArrayList<>();

        expectedTokens.add(new Token(IF, "IF", null, 1));
        expectedTokens.add(new Token(IDENTIFIER, "num", null, 1));
        expectedTokens.add(new Token(LESS, "<", null, 1));
        expectedTokens.add(new Token(IDENTIFIER, "answer", null, 1));
        expectedTokens.add(new Token(THEN, "THEN", null, 1));
        expectedTokens.add(new Token(PRINT, "PRINT", null, 1));
        expectedTokens.add(new Token(STRING, "\"Too big\"", "Too big", 1));
        expectedTokens.add(new Token(EOF, "", null, 1));


        scanner = new Scanner(IF_THEN);
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
