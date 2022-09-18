public class Lexer {

    private int _nextToken;
    private String _theString;
    private int _currentCharacterPosition;
    private String[] _currentCharacter;
    private String _lexeme;
    private String _tokenMap;

    public static final int LETTER = 0;
    public static final int DIGIT = 1;
    public static final int SPACE = 2;
    public static final int UNK = 99;

    public static final int INT_LIT = 10;
    public static final int IDENT = 11;
    public static final int ASSIGN_OP = 20;
    public static final int ADD_OP = 21;
    public static final int SUB_OP = 22;
    public static final int MULT_OP =23;
    public static final int DIV_OP = 24;
    public static final int LEFT_PAREN = 25;
    public static final int RIGHT_PAREN = 26;

    public Lexer(String theString) {
        this._nextToken = 0;
        this._theString = theString;
        this._currentCharacterPosition = 0;
        /**
         * FIXME Current character should be initialized to something like the empty string
         */
        this._currentCharacter = this._theString[this._currentCharacterPosition];
        this._lexeme = "";
        /**
         * FIXME _nextToken is a String, but you are trying to assign it an integer
         */
        this._nextToken = UNK;
        /**
         * FIXME this is a Python data structure, not a Java data structure. You will need to implement
         *      this as a Java data structure (or an if / else block). HashMap would work best
         */
        this._tokenMap = {'(': LEFT_PAREN, ')' : RIGHT_PAREN, '+' : ADD_OP, '-' : SUB_OP, '*' : MULT_OP, '/' : DIV_OP};

    }

    public void updateLexeme() {
        this._lexeme = this._lexeme + this._currentCharacter;
    }

    public void advance() {
        /**
         * FIXME this is missing a semicolon
         */
        this._currentCharacterPosition = this._currentCharacterPosition + 1
        /**
         * FIXME this.theString.length() in Java
         */
        if (this._currentCharacterPosition) < String.length(this._theString):
            /**
             * FIXME this is not how we access a character in a string in Java.
             */
            this._currentCharacter = this._theString[this._currentCharacterPosition]

    }

    public boolean charsRemaining() {
        return this._currentCharacterPosition <= (len(this._theString) - 1);
    }

    public int getChar() {
        int charClass;

        if (this._currentCharacter.alpha()) {
            charClass = LETTER;
        }
        else if (this._currentCharacter.digit()) {
            charClass = DIGIT;
        }
        else if (this._currentCharacter == ' ') {
            charClass = SPACE;
        }
        else {
            charClass = UNK;
        }

        return charClass;
    }

    public void lex() {
        int charClass = this.getChar();
        if (this.charsRemaining()) {
            if (charClass == SPACE) {
                charClass = this.getChar();
            }
            else if (charClass == LETTER) {
                this.updateLexeme();
                /*
                 * FIXME IDENT is an integer, it does not have a length method or property
                 */
                if (IDENT.Length >= 1) {

                }
                /**
                 * FIXME no need to wrap in a String
                 */
                this._nextToken = IDENT;
            }
            else if (charClass == DIGIT) {
                this.updateLexeme();
                // Add code for integers > 9
                String(this._nextToken) = INT_LIT;
            }
            else if (charClass == UNK) {
                this._nextToken = this._tokenMap[this._currentCharacter];
                this.updateLexeme();
            }

        }
    }

    public void process() {
        while (this.charsRemaining()) {
            this.lex();
        }
    }

    public static void main(String[] args) {
        /**
         * FIXME issing ending semicolons
         */
        Lexer = new Lexer("ab + b + (c * d) + 121")
        Lexer.process()
    }

    public int get_next_token() {
        return 0;
    }
}
