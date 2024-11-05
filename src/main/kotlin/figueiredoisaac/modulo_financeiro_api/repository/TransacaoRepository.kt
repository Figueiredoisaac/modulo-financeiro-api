package figueiredoisaac.modulo_financeiro_api.repository

import figueiredoisaac.modulo_financeiro_api.model.Transacao
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TransacaoRepository : JpaRepository<Transacao, Long> {
    // Métodos de consulta customizados podem ser adicionados aqui
}
