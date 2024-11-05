package figueiredoisaac.modulo_financeiro_api.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "categorias")
data class Categoria(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    val id: Long = 0,

    @Column(name = "nm_categoria")
    val nomeCategoria: String,

    @Column(name = "dt_criada")
    val dataCriada: LocalDateTime,

    @Column(name = "dt_atualizada")
    val dataAtualizada: LocalDateTime
)
