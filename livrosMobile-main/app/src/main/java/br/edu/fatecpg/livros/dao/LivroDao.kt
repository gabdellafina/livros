package br.edu.fatecpg.livros.dao

import br.edu.fatecpg.livros.model.livro

class LivroDao private constructor() {

    private val livros = mutableListOf<livro>()

    // Função para inserir livro
    fun inserir(livro: livro) {
        livros.add(livro)
    }

    // Função para obter o último livro inserido
    fun getUltimo(): livro? {
        return livros.lastOrNull()
    }

    // Função para acessar a instância do DAO
    companion object {
        @Volatile
        private var INSTANCE: LivroDao? = null

        fun getInstance(): LivroDao {
            return INSTANCE ?: synchronized(this) {
                val instance = LivroDao()
                INSTANCE = instance
                instance
            }
        }
    }
}
