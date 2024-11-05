package figueiredoisaac.modulo_financeiro_api.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "formas_pagamento")
data class FormaPagamento(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_forma_pagamento")
    val id: Long = 0,

    @Column(name = "nm_forma_pagamento")
    val nomeFormaPagamento: String,

    @Column(name = "dt_criada")
    val dataCriada: LocalDateTime,

    @Column(name = "dt_atualizada")
    val dataAtualizada: LocalDateTime
)
