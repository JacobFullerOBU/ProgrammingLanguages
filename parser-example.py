import lexer
class Parser:
    def __init__(self, theString):
        self.__lexer = lexer.Lexer(theString)
    def error(self, nextToken):
        print("PARSE ERROR token: ", nextToken, "!!")
    def factor(self):
        #<factor> -> id | int_constant | ( <expr> )
        print("Enter <factor>")
        if ((self.__lexer.get_next_token() == lexer.IDENT) or (self.__lexer.get_next_token() == lexer.INT_LIT)):
            self.__lexer.lex()
        else:
            if (self.__lexer.get_next_token() == lexer.LEFT_PAREN):
                self.__lexer.lex()
                self.expr()
                if (self.__lexer.get_next_token() == lexer.RIGHT_PAREN):
                    self.__lexer.lex()
                else:
                    self.error(self.__lexer.get_next_token())
            else:
                    self.error(self.__lexer.get_next_token())
        print("Exit <factor>")
    def term(self):
        #<term> -> <factor> {(* | /) <factor>}
        print("Enter <term>")
        self.factor()
        while (self.__lexer.get_next_token() == lexer.MULT_OP) or (self.__lexer.get_next_token() == lexer.DIV_OP):
            self.__lexer.lex()
            self.factor()
            print("Exit <term>")
def expr(self):
        print("Enter <expr>")
        #<expr> -> <term> {(+ | -) <term>}
        self.term()
        while (self.__lexer.get_next_token() == lexer.ADD_OP) or (self.__lexer.get_next_token() == lexer.SUB_OP):
            self.__lexer.lex()
            self.term()
            print("Exit <expr>")
def process(self):
        self.__lexer.lex()
        
        
        self.expr()
if __name__ == "__main__":
    parser = Parser("a+b*c")
    parser.process()