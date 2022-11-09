<h1>Funções relacionadas a Collection e Map</h1>

## Utilizando a associação

* Link estudos [Transformacao](https://kotlinlang.org/docs/collection-transformations.html)

Comportamentos de transformação terão essa característica de sempre devolver algo novo baseando-se na fonte. Dada essa ideia de transformação, o que a gente vai ver relacionado ao mapa? Exatamente essa parte de associação, ou association.

### Assciate

Vamos criar uma classe, vai ter dois valores: numero e valor:

        class Pedido(val numero: Int, val valor: Double)

Como a gente viu, nosso objetivo é criar uma estrutura de collection, que seria um list ou um set, para que a gente consiga trabalhar com associação. Aqui, vou colocar o list of e determinar nossos pedidos. Vou criar um pedido com valor 1, no caso o número 1, e ele vai ter valor 20. Vou colocar a vírgula e fazer algumas cópias para colocar mais valores. 
Vou colocar o pedido de número 2, com valor 60, o pedido número 3, com valor 30, e o pedido número 4, com valor 70.

           val pedidos =  listOf(
                Pedido(1, 20.0) ,
                Pedido(2, 60.0) ,
                Pedido(3, 30.0) ,
                Pedido(4, 70.0)
           )

A gente precisa imprimir essa listinha. Como a gente pode imprimir ela? Para isso, podemos colocar tanto que ela vai ser uma variável chamada pedidos, e em seguida a gente precisa de um toString.
Só que dado que a gente precisa de um toString e a gente tem todas essas properties como um consultor primário, e também elas estão todas declaradas, podemos colocar como um data class, dessa maneira o próprio Kotlim já faz tudo para a gente.



        fun main(){
            val pedidos =  listOf(
            Pedido(1, 20.0) ,
            Pedido(2, 60.0) ,
            Pedido(3, 30.0) ,
            Pedido(4, 70.0)
        
            )
            println(pedidos)
        }
        
        data class Pedido(val numero: Int, val valor: Double)

        // resultado

        [Pedido(numero=1, valor=20.0), Pedido(numero=2, valor=60.0), Pedido(numero=3, valor=30.0), Pedido(numero=4, valor=70.0)]


Mas como vimos, nosso objetivo é trabalhar com a associação, e a primeira associação que a gente vai fazer aqui vai ser indicar que a gente quer pegar cada um desses pedidos a partir do seu número, e a gente viu que o mapping pode fazer isso, mas agora a gente vai ver como 
conseguimos transformar essa nossa listinha em um mapa que já tenha essas características.
omo a gente viu, o associate é capaz de fazer isso para a gente. O que temos que ter nele? Basicamente, vai passar por cada um dos elementos da nossa lista. Se ele vai fazer isso, a gente vai ter acesso ao nosso pedido, e como parâmetro da nossa expressão Lambda.

O que a gente precisa devolver é um pair, nesse pair ele vai determinar o que a gente espera, que no caso seria indicar que a chave é o número do pedido e que o valor é o próprio pedido. Então a gente pode indicar da seguinte maneira. Podemos criar o pair, pegar nosso pedido, o número, vírgula o próprio pedido.

    val pedidosMapeados = pedidos.associate { pedido:  Pedido ->
         Pair(pedido.numero, pedido)
    }
    
    println(pedidosMapeados)

    // resultado

    {1=Pedido(numero=1, valor=20.0), 2=Pedido(numero=2, valor=60.0), 3=Pedido(numero=3, valor=30.0), 4=Pedido(numero=4, valor=70.0)}

Vou mostrar para vocês como fica a impressão do pedidos mapeados. Ele vai ter aquela característica que a gente viu de mapa, então cada um dos números vai ter seu próprio pedido, como também se no momento que a gente quiser pesquisar o pedido a gente pode pegar exatamente pelo seu número, e não pela sua posição. Então temos também essa diferença.

    
     val pedidosMapeados = pedidos.associate { pedido:  Pedido ->
         Pair(pedido.numero, pedido)
     }
    
     println(pedidosMapeados)
     println(pedidosMapeados[1])

    // resultado 
    Pedido(numero=1, valor=20.0)

Veja que a gente pode sim trabalhar com associate para fazer uso do mapa, assim como a gente viu dos seus benefícios, que é ter exatamente a ideia de um dicionário para que a gente faça pesquisa, para que a gente tenha relação entre valores, objetos, que é o caso que a gente fez aqui. É uma das coisas que a gente pode fazer.
Como vimos, temos outros associates além desse. Aqui mesmo ele já mostra uma dica, para falar que dado que você pegou uma lista de pedidos e devolveu o próprio pedido como valor para esse mapa, você não precisa utilizar o associate. Temos outra característica, que é o associate by. Vamos ver esse carinha e vou passar mais um detalhe para vocês. 

Veja que a gente devolveu um pair, mas aqui também a gente pode utilizar aquela sintaxe do to, é uma outra maneira, a gente vê que resolve também sem nenhum problema.
        
         val pedidosMapeados = pedidos.associate { pedido:  Pedido ->
             pedido.numero to pedido
         }

Mas agora vamos ver como fica então utilizando o associate by.
Nosso código fica bem mais resumido, porque novamente, como comentei, dado que o valor desse mapa é o próprio objeto que a gente está varrendo aqui, que é o objeto pedido, o associate by já faz isso para a gente. Ele simplesmente pega cada um desses pedidos e coloca como valor. A única coisa que a gente tem que determinar
é indicar, por exemplo, qual vai ser a associação que cada um desses pedidos vai ter, que nesse caso é o número do pedido. Poderia ser qualquer outra coisa, mas foi o número do pedido.

      val pedidosMapeados = pedidos.associateBy { pedido:  Pedido ->
            pedido.numero
      }

É isso que a gente tem de diferente quando a gente faz o uso do associate by. É que já vai ser uma maneira mais resumida para que a gente devolva o próprio valor que está sendo percorrido durante a operação.


Agora que a gente viu o associate by, qual seria o exemplo que a gente pode considerar para trabalhar com esse associate with? O associate with pode ser usado em situações que a gente quer fazer algum tipo de característica de computação para identificar cada um dos elementos, como por exemplo, quero identificar 
que cada um desses pedidos tem ou não o frete grátis. Isso considerando uma regra de negócios qualquer.

Nossa regra de negócios que pode ser feita seria verificar o valor. Se o valor for acima de 50, é frete grátis, senão ele não vai ter frete grátis. Aí como a gente poderia então criar nossa nova representação de pedidos que têm ou não frete grátis?
Para isso a gente pode pegar os pedidos novamente, que estão na lista. Ela não foi modificada, e a gente pode usar o associate with. No associate with o que a gente vai ter de acesso novamente? Teremos acesso ao próprio pedido. O pedido sempre vai ser percorrido, ele vai passar por cada uma das operações.


            val pedidosFreteGratis = pedidos.associateWith { pedido ->
                pedido.valor > 50.0
            }
            println(pedidosFreteGratis)

            // resultado

            {Pedido(numero=1, valor=20.0)=false, Pedido(numero=2, valor=60.0)=true, Pedido(numero=3, valor=30.0)=false, Pedido(numero=4, valor=70.0)=true}


Para isso a gente pode pegar os pedidos novamente, que estão na lista. Ela não foi modificada, e a gente pode usar o associate with. No associate with o que a gente vai ter de acesso novamente? Teremos acesso ao próprio pedido. O pedido sempre vai ser percorrido, ele vai passar por cada uma das operações.
Em seguida, a gente pode simplesmente falar que quero que a chave seja o próprio pedido, mas que o valor seja um valor booleano, que vai ser nesse caso pedido valor se ele for maior do que 50. Se for maior do que 50 vai devolver true e isso significa que o frete é grátis.

É uma das maneiras de trabalhar com associate with. Então, pedidos, frete grátis, ele vai ter um mapa que vai identificar o próprio pedido, então o próprio pedido é a chave, e ele vai devolver se aquele pedido tem frete grátis ou não. Vou até deixar explícito map pedido boolean.

Da mesma maneira a gente consegue até mesmo fazer uma busca. A gente consegue chegar no pedidos, frete grátis, e conseguimos fazer uma busca através do pedido. No caso, o que vai fazer a pesquisa desse pedido é exatamente o que a gente já viu, equal, hashcode, etc.
O dataclass já faz isso para a gente, então, o que a gente tem como igualitário são esses dois valores. Se ambos baterem são iguais. Então, nesse caso, se a gente quer pesquisar do pedido número 1, a gente tem que pegar o valor do pedido número 1. Vou colocar o pedido número 1,
ele vai lá e vai fazer a pesquisa para a gente e verificar que é falso.


               val pedidosFreteGratis = pedidos.associateWith { pedido ->
                    pedido.valor > 50.0
               }
               println(pedidosFreteGratis)
               println(pedidosFreteGratis[Pedido(numero=1, valor=20.0)])

Veja que o associate with vai ser exatamente a ideia contrária do associate. Ele vai pegar cada um dos elementos e vai transformar em chave, e então ele vai permitir que a gente associe com algum outro valor, baseando-se em alguma computação, que nesse caso o que a gente 
fez foi para calcular se o frete era grátis ou não verificando se o valor era maior do que 50.
Mas perceba que poderíamos fazer qualquer coisa. De repente, se queremos fazer outro cálculo para verificar se esse pedido tem quantidades acima de dez ou menos do que dez, é outra maneira que a gente pode fazer. Você pode explorar conforme a sua necessidade.
Essa é a associação que a gente tem quando a gente trabalha com as connections e com os mapas.

Utilize os comportamentos de associação para resolver os seguintes cenários, dada uma lista de pedidos:

Criar um mapa de pedidos com a chave sendo o número do pedido.
Criar um mapa de Boolean com a chave sendo os pedidos para verificar se têm frete grátis (true) ou não (false).
Lembre-se de representar o pedido com uma classe. Considere o uso da data class para obter um toString() pronto.

Neste exercício, considere o uso das seguintes funções associate() ou associateBy() e o associateWith().

A regra para determinar se tem frete grátis pode ser a de valor acima de 50.0 ou alguma que preferir.


## Utilizando o agrupamento

No caso vamos ver com boolean
         val pedidos =  listOf(
            Pedidos(1, 20.0) ,
            Pedidos(2, 60.0) ,
            Pedidos(3, 30.0) ,
            Pedidos(4, 70.0)
         )
         println(pedidos)

        val mapa = pedidos.associateBy { pedido -> pedido.valor > 50.0 }
        println(mapa)

        // resultados

        {false=Pedidos(numero=3, valor=30.0), true=Pedidos(numero=4, valor=70.0)}

Olha só. Ele só tem apenas dois elementos. Por que isso acontece? Pela característica que a gente viu que o mapa tem, que é as chaves são únicas, não podemos ter mais de uma chave, ou seja,
apenas um único false e apenas um único true. Logo, se a gente só tem um único, também vamos ter um único valor, quando a gente faz a associação, porque a associação não agrupa, correto? Ela simplesmente vai adicionar um único valor durante o processo de iteração.

Nesse caso, ele sempre vai manter o último. Perceba que a gente está mantendo exatamente o 3 e o 4. Se a gente colocasse aqui mais um valor, no caso o 5, vou deixar ele menor para a gente ter esse valor lá dentro do false e a gente ver isso sendo substituído, a gente vai perceber que ele vai manter o 5 como último, 
porque foi o último computado para a situação, que é menor do que 50.

            val pedidos =  listOf(
                Pedidos(1, 20.0) ,
                Pedidos(2, 60.0) ,
                Pedidos(3, 30.0) ,
                Pedidos(4, 70.0) ,
                Pedidos(5, 40.0)
            )

            val mapa = pedidos.associateBy { pedido -> pedido.valor > 50.0 }
            println(mapa)

            // resultado

            {false=Pedidos(numero=5, valor=40.0), true=Pedidos(numero=4, valor=70.0)}

Veja que com associação a gente não tem essa capacidade realmente, dada uma chave que não pode repetir, nesse caso, que é o true, ela tem que ser a mesma para mais de um valor, a gente não consegue trazer mais de um valor, a gente só consegue trazer um único.

m outras palavras, o que quero mostrar aqui para vocês é outro comportamento que ele vai resolver exatamente isso que a gente está vendo agora. Esse cenário que a gente vai ter somente chaves limitadas, mas que conseguem sim agrupar mais de um valor. E para isso vamos colocar na documentação e no tópico de collections a gente vai 
ter o comportamento de grouping, ou agrupamento, que vai ser exatamente esse carinha, o group by.

### Group By

O group by consegue pegar exatamente uma chave e dada essa chave ele agrupa os elementos dentro de uma coleção, ele sempre vai colocar cada um dos elementos que ele fez ali, todo o processo, o matching, que seria verificar se é igual ao que a gente está querendo colocar. E deixou dentro de uma estrutura de coleção, 
que é exatamente o que a gente precisa para determinar se vai ter frete grátis ou não.

           val pedidosFreteGratisAgrupados =  pedidos.groupBy { pedidos: Pedidos ->
                   pedidos.valor > 50
           }
           println(pedidosFreteGratisAgrupados)

            // resultados

            {false=[Pedidos(numero=1, valor=20.0), Pedidos(numero=3, valor=30.0), Pedidos(numero=5, valor=40.0)], true=[Pedidos(numero=2, valor=60.0), Pedidos(numero=4, valor=70.0)]}


Quano quero buscar valor true:

            val pedidosFreteGratisAgrupados =  pedidos.groupBy { pedidos: Pedidos ->
              pedidos.valor > 50
            }
            println(pedidosFreteGratisAgrupados)
            println(pedidosFreteGratisAgrupados[true]) 

            // resultados

            [Pedidos(numero=2, valor=60.0), Pedidos(numero=4, valor=70.0)]

Essa é uma característica bastante comum que a gente tem quando a gente está trabalhando na questão de associação. Nesse caso, a gente vai trabalhar com agrupamento, porque o agrupamento consegue dada uma chave ter mais de um valor. Nesse caso acaba sendo mais interessante do que a associação.

Um outro cenário que pode ser comum também é quando a gente quer fazer alguma lista estilo agenda. Como seria essa lista estilo agenda? Basicamente, a gente teria uma lista de nomes. Vou colocar nomes quaisquer, se você cruzar os exemplos que eu costumo usar, que é o Alex, a Fran, vou colocar o Gui, a Ana, vou deixar o
Paulo também nesse exemplo, vou colocar a Maria, vou colocar o Mário, vou colocar a Gisele, e podemos colocar outros nomes. Vou até deixar o múltiplas linhas para a gente ver que temos bastante nomes.

    val nomes = listOf("Alex", "Fran", "Gui", "Ana", "Paulo", "Maria", "Mario", "Gisele")

    val agenda = nomes.groupBy { nome -> nome.first() }
    println(agenda)

    // resultado

    {A=[Alex, Ana], F=[Fran], G=[Gui, Gisele], P=[Paulo], M=[Maria, Mario]}


Pesquisar nome especificos:


    val nomes = listOf("Alex", "Fran", "Gui", "Ana", "Paulo", "Maria", "Mario", "Gisele")

    val agenda = nomes.groupBy { nome -> nome.first() }
    println(agenda)
     println(agenda['A'])

    // resultado

    [Alex, Ana]

Então, o group by vai ter sempre essa ideia, da gente agrupar valores associando a uma chave. Ao invés de ter apenas um único valor, a gente consegue ter vários valores com essa correlação, diferente do que a gente viu da associação. Esse é o comportamento de agrupamento, e essas são as situações nas quais a gente pode considerar.


Utilize o groupBy() para criar um mapa de lista de pedidos, a chave deve ser do tipo Boolean que determina true como frete grátis e false como sem.
Utilize a mesma regra do exercício anterior para indicar que tem o frete grátis ou não.
Então, imprima o mapa e busque os pedidos que tenham frete grátis e os que não tenham a partir da chave do tipo Boolean.
Em seguida, crie uma lista de nomes e utilize o groupBy() para criar uma agenda de nomes e agrupá-los pela letra inicial.
Então, imprima a agenda e busque pessoas da agenda a partir da letra inicial, ou seja, a partir de um Char
Por fim, teste o programa e confira se ele apresenta o resultado esperado em ambos os mapas.

Além do groupBy(), temos acesso a função groupingBy(), que agrupa elementos de uma Collection também.

A grande diferença é que em vez de um Map, ela retorna uma instância de Grouping

        val pedidosAgrupados: Grouping<Pedido, Boolean> = pedidos.groupingBy { pedido ->
            pedido.valor > 50.0
        }

Com o Grouping podemos usar algumas operações, como é o caso da eachCount(), que conta quantos elementos foram agrupados com a nossa lógica:

        println(pedidosAgrupados.eachCount())

        {false=3, true=2}

Além do eachCount(), também temos acesso a:

* fold()
* reduce()
* aggregate()