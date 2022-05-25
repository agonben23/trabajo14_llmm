
fun main() {
    val gestorNotas = GestorNotas("..\\trabajo14_llmm\\src\\main\\resources\\notas.xml")
    var comando: List<String>
    println("Bienvenido a Xpress Memories for Life")
    do{
        println(GestorNotas.menu)
        comando = readln().split(" ")

        when(comando[0]){
            "-r" -> {
                if (comando.size == 1) {
                    gestorNotas.imprimirTodasLasNotas()
                }else{
                    gestorNotas.buscarNota(comando[1])
                }
            }
            "-m" -> {
                if (comando.size == 2){
                    gestorNotas.modificarNota(comando[1])
                }
            }
            "-d" -> {
                if (comando.size == 2){
                    gestorNotas.eliminarNota(comando[1])
                }
            }
        }

    }while (comando[0] != "-exit")

    println("Fin del programa")
}

