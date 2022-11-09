package testaCollection

fun main(){
    val pedidos =  listOf(
        Pedidos(1, 20.0) ,
        Pedidos(2, 60.0) ,
        Pedidos(3, 30.0) ,
        Pedidos(4, 70.0) ,
        Pedidos(5, 40.0)

    )
    println(pedidos)

    val pedidosMapeados = pedidos.associateBy { pedido:  Pedidos ->
        pedido.numero
    }

    println(pedidosMapeados)
    println(pedidosMapeados[1])

    val pedidosFreteGratis = pedidos.associateWith { pedido ->
        pedido.valor > 50.0
    }
    println(pedidosFreteGratis)
    println(pedidosFreteGratis[Pedidos(numero=1, valor=20.0)])
//
//    val mapa = pedidos.associateBy { pedido -> pedido.valor > 50.0 }
//    println(mapa)
   val pedidosFreteGratisAgrupados =  pedidos.groupBy { pedidos: Pedidos ->
       pedidos.valor > 50
   }
   println(pedidosFreteGratisAgrupados)
   println(pedidosFreteGratisAgrupados[true])

    val nomes = listOf("Alex", "Fran", "Gui", "Ana", "Paulo", "Maria", "Mario", "Gisele")

    val agenda = nomes.groupBy { nome -> nome.first() }
    println(agenda)
    println(agenda['A'])

}

data class Pedidos(val numero: Int, val valor: Double)