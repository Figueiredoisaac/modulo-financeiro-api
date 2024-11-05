package figueiredoisaac.modulo_financeiro_api.repository

import figueiredoisaac.modulo_financeiro_api.model.Carteira
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CarteiraRepository : JpaRepository<Carteira, Long> {
    // Métodos adicionais conforme necessário
}
