package cl.ferremas.db.ms_productos_db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cl.ferremas.db.ms_productos_db.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    // JpaRepository ya incluye métodos básicos CRUD
}
