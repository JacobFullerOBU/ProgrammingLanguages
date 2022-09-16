

public class Lexer {

    private String _nextToken;
    public static final int LETTER = 0;
    public static final int DIGIT = 1;
    public static final int SPACE = 2;
    public static final int UNK =99;
    public static final int IDENT =11;
    public static final int ASSIGN_OP =20;
    public static final int ADD_OP=21;
    public static final int SUB_OP=22;
    public static final int MULT_OP=23;
    public static final int DIV_OP=24;
    public static final int LEFT_PAREN=25;
    public static final int RIGHT_PAREN=26;

    public Lexer() {
        this._nextToken = "";
    }

    public void updateLexeme() {
        /**
         * FIXME this._lexeme and this._currentCharacter are not defined as an instance variable above
         */
        this._lexeme= this._lexeme + this._currentCharacter;
    }

    public void advance() {
        /**
         * FIXME These are not defined
         */
        this._currentCharacterPosition = this._currentCharacterPosition + 1;
    }

    /**
     * FIXME needs an implementation
     */
    public boolean charsRemaining() {
        return false;
    }

    /**
     * FIXME needs an implementation
     */
    public int getChar() {
        return 0;
    }

    public void lex() {
        int charClass = this.getChar();
        if (this.charsRemaining()) {
            if (charClass == SPACE) {
                charClass = this.getChar();
            }
            else if (charClass == LETTER) {
                this.updateLexeme();
                // Add code for identifiers with more than 1 character
                /**
                 * FIXME _nextToken should be an integer (int)
                 */
                this._nextToken = IDENT;
            }
            else if (charClass ==DIGIT){
                this.updateLexeme();
                this._nextToken = INT_LIT;
                /*add code for integers >9 */
            }
            else if (charClass==UNK){
                /**
                 * FIXME this needs to be implemented in a Java data structure or as an if/else. Basically,
                 *      you need to associate a lexeme with a token. For example,
                 *          "(" is LEFT_PAREN
                 *          ")" is RIGHT_PAREN
                 */
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
        print("Success")
    }
}
