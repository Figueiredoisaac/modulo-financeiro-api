package figueiredoisaac.modulo_financeiro_api.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "cartoes")
data class Cartao(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "nm_instituicao")
    val nomeInstituicao: String,

    @Column(name = "vr_limite")
    val valorLimite: Double,

    @Column(name = "dt_vencimento")
    val dataVencimento: LocalDateTime,

    @ManyToOne
    @JoinColumn(name = "id_carteira")
    val carteira: Carteira,

    @Column(name = "dt_fechamento")
    val dataFechamento: LocalDateTime,

    @Column(name = "dt_criada")
    val dataCriada: LocalDateTime,

    @Column(name = "dt_atualizada")
    val dataAtualizada: LocalDateTime
)
