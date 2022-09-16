

LETTER = 0
DIGIT = 1
SPACE = 2
UNK = 99

INT_LIT = 10
IDENT = 11
ASSIGN_OP = 20
ADD_OP = 21
SUB_OP = 22
MULT_OP =23
DIV_OP = 24
LEFT_PAREN = 25
RIGHT_PAREN = 26

class Lexer:
    def __init__(self, theString):
        self._theString = theString
        self._currentCharacterPosition = 0
        self._currentCharacter = self._theString[self._currentCharacterPosition]
        self._lexeme = ""
        self._nextToken = UNK
        self._tokenMap = {'(': LEFT_PAREN, ')' : RIGHT_PAREN, '+' : ADD_OP, '-' : SUB_OP, '*' : MULT_OP, '/' : DIV_OP}

    def updateLexeme(self):
        self._lexeme = self._lexeme + self._currentCharacter

    def advance(self):
        self._currentCharacterPosition = self._currentCharacterPosition + 1
        if (self._currentCharacterPosition) < len(self._theString):
            self._currentCharacter = self._theString[self._currentCharacterPosition]

    def charsRemaining(self):
        return self._currentCharacterPosition <= (len(self._theString) - 1)

    def getChar(self):
        if self._currentCharacter.isalpha():
            charClass = LETTER
        elif self._currentCharacter.isdigit():
            charClass = DIGIT
        elif self._currentCharacter == ' ':
            charClass = SPACE
        else:
            charClass = UNK
        return charClass

    def lex(self):
        charClass = self.getChar()
        if self.charsRemaining():
            if charClass == SPACE:
                charClass = self.getChar()
            elif charClass == LETTER:
                self.updateLexeme()
                ## Add code for identifiers with more than 1 character
                self._nextToken = IDENT
            elif charClass == DIGIT:
                self.updateLexeme()
                ## Add code for integers > 9
                self._nextToken = INT_LIT
            elif charClass == UNK:
                self._nextToken = self._tokenMap[self._currentCharacter]
                self.updateLexeme()
        if charClass != SPACE:
            print("Next token is {0}, next lexeme is {1}".format(self._nextToken, self._lexeme))
        self._lexeme = ""
        self.advance()

    def process(self):
        while (self.charsRemaining()):
            self.lex()

if __name__ == "__main__":
    lexer = Lexer("ab + b + (c * d) + 121")
    lexer.process()
