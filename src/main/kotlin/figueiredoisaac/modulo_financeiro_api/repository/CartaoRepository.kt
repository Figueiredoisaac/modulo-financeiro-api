package figueiredoisaac.modulo_financeiro_api.repository

import figueiredoisaac.modulo_financeiro_api.model.Cartao
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CartaoRepository : JpaRepository<Cartao, Long> {
    // Aqui você pode adicionar métodos de consulta personalizados
}
