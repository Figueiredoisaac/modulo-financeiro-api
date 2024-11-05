package figueiredoisaac.modulo_financeiro_api.dto

import java.time.LocalDateTime

class EditaCartaoDto {
    var nomeInstituicao: String? = null
    var valorLimite: Double? = null
    var dataVencimento: LocalDateTime? = null
    var dataFechamento: LocalDateTime? = null

}