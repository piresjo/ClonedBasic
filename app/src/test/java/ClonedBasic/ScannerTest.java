package ClonedBasic;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static ClonedBasic.TokenType.*;
import static org.junit.Assert.assertEquals;


public class ScannerTest {

    private final String PRINT_HELLO_WORLD = "PRINT \"HELLO WORLD\"";



    private Scanner scanner;

    @Test
    public void testHelloWorld_HappyPath() {
        List<Token> expectedTokens = List.of(
                new Token(PRINT, "PRINT", null, 1),
                new Token(STRING, "\"HELLO WORLD\"", HELLO WORLD, 1),
                new Token(EOF, "", null, 1)

        );
        scanner = new Scanner(PRINT_HELLO_WORLD);
        assertEquals(expectedTokens, scanner.scanTokens());


    }

}
