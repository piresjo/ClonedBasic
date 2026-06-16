package ClonedBasic;

import java.util.*;

import static ClonedBasic.TokenType.*;

public class Scanner {
    private final String source;
    private List<Token> tokens;
    private int start;
    private int current;
    private int line;

    private static final Map<String, TokenType> keywords;
    static {
        keywords = new HashMap<>();
        keywords.put("and", AND);
        keywords.put("or", OR);
        keywords.put("not", NOT);
        keywords.put("false", FALSE);
        keywords.put("true", TRUE);
        keywords.put("for", FOR);
        keywords.put("next", NEXT);
        keywords.put("do", DO);
        keywords.put("while", WHILE);
        keywords.put("until", UNTIL);
        keywords.put("if", IF);
        keywords.put("endif", ENDIF);
        keywords.put("else", ELSE);
        keywords.put("print", PRINT);
        keywords.put("goto", GOTO);
        keywords.put("sub", SUB);
        keywords.put("cls", CLS);
        keywords.put("dim", DIM);
        keywords.put("as", AS);
        keywords.put("to", TO);
        keywords.put("wend", WEND);
        keywords.put("loop", LOOP);
        keywords.put("end", END);
        keywords.put("select", SELECT);
        keywords.put("case", CASE);


    }

    public Scanner(String source) {
        this.source = source;
        this.tokens = new ArrayList<>();
        this.start = 0;
        this.current = 0;
        this.line = 1;
    }

    public List<Token> scanTokens() {
        while(!(isAtEnd())) {
            this.start = this.current;
            scanToken();
        }

        this.tokens.add(new Token(EOF, "", null, line));
        return tokens;
    }

    private void scanToken() {
        char c = advance();
        switch (c) {
            case '(':
                this.addToken(LEFT_PARENTHESIS);
                break;
            case ')':
                this.addToken(RIGHT_PARENTHESIS);
                break;
            case '[':
                this.addToken(LEFT_BRACE);
                break;
            case ']':
                this.addToken(RIGHT_BRACE);
                break;
            case ',':
                this.addToken(COMMA);
                break;
            case '.':
                this.addToken(DOT);
                break;
            case '-':
                this.addToken(MINUS);
                break;
            case '+':
                this.addToken(PLUS);
                break;
            case '*':
                this.addToken(STAR);
                break;
            case '/':
                this.addToken(SLASH);
                break;
            case '=':
                this.addToken(EQUAL);
                break;
            case '<':
                this.addToken(match('=') ? LESS_EQUAL : LESS);
                break;
            case '>':
                this.addToken(match('=') ? GREATER_EQUAL : GREATER);
                break;
            case '\'':
                while (this.peek() != '\n' && !(this.isAtEnd())) {
                    this.advance();
                }
                break;
            case ' ':
            case '\r':
            case '\t':
                break;
            case '\n':
                this.line++;
                break;
            case '"':
                this.string();
                break;
            default:
                if (this.isDigit(c)) {
                    this.number();
                } else if (this.isAlpha(c)) {
                    this.identifier();
                } else {
                    Basic.error(line, "Unexpected Character");
                }
                break;
        }

    }

    private void identifier() {
        while (this.isAlphaNumeric(this.peek())) {
            this.advance();
        }

        String text = source.substring(this.start, this.current);
        System.out.println(text);
        System.out.println(text.toLowerCase());
        TokenType type = keywords.get(text.toLowerCase());
        if (type == null) {
            type = IDENTIFIER;
        }
        this.addToken(type);
    }

    private boolean isAlphaNumeric(char c) {
        return this.isDigit(c) || this.isAlpha(c);
    }

    private boolean isAlpha(char c) {
        return Character.isLetter(c) || c == '_';
    }

    private boolean isDigit(char c) {
        return (c >= '0' && c <= '9');
    }

    private char peekNext() {
        if (this.current + 1 >= this.source.length()) {
            return '\0';
        }
        return this.source.charAt(this.current + 1);
    }

    private void number() {
        while (this.isDigit(this.peek())) {
            this.advance();
        }

        if (this.peek() == '.' && this.isDigit(this.peekNext())) {
            this.advance();

            while (this.isDigit(this.peek())) {
                this.advance();
            }
        }

        this.addToken(NUMBER, Double.parseDouble(this.source.substring(this.start, this.current)));
    }

    private void string() {
        while (this.peek() != '"' && !(this.isAtEnd())) {
            if (this.peek() == '\n') {
                this.line++;
            }
            this.advance();
        }

        if (this.isAtEnd()) {
            Basic.error(line, "Undetermined String");
        }

        this.advance();

        String value = this.source.substring(this.start + 1, this.current - 1);
        this.addToken(STRING, value);

    }

    private boolean match(char expected) {
        if (this.isAtEnd()) {
            return false;
        }
        if (this.source.charAt(this.current) != expected) {
            return false;
        }

        this.current++;
        return true;
    }

    private char peek() {
        if (this.isAtEnd()) {
            return '\0';
        }
        return this.source.charAt(this.current);
    }

    private boolean isAtEnd() {
        return this.current >= this.source.length();
    }

    private char advance() {
        return this.source.charAt(this.current++);
    }

    private void addToken(TokenType type) {
        this.addToken(type, null);
    }

    private void addToken(TokenType type, Object literal) {
        String text = this.source.substring(this.start, this.current);
        this.tokens.add(new Token(type, text, literal, this.line));
    }

}
