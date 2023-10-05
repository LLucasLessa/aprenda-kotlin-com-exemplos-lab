enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String, var formacao: Formacao? = null)

data class ConteudoEducacional(val nome: String, val duracao: Int)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        usuario.formacao = this
        inscritos.add(usuario)
    }
}

fun exibirCurso(formacao: Formacao, nivel: Nivel) {
    val mensagem = when (nivel) {
        Nivel.BASICO -> "Nível Básico"
        Nivel.INTERMEDIARIO -> "Nível Intermediário"
        Nivel.AVANCADO -> "Nível Avançado"
    }

    println("Nome do Curso: ${formacao.nome}")
    println("Aulas Da Grade Curricular")

    var numaula = 1
    for (conteudoEducacional in formacao.conteudos) {
        println("aula ${numaula}: ${conteudoEducacional.nome}, Duração: ${conteudoEducacional.duracao} Min")
        numaula++
    }

    println("Nível do Curso: $mensagem")
}

fun main() {
    val usuario1 = Usuario("Lucas")
    val usuario2 = Usuario("José")
    val usuario3 = Usuario("Fernanda")
    val usuario4 = Usuario("Mateus")
    
    val aula1 = ConteudoEducacional("Iniciando no kotlin", 12)
    val aula2 = ConteudoEducacional("Criando o Primeiro App com kotlin", 33)
    val aula3 = ConteudoEducacional("Encerramento do curso de kotlin", 8)
    val aulaskotlin = listOf(aula1, aula2, aula3)
    val kotlin = Formacao("Kotlin", aulaskotlin)

    val java1 = ConteudoEducacional("Iniciando no Java", 18)
    val java2 = ConteudoEducacional("Criando um Sistema com Java", 53)
    val java3 = ConteudoEducacional("Encerramento do curso de Java", 13)
    val aulasJava = listOf(java1, java2, java3)
    val java = Formacao("Java", aulasJava)
    

    val python1 = ConteudoEducacional("Python, a linguagem da cobrinha", 16)
    val python2 = ConteudoEducacional("Criando uma IA com Python", 153)
    val python3 = ConteudoEducacional("Encerramento do curso de Python", 10)
    val aulasPython = listOf(python1, python2, python3)
    val python = Formacao("Python", aulasPython)
    
    kotlin.matricular(usuario1)
    java.matricular(usuario2)
    python.matricular(usuario3)
    
    exibirCurso(java, Nivel.AVANCADO)
    println("")
    exibirCurso(kotlin, Nivel.INTERMEDIARIO)
    println("")
    exibirCurso(python, Nivel.BASICO)
    println("")
    
    val matri1 = usuario1.formacao?.nome ?: "não matriculado"
    val matri2 = usuario2.formacao?.nome ?: "não matriculado"
    val matri3 = usuario3.formacao?.nome ?: "não matriculado"
    val matri4 = usuario4.formacao?.nome ?: "não matriculado"
    
    println("${usuario1.nome}, Matriculado no curso: ${matri1}")
    println("${usuario2.nome}, Matriculado no curso: ${matri2}")
    println("${usuario3.nome}, Matriculado no curso: ${matri3}")
    println("${usuario4.nome}, Matriculado no curso: ${matri4}") 
    

}