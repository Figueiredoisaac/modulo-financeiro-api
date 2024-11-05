package figueiredoisaac.modulo_financeiro_api.repository

import figueiredoisaac.modulo_financeiro_api.model.Categoria
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoriaRepository : JpaRepository<Categoria, Long> {
    // Adicione métodos para consultas específicas aqui
}
