<h1>Explorando operações específicas do MAP</h1>

## Leitura e filtros específicos de Map


### Get Value
Vamos começar com o get value, por exemplo. O que seria esse get value? Vai ser muito similar ao que a gente vê no get. O get tem exatamente a mesma cara que a gente viu lá pegando os valores a partir de colchetes. Muito provavelmente eu não explorei com vocês, mas a gente vai 
explorar agora, que é exatamente aquela situação que a gente quer pegar um pedido.

Se eu pegar assim so com o get, conforme abaixo, o resultado é null:

             val pedidos: MutableMap<Int, Double?> = mutableMapOf(Pair(1, 20.0), Pair(2, 30.0), 3 to 50.0, 4 to null)

             val valorPedido = pedidos.get(4)
             println(valorPedido)

             // resultado 
             null

Mas se eu implemento o getValue(4) o resultado é diferente:

            fun main(){
                val pedidos: MutableMap<Int, Double?> = mutableMapOf(Pair(1, 20.0), Pair(2, 30.0), 3 to 50.0, 4 to null)
                
                val valorPedido = pedidos.getValue(5)
                println(valorPedido)
            }

            // resultado
            Exception in thread "main" java.util.NoSuchElementException: Key 5 is missing in the map.
                at kotlin.collections.MapsKt__MapWithDefaultKt.getOrImplicitDefaultNullable(MapWithDefault.kt:24)
                at kotlin.collections.MapsKt__MapsKt.getValue(Maps.kt:348)
                at testaCollection.LeituraFiltrosKt.main(LeituraFiltros.kt:6)
                at testaCollection.LeituraFiltrosKt.main(LeituraFiltros.kt)

Se o valor não existir, ele da uma exception ou seja, getValue é mais viavel porque se fosse com o get novamente o resultado que a gente tem. A gente iria meio que assumir que não existe, mas pode ser que sim, porque aqui é null, estamos trabalhando com valores null,
então não é tão preciso assim trabalhar com get em relação a um feedback de que uma chave existe ou não.
Esse é um fator muito importante para você verificar se realmente o que você espera como retorno é o que você quer apresentar para o seu usuário, quer tratar para poder mandar uma resposta.
5] Dessas situações que você pode estar trabalhando com null, trabalhar com o get value acaba sendo interessante. Vou deixar aqui o get value para você ter essa referência.

* Esse é o get value. É uma maneira de recuperar valor de tal forma que se a chave não existe ele traz para a gente uma exception com mais precisão

### Get or else

Aí temos também aqui esse get or else. O que ele vai fazer? Ele vai ter um comportamento similar ao get. A diferença é que ele vai fazer um retorno a partir de uma expressão Lambda.

Exemplo:

            val pedidos: MutableMap<Int, Double?> = mutableMapOf(Pair(1, 20.0), Pair(2, 30.0), 3 to 50.0, 4 to null)

            println(pedidos.getOrElse(1, {
                "Não tem pedido"
            }))

O resultado vai ser o 20.0 porque tem, se chamasse um indicador que não contem valor, ele mostra a mensagem que vc passar, no caso ali seria: `"Não tem pedido"`;

Podemos atribuir a uma variavel também e tipo:

            
              val mensagem: Double? = (pedidos.getOrElse(0, { 0.0 }))

               println(mensagem)
            
                // resultado

                0.0 // mensagem personalizada do tipo Double

Tambem podemos fazer assim:

              val mensagem: Double? = (pedidos.getOrElse(0) { 0.0 })

                println(mensagem)


Como funciona isso? É mais fácil a gente fazer o código. Basicamente, vamos ter o get or else e vai ser a mesma ideia. Pegando uma chave, a gente vai lá e pega essa chave, mas veja que ele sempre vai pedir para que a gente faça uma expressão Lambda. A gente pode mandar, por exemplo, aqui. E caso essa chave não retornar, ele vai devolver esse valor para a gente, essa expressão Lambda,
o que a gente colocar aqui ele devolve para a gente.

Mas a ideia do get or else é não ficar estão restrito e você ter toda essa flexibilidade de mudar a partir do que você quiser.



### get or default

Agora, com essa característica que a gente está vendo, que seria meio que um valor padrão para double caso não exista, a gente tem nesse outro cara, que é esse get or default, que realmente vai devolver um valor que seja compatível ao valor do nosso mapa, mas que seja padrão.

No exemplo se existir, ele mostra o valor ok, no caso é o 20.0

              val pedidoDefault = pedidos.getOrDefault(1, -1.0)
                println(pedidoDefault)

