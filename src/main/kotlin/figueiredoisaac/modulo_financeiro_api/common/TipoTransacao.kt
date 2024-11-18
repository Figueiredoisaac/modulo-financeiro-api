package figueiredoisaac.modulo_financeiro_api.common


enum class TipoTransacao(val codigo: Long) {
    RECEITA(1),
    DESPESA(2)
}