package testaCollection

fun main(){
  val pedidos: MutableMap<Int, Double> = mutableMapOf(Pair(1, 20.0), Pair(2, 30.0), 3 to 50.0, 4 to 100.0, 5 to 150.0, 6 to 80.0)

//  val valorPedido = pedidos.getValue(5)
//    println(valorPedido)

  val mensagem: Double? = (pedidos.getOrElse(0) { 0.0 })

  println(mensagem)

  val pedidoDefault = pedidos.getOrDefault(0, -1.0)
  println(pedidoDefault)

  println(pedidos.keys)
  println(pedidos.values)

  for (numero in pedidos.keys){
    println("Pedido $numero")
  }

  for (valores in pedidos.values){
    println("Valores $valores")
  }




  val pedidosFiltrados =  pedidos.filter { (numero, valor) ->
    numero % 2 == 0 && valor > 50.0
  }

  println(pedidosFiltrados)

  val pedidosAcima = pedidos.filterValues { valor ->
    valor > 70.0
  }

  println(pedidosAcima)

  val pedidosPares = pedidos.filterKeys { numero ->
    numero % 2 == 0
  }

  println(pedidosPares)
}