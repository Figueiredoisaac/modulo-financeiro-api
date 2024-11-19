package figueiredoisaac.modulo_financeiro_api.service

import figueiredoisaac.modulo_financeiro_api.dto.CategoriaDto
import figueiredoisaac.modulo_financeiro_api.model.Categoria
import figueiredoisaac.modulo_financeiro_api.repository.CategoriaRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class CategoriaService(private val categoriaRepository: CategoriaRepository) {

    fun salvarCategoria(categoriaDto: CategoriaDto): ResponseEntity<Categoria> {
        return try {
            ResponseEntity.ok(categoriaRepository.save(categoriaDto.toCategoria()))
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    fun listarCategorias(): ResponseEntity<List<Categoria>> {
        return try {
            ResponseEntity.ok(categoriaRepository.findAll())
        }
        catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    fun deletarCategoria(idCategoria: Long): ResponseEntity<Categoria> {
        return try {
            val categoria = categoriaRepository.findById(idCategoria).get()
            categoriaRepository.delete(categoria)
            ResponseEntity.ok(categoria)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    fun atualizarCategoria(dto: CategoriaDto, idCategoria: Long): ResponseEntity<Categoria> {
        return try {
            val categoria = categoriaRepository.save(
                dto.updateCategoria(categoriaRepository.findById(idCategoria).get())
            )
            ResponseEntity.ok(categoria)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }
}
