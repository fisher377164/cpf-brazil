# **[CPF number (Cadastro de Pessoas Físicas) validation Java](https://www.devmedia.com.br/validando-o-cpf-em-uma-aplicacao-java/22097)**

**Validation of a CPF number**

**The CPF is a number consisting of 11 digits, the last two of which are called check digits (DV).** 
Each DV is calculated based on the previous digits and together serve to validate the CPF number as a whole.
To exemplify the CPF verification algorithm, CPF number `546.471.429-49` will be used as an example.

## The calculation of the DVs is performed in two steps using division modulus 11 (division modulus is the integer part of the result of a division):

### **To calculate the 1st check digit**
* Each of the first nine CPF numbers is multiplied by a weight that starts at 10 and decreases by 1 at each step, adding the calculated portions:
`sm = (5*10)+(4*9)+(6*8)+(4*7)+(7*6)+(1*5)+(4*4)+(2*3)+ (9*2) = 249;`
* The digit is calculated using the following expression:
`11 - (sm % 11) = 11 - (249 % 11) = 11 - 7 = 4`
**obs.** If the remainder of the division (%) calculated operator is 10 or 11, the check digit is 0; in other cases, the check digit is the remainder itself.

### **To calculate the 2nd check digit**
* Each of the first ten numbers of the CPF, considering here the first DV, is multiplied by a weight that starts from 11 and is reduced by 1 at each step, adding the calculated portions:
`sm = (5*11)+(4*10)+(6*9)+(4*8)+(7*7)+(1*6)+(4*5)+(2*4)+ (9*3)+(4*2) = 299;`
* The digit is calculated using the following expression:
`11 - (sm % 11) = 11 - (299 % 11) = 11 - 2 = 9`

**obs.** if the remainder of the division (%) calculated operator is 10 or 11, the check digit will be 0; in other cases, the check digit is the remainder itself.

[JAVA source code](/src/main/java/fisher/Main.java)

# **[Validando o CPF em uma Aplicação Java](https://www.devmedia.com.br/validando-o-cpf-em-uma-aplicacao-java/22097)**

**Validação de um número de CPF**

**O CPF é um número formado por 11 dígitos dos quais os dois últimos são chamados de dígitos verificadores (DV).** 
Cada DV é calculado com base nos dígitos anteriores e juntos servem para validar o número do CPF como um todo. .

Para exemplificar o algoritmo de verificação do CPF será utilizado como exemplo o CPF número `546.471.429-49`.

## O cálculo dos DVs é executado em duas etapas usando para isto o módulo de divisão 11 (módulo de divisão é a 
parte inteira do resultado de uma divisão):

### **Para calcular o 1º dígito verificador**
* Cada um dos nove primeiros números do CPF é multiplicado por um peso que começa de 10 e que vai sendo diminuido de 
1 a cada passo, somando-se as parcelas calculadas:
`sm = (5*10)+(4*9)+(6*8)+(4*7)+(7*6)+(1*5)+(4*4)+(2*3)+(9*2) = 249;`
* Calcula-se o dígito através da seguinte expressão:
`11 - (sm % 11) = 11 - (249 % 11) = 11 - 7 = 4`

**obs.** Se o resto da divisão (operador %) calculado for 10 ou 11, o dígito verificador será 0; nos outros casos, 
o dígito verificador é o próprio resto.

### **Para calcular o 2º dígito verificador**
* Cada um dos dez primeiros números do CPF, considerando-se aqui o primeiro DV, é multiplicado por um peso que 
começa de 11 e que vai sendo diminuido de 1 a cada passo, somando-se as parcelas calculadas:
`sm = (5*11)+(4*10)+(6*9)+(4*8)+(7*7)+(1*6)+(4*5)+(2*4)+(9*3)+(4*2) = 299;`
* Calcula-se o dígito através da seguinte expressão:
`11 - (sm % 11) = 11 - (299 % 11) = 11 - 2 = 9`

**obs.** se o resto da divisão (operador %) calculado for 10 ou 11, o dígito verificador será 0; nos outros casos, 
o dígito verificador é o próprio resto.