Caso passe index que não existe, o valor sera -1.0 que foi personalizado ali.

Essas são as maneiras que a gente tem também de pegar valores além da mais convencional, padrão, inicial, que a gente viu, que é o get utilizando os colchetes. Agora vamos para o próximo tópico.



### Interações e filtros

<b>INTERAÇÕES</b>

Lista =   val pedidos: MutableMap<Int, Double?> = mutableMapOf(Pair(1, 20.0), Pair(2, 30.0), 3 to 50.0, 4 to null)
* pedidos.keys = ver todos index da lista começa no 1 ex: [1, 2, 3, 4]
* pedidos.values = Valores da lista [20.0, 30.0, 50.0, null]

Percorrendo as chaves e valores com for loop

             for (numero in pedidos.keys){
                println("Pedido $numero")
            }
            
            for (valores in pedidos.values){
                println("Valores $valores")
            }


<b>FILTROS</b>

Sempre que você fizer um filtro aqui no mapa, você vai ter que mandar ambos os valores como se fosse um pair, sempre assim. Aí claro, a gente vai precisar devolver alguma coisa que seja de acordo com um true ou um false, porque isso aqui é um filtro, para ele conseguir compilar.
Mas veja que se tirarmos novamente os nossos parênteses, dado que isso aqui seriam valores separados, a gente não consegue fazer o filtro, então esse é um comportamento bastante comum quando a gente quer brincar de filtro dentro do mapa. A gente sempre precisa considerar que vamos mandar um pair, 
uma referência que vai manter tanto a chave quanto o valor de cada elemento do mapa.         

] Vamos fazer aqui um exemplo, vou pegar desse de par e dessa maneira vou pegar todos que são pares e maiores do que 50, que nesse caso entra o 4, o 5 também, 150, e o 6, vou deixar ele abaixo para a gente não filtrar nesse caso. E vou aumentar um pouco o 2 para poder pegar como par. A gente pode fazer isso aqui.

         val pedidosFiltrados =  pedidos.filter { (numero, valor) ->
             numero % 2 == 0 && valor > 50.0
         }
            
         println(pedidosFiltrados)

        // resultado 

        {4=100.0, 6=80.0} 

Temos também filtro dos valores:

          val pedidosAcima = pedidos.filterValues { valor ->
                valor > 70.0
          }
            
          println(pedidosAcima)

         // resultado

         {4=100.0, 5=150.0, 6=80.0}

E também das chaves

           val pedidosPares = pedidos.filterKeys { numero ->
                numero % 2 == 0
           }
            
           println(pedidosPares)

           // resultado

           {2=30.0, 4=100.0, 6=80.0}

Essas são as maneiras que a gente tem de fazer filtro e que acabam sendo um pouco exclusivas do mapa. Não temos tanto na lista, como também no set. A seguir a gente vai ver um pouco mais sobre esses comportamentos que existem também.


    Teste os seguintes comportamentos e membros do Map:
        
        Recuperação de chave e valor
        getValue()
        getOrElse()
        getOrDefault()
        keys e values
        Filtragem
        filter()
        filterKeys()
        filterValues()
        Os testes não precisam ser os mesmos que foram feitos em vídeo. Você pode considerar os exemplos que desejar também.
    
    Após finalizar os testes, confira se apresentam o resultado esperado de acordo com a documentação.

* Info de link doc kotlin -> [Map Membros](https://kotlinlang.org/docs/map-operations.html)



## Escrita específica de Map

Se a gente volta na documentação, percebemos que depois do filtro a gente entra nesse tópico plus and minus operators. O que isso significa para a gente? Que seriam os operadores de soma e de menos.
O que a gente pode tirar de informação daqui? É que ele vai ter exatamente o mesmo comportamento que a gente viu quando a gente fazia uma soma de collections, de listas e de sets. É a capacidade de criar novos mapas considerando a soma do próprio mapa que a gente já tem com um pair, ou então do próprio mapa que a gente já tem com outro mapa.
Dessa forma a gente consegue criar novos mapas sem alterar o original. Vamos ver como isso funciona.

Aqui hoje o que a gente tem? Temos um mapa de pedidos com seis pedidos, mas a gente pode criar um novo mapa, que a gente pode já imprimir fazendo da seguinte maneira. Pedidos mais colocando um pair e depois que a gente coloca esse pair a gente indica qual seria o novo pedido, que seria o set com valor de 90.
8] Estou imprimindo, colocando e criando esse novo e vou imprimir novamente o pedidos, para a gente ver se ele é alterado ou não. A gente vai perceber que o original não é alterado, mas aqui foi criado um novo. Essa é uma das maneiras que a gente pode fazer.

             val pedidos: MutableMap<Int, Double> = mutableMapOf(Pair(1, 20.0), Pair(2, 30.0), 3 to 50.0, 4 to 100.0, 5 to 150.0, 6 to 80.0)

             println(pedidos + Pair(7, 90.0))

             // Resultados

            {1=20.0, 2=30.0, 3=50.0, 4=100.0, 5=150.0, 6=80.0, 7=90.0}

