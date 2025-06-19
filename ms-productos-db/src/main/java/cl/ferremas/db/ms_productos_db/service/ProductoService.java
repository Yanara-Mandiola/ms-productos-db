package cl.ferremas.db.ms_productos_db.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import cl.ferremas.db.ms_productos_db.model.Producto;
import cl.ferremas.db.ms_productos_db.repository.ProductoRepository;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    // Constructor inyectando el repositorio
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    // Obtener todos los productos
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    // Obtener producto por id
    public Optional<Producto> getProductoById(Integer id) {
        return productoRepository.findById(id);
    }

    // Guardar nuevo producto o actualizar
    public Producto saveProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    // Eliminar producto por id
    public void deleteProductoById(Integer id) {
        productoRepository.deleteById(id);
    }
}
