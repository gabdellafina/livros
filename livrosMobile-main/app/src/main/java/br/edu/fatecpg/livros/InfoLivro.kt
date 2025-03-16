package br.edu.fatecpg.livros

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import br.edu.fatecpg.livros.dao.LivroDao
import com.google.android.material.floatingactionbutton.FloatingActionButton

class InfoLivro : AppCompatActivity(R.layout.activity_info_livro) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val dao = LivroDao.getInstance()  // Usando o Singleton para acessar a mesma instância
        val livro = dao.getUltimo()  // Obtendo o último livro inserido

        val txtTitulo = findViewById<TextView>(R.id.txtTitulo)
        val txtAutor = findViewById<TextView>(R.id.txtAutor)
        val fabVoltar = findViewById<FloatingActionButton>(R.id.fabVoltar)

        livro?.let {
            txtTitulo.text = "Título: ${it.titulo}"
            txtAutor.text = "Autor: ${it.autor}"
        }

        fabVoltar.setOnClickListener {
            finish()
        }
    }
}
