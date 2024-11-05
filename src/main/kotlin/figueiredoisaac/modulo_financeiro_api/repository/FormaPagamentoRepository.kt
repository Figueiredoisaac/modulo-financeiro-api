package figueiredoisaac.modulo_financeiro_api.repository

import figueiredoisaac.modulo_financeiro_api.model.FormaPagamento
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FormaPagamentoRepository : JpaRepository<FormaPagamento, Long> {
    // Inclua consultas específicas conforme necessário
}
