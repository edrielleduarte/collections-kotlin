package testaCollection

fun main(){
    val pedidos: MutableMap<Int, Double> = mutableMapOf(1 to 20.0, 2 to 3.4, 3 to 50.0)
    val pedido = pedidos[1]
    pedido?.let {
        println("Pedido $it")
    }

    for (ped: Map.Entry<Int, Double> in pedidos) {
        println("Numero do pedido: ${ped.key}")
        println("Numero do pedido: ${ped.value}")
    }

    pedidos[4] = 70.0
    println(pedidos)
    pedidos.put(5, 90.0)
    println(pedidos)

    pedidos[1] = 100.0

    println(pedidos)

    pedidos.putIfAbsent(6, 200.00)
    println(pedidos)

    pedidos.remove(3, 100.0)
    println(pedidos)
}

fun primeiroTesteMap() {
    val pedidos = mapOf(1 to 20.0, 2 to 3.4, 3 to 50.0)
    val pedido = pedidos[1]
    pedido?.let {
        println("Pedido $it")
    }

    for (p: Map.Entry<Int, Double> in pedidos) {
        println("Numero do pedido: ${p.key}")
        println("Numero do pedido: ${p.value}")
    }
}