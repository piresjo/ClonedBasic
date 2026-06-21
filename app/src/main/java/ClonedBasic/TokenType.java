package ClonedBasic;

// ToDo - Flesh Out
public enum TokenType {
    /*
     ******************************
     * SINGLE-CHARACTER TOKENS
     ******************************
     */
    LEFT_PARENTHESIS,
    RIGHT_PARENTHESIS,
    LEFT_BRACE,
    RIGHT_BRACE,
    COMMA,
    DOT,
    MINUS,
    PLUS,
    SLASH,
    STAR,
    BANG,
    EQUAL,
    LESS,
    GREATER,
    SEMICOLON,
    COMMENT_QUOTE,

    /*
     ******************************
     * DOUBLE CHARACTER TOKENS
     ******************************
     */
    GREATER_EQUAL,
    LESS_EQUAL,
    NOT_EQUAL,


    /*
     ******************************
     * LITERALS
     ******************************
     */
    STRING,
    NUMBER,
    FALSE,
    TRUE,

    /*
     ******************************
     * KEYWORDS
     ******************************
     */
    AND,
    OR,
    NOT,
    FOR,
    NEXT,
    DO,
    WHILE,
    WEND,
    UNTIL,
    IF,
    ELSE,
    PRINT,
    GOTO,
    SUB,
    ENDIF,
    CLS,
    DIM,
    AS,
    TO,
    LOOP,
    END,
    SELECT,
    CASE,
    INTEGER_TYPE,
    STRING_TYPE,
    SINGLE_TYPE,
    DOUBLE_TYPE,
    LONG_TYPE,
    INPUT,
    LOCATE,
    COLOR,
    RND,
    RANDOMIZE,
    TIMER,
    ON,
    ERROR,
    FUNCTION,
    GOSUB,
    BEEP,
    SOUND,
    PLAY,
    TYPE,
    THEN,

    /*
     ******************************
     * OTHER
     ******************************
     */
    EOF,
    IDENTIFIER,
}
