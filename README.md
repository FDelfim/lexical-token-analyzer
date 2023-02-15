# TP Compiladores - Analisador de Tokens Léxico

<h3>Dado um programa, faça um analisador léxico que retorne os seguintes tokens:</h3>

<b>ID:</b><br>
<b>OP:</b> “+”, “-“, “*”, “&&”, “<”, “!”, “.”, “,”, ”=”<br>
<b>DELIM:</b> “(“, “)”, “[“, “]”, “{“, “}”, “;”<br>
<b>DECL:</b> "class" "extends" "public" "static" "void" "main" "length" "this" "new"<br>
<b>FLUXO:</b> "if", "else", "while", "return", "System.out.println"<br>
<b>TIPO:</b> "boolean", "int", "true", "false", "String"<br>
<b>COMENT:</b> “/*”, “*/”<br>

Obs: Tokens dentro de comentários não podem ser retornados.

Exemplo de saída:<br>
<OP,=> número de ocorrências 2<br>
<ID,x> número de ocorrências 1<br>
