
fun main() {
    val gestorNotas = GestorNotas("..\\trabajo14_llmm\\src\\main\\resources\\notas.xml")
    var comando: List<String>
    println("Bienvenido a Xpress Memories for Life")
    do{
        println("¿Qué deseas hacer?\n-r Mostrar todos las notas\n-r [id] Muestra la nota con la id elegida\n-exit Salir del programa\n")
        comando = readln().split(" ")

        when(comando[0]){
            "-r" -> {
                if (comando.size == 1) {
                    gestorNotas.imprimirTodasLasNotas()
                }else{
                    gestorNotas.buscarNota(comando[1])
                }
            }

        }

    }while (comando[0] != "-exit")

    println("Fin del programa")
}

