package figueiredoisaac.modulo_financeiro_api.model

import figueiredoisaac.modulo_financeiro_api.common.TipoTransacao
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "transacoes")
data class Transacao(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "nm_transacao")
    val nomeTransacao: String,

    @Column(name = "cd_tipo_transacao")
    val codigoTipoTransacao: TipoTransacao,

    @Column(name = "vr_parcela")
    val valorParcela: Double,

    @Column(name = "nn_parcela_total")
    val numeroParcelaTotal: Long,

    @Column(name = "nn_parcela_atual")
    val numeroParcelaAtual: Long,

    @ManyToOne
    @JoinColumn(name = "id_forma_pagamento")
    val formaPagamento: FormaPagamento,

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    val categoria: Categoria,

    @ManyToOne
    @JoinColumn(name = "id_carteira")
    val carteira: Carteira?,

    @ManyToOne
    @JoinColumn(name = "id_cartao")
    val cartao: Cartao?,

    @Column(name = "dt_criada")
    val dataCriada: LocalDateTime,

    @Column(name = "dt_atualizada")
    val dataAtualizada: LocalDateTime,

    @Column(name = "dt_prevista")
    val dataPrevista: LocalDateTime,

    @Column(name = "dt_realizada")
    val dataRealizada: LocalDateTime?,

    @Column(name = "fl_recorrente")
    val flagRecorrente: Boolean
)