Vamos verificar se aquela sintaxe com ifix também funciona. Então, `7 to 90`. Aqui já funciona. Nessa parte da operação ele já não fica compatível. Veja que realmente ali no momento que a gente faz essa operação a gente fica mais restrito ao uso do pair, ou então se a gente usar o nosso map of. Se você quer usar essa técnica você vai lá, manda o map of e a partir do map of você pode mandar o ifix com um ou mais elementos.


Exemplo:

    * Não funciona

    
    fun main(){
    val pedidos: MutableMap<Int, Double> = mutableMapOf(Pair(1, 20.0), Pair(2, 30.0), 3 to 50.0, 4 to 100.0, 5 to 150.0, 6 to 80.0)
    
        println(pedidos + 7 to 90.0)
    }

Fica reclamando, ai tem que ser com mapOf:

    fun main(){
        val pedidos: MutableMap<Int, Double> = mutableMapOf(Pair(1, 20.0), Pair(2, 30.0), 3 to 50.0, 4 to 100.0, 5 to 150.0, 6 to 80.0)
    
        println(pedidos + mapOf(7 to 90.0, 8 to 20.0))
    }

    // resultado

    {1=20.0, 2=30.0, 3=50.0, 4=100.0, 5=150.0, 6=80.0, 7=90.0, 8=20.0}

Agora temos um detalhe nesse menos, que seria o `minus`, que ao invés de ele fazer o uso de um pair ele pode já tirar o elemento a partir da chave.

    println(pedidos - 6)
    println(pedidos)

O m- representa o valor que queremos tirar.. podemos mandar uma lista também dos valores que queremos tirar:

    println(pedidos  - listOf(5, 6))

O put all vai permitir adicionar mais de um elemento, considerando o uso de uma collection, que nesse caso foi o set of, porque a ideia do set é realmente colocar elementos exclusivos. Poderia ser também uma lista.

    pedidos.putAll(setOf(7 to 90.0, 8 to 20.0))
    println(pedidos)

Ou pode ser um listOf

    pedidos.putAll(listOf(7 to 90.0, 8 to 20.0))
    println(pedidos)

Podemos adicionar assim também:

     pedidos += (listOf(7 to 90.0, 8 to 20.0))
     println(pedidos)

Existe essa outra remoção que envolve, por exemplo, a gente pegar as chaves e usar o remove, pegar o valor e usar o remove, que seria uma remoção ou por chave ou remoção apenas por valores.
Na documentação até mesmo fala que quando é por chave, dado que é único, é o comportamento de sempre, mas quando são valores o primeiro que ele achar ele remove. Se tiver repetido, ele ainda vai manter. Vamos ver como funciona.

Vamos ao exemplod e remover:

* Por chaves/keys

        val pedidos: MutableMap<Int, Double> = mutableMapOf(Pair(1, 20.0), Pair(2, 30.0), 3 to 50.0, 4 to 100.0, 5 to 100.0, 6 to 80.0)
        pedidos.keys.remove(1)
        println(pedidos)
        
        // resultado // remover o 20.0
        {2=30.0, 3=50.0, 4=100.0, 5=100.0, 6=80.0, 7=90.0, 8=20.0}


* Remover por valor/value

        val pedidos: MutableMap<Int, Double> = mutableMapOf(Pair(1, 20.0), Pair(2, 30.0), 3 to 50.0, 4 to 100.0, 5 to 100.0, 6 to 80.0)
        pedidos.values.remove(50.0)
        println(pedidos)
        
        // resultado // remover o 50.0
        {2=30.0, 4=100.0, 5=100.0, 6=80.0, 7=90.0, 8=20.0}

* Vamos remover o de valores duplicados, no caso o 4 e o 5, tem valores 100.0 então ele vai remover sempre o que vem primeiro no caso o 4.

        pedidos.values.remove(100.00)
        println(pedidos)

        // resultados
        {2=30.0, 5=100.0, 6=80.0, 7=90.0, 8=20.0}

Temos o comportamento de remoção `-=`:

       pedidos -= 6
       println(pedidos)

       // resultados
       {2=30.0, 5=100.0, 7=90.0, 8=20.0}
