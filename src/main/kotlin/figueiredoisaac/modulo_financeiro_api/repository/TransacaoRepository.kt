package figueiredoisaac.modulo_financeiro_api.repository

import figueiredoisaac.modulo_financeiro_api.model.Transacao
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface TransacaoRepository : JpaRepository<Transacao, Long> {

    @Query("SELECT t FROM Transacao t WHERE t.cartao.id = :idCartao")
    fun findByIdCartao(@Param("idCartao") idCartao: Long): List<Transacao>
}
