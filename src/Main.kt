class Examen(val nombres: Array<String>) {
    val plantilla = arrayOf('a', 'c', 'b', 'a', 'd', 'b', 'b', 'c', 'a', 'a', 'b', 'd')
    val respuestas = Array(4) { CharArray(12) } // Esto va a guardar las respuestas de los estudiantes
    val notas = FloatArray(4) // Guardo las notas aqui
    var contador = 0 // Empiezo el contador en 0

    fun leerRespuestas(respuestaEstudiante: CharArray) {
        // Voy agregando las respuestas a la matriz
        if (contador < 4) { // mientras sea menor a 4
            respuestas[contador] = respuestaEstudiante // Pongo las respuestas en su fila
            contador++ // incremento el contador
        }
    }

    fun calculaNota() {
        // aqui recorro las respuestas y comparo con la plantilla
        for (i in 0..3) { // 4 estudiantes
            var correctas = 0 // empezamos con cero correctas
            for (j in 0..11) { // 12 preguntas
                if (respuestas[i][j] == plantilla[j]) { // si la respuesta es correcta
                    correctas++ // subo el contador de correctas
                }
            }
            notas[i] = (correctas * 100) / 12.0f // regla de 3 para calcular la nota
        }
    }

    fun mostrarResultados() {
        for (i in 0..3) { // para cada estudiante
            println("Estudainte: " + nombres[i])
            println("Respuestas: " + respuestas[i].joinToString(" ")) // Imprimo las respuestas con un espacio entre cada una
            println("Nota: " + notas[i]) // Imprimo la nota

            // Si la nota es mayor o igual a 70 aprueba, si es >= 60 aplaza, si es menor reprobado
            if (notas[i] >= 70) {
                println("Aprobo")
            } else if (notas[i] >= 60) {
                println("Aplazo")
            } else {
                println("Reprobo")
            }
        }
    }
}

fun main() {
    // nombres de los estudiantes
    val estudiantes = arrayOf("Marta", "Pedro", "Juan", "Maria")

    // respuestas de los estudiantes
    val respuestasMarta = charArrayOf('a', 'c', 'b', 'a', 'd', 'b', 'b', 'c', 'a', 'a', 'b', 'd')
    val respuestasPedro = charArrayOf('b', 'c', 'b', 'd', 'd', 'b', 'b', 'a', 'b', 'd', 'b', 'd')
    val respuestasJuan = charArrayOf('c', 'c', 'b', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'b', 'c')
    val respuestasMaria = charArrayOf('c', 'c', 'b', 'a', 'd', 'b', 'b', 'c', 'a', 'a', 'b', 'c')

    // creo el examen
    val examen = Examen(estudiantes)

    // agrego las respuestas de cada uno
    examen.leerRespuestas(respuestasMarta)
    examen.leerRespuestas(respuestasPedro)
    examen.leerRespuestas(respuestasJuan)
    examen.leerRespuestas(respuestasMaria)

    // calculo las notas
    examen.calculaNota()

    // imprimo los resultados
    examen.mostrarResultados()
}