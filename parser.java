import Lexer;
class Parser {
    private String theString;
    private Lexer theLexer;
    public Parser(String theString) {
        this.theString = theString;
        this.theLexer = new Lexer(theString);
    }
    private void expr() {
//        #<expr> -> <term> {(+ | -) <term>}
//        while (self.__lexer.get_next_token() == lexer.ADD_OP) or 
(self.__lexer.get_next_token() == lexer.SUB_OP):
//            self.__lexer.lex()
//            self.term()
        System.out.println("Enter <expr>");
        this.term();
        while (this.theLexer.getNextToken() == Lexer.ADD_OP) || () {
            this.theLexer.lex();
            this.term();
        }
        System.out.println("Exit <expr>");
    }
    private void term() {
    }
    private void factor() {
    }
    public static void main(String[] args) {
    }
}