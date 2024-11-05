package figueiredoisaac.modulo_financeiro_api.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "carteiras")
data class Carteira(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "nm_carteira")
    val nomeCarteira: String,

    @Column(name = "nm_instituicao")
    val nomeInstituicao: String,

    @Column(name = "dt_criada")
    val dataCriada: LocalDateTime,

    @Column(name = "dt_atualizada")
    val dataAtualizada: LocalDateTime
)
