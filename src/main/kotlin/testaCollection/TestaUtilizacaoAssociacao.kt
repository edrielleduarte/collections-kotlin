package testaCollection

fun main(){
   val pedidos =  listOf(
            Pedido(1, 20.0) ,
            Pedido(2, 60.0) ,
            Pedido(3, 30.0) ,
            Pedido(4, 70.0)

    )
    println(pedidos)

   val pedidosMapeados = pedidos.associateBy { pedido:  Pedido ->
       pedido.numero
   }

    println(pedidosMapeados)
    println(pedidosMapeados[1])

    val pedidosFreteGratis = pedidos.associateWith { pedido ->
        pedido.valor > 50.0
    }
    println(pedidosFreteGratis)
    println(pedidosFreteGratis[Pedido(numero=1, valor=20.0)])
}

data class Pedido(val numero: Int, val valor: Double)