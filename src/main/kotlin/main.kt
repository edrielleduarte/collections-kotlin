fun main(){
    val banco = BancoDeNomes()
    val nomesSalvos = banco.nomes
    banco.salva("Edrielle")
    println(nomesSalvos)
    println(BancoDeNomes().nomes)
}
class BancoDeNomes{
    val nomes: Collection<String> get() = dados.toList()

    fun salva(nome: String){
        dados.add(nome)
    }

    companion object {
        private val dados = mutableListOf<String>()
    }
}







fun testaColecao() {
    val nomes: Collection<String> = mutableListOf(
        "Ari",
        "Edri",
        "Jeh",
        "Florzinha",
        "Neguinha"
    )

//    nomes.add("Lindinha")

    for (nome in nomes) {
        println(nome)
    }

    println(nomes)
    println("Tem o nome Alenx? ${nomes.contains("Edri")}")
    println("Tamanho da coleção ${nomes.size}")
//    nomes.remove("Lindinha")
    println(nomes)
}