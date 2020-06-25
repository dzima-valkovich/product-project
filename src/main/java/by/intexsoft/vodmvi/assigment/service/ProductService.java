package by.intexsoft.vodmvi.assigment.service;

import by.intexsoft.vodmvi.assigment.api.dao.IProductDao;
import by.intexsoft.vodmvi.assigment.api.dao.model.Product;
import by.intexsoft.vodmvi.assigment.api.service.IProductService;
import by.intexsoft.vodmvi.assigment.api.service.dto.ProductSimpleDto;
import by.intexsoft.vodmvi.assigment.service.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductService implements IProductService {
    private IProductDao productDao;
    private ProductMapper productMapper;

    @Override
    public List<ProductSimpleDto> getAllProducts() {
        return productMapper.productToSimpleDto(productDao.getAll());
    }

    @Override
    public List<ProductSimpleDto> getAllProducts(int limit) {
        return productMapper.productToSimpleDto(productDao.getAll(limit));
    }

    @Override
    public List<ProductSimpleDto> getAllProducts(int offset, int limit) {
        return productMapper.productToSimpleDto(productDao.getAll(offset, limit));
    }

    @Override
    public ProductSimpleDto getProductById(Long id) {
        return productMapper.productToSimpleDto(productDao.getById(id));
    }

    @Override
    public List<ProductSimpleDto> getProductsByIds(Long... ids) {
        return productMapper.productToSimpleDto(productDao.getByIds(ids));
    }

    @Override
    public List<ProductSimpleDto> getProductsByIds(int limit, Long... ids) {
        return productMapper.productToSimpleDto(productDao.getByIds(limit, ids));
    }

    @Override
    public List<ProductSimpleDto> getProductsByIds(int offset, int limit, Long... ids) {
        return productMapper.productToSimpleDto(productDao.getByIds(offset, limit, ids));
    }

    @Override
    public List<ProductSimpleDto> getProductsByName(String name) {
        return productMapper.productToSimpleDto(productDao.getByName(name));
    }

    @Override
    public ProductSimpleDto createNewProduct(ProductSimpleDto dto) {
        return productMapper.productToSimpleDto(productDao.save(productMapper.simpleDtoToProduct(dto)));
    }

    @Override
    public ProductSimpleDto updateProduct(ProductSimpleDto dto) {
        return productMapper.productToSimpleDto(productDao.update(productMapper.simpleDtoToProduct(dto)));
    }

    @Override
    public ProductSimpleDto updateProductIgnoreNull(ProductSimpleDto dto) {
        Product product = productDao.getById(dto.getId());
        product = productMapper.updateProductFromSimpleDtoIgnoreNull(dto, product);
        return productMapper.productToSimpleDto(product);
    }

    @Override
    public Boolean deleteProductById(Long id) {
        return productDao.deleteById(id);
    }

    @Autowired
    public void setProductDao(IProductDao productDao) {
        this.productDao = productDao;
    }

    @Autowired
    public void setProductMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }
}
