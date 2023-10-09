
# Lexical Token Analyzer

### Given a program, create a lexical analyzer that returns the following tokens:

**ID:**  
**OP:** "+" "-" "*" "&&" "<" "!" "." "," "="  
**DELIM:** "(" ")" "[" "]" "{" "}" ";"  
**DECL:** "class" "extends" "public" "static" "void" "main" "length" "this" "new"  
**FLUXO:** "if" "else" "while" "return" "System.out.println"  
**TIPO:** "boolean" "int" "true" "false" "String"  
**COMENT:** "/*" "*/"  

Note: Tokens within comments should not be returned.

Example output:  
\\<OP,=> number of occurrences 2  
\\<ID,x> number of occurrences 1  
