package by.intexsoft.vodmvi.assigment.service;

import by.intexsoft.vodmvi.assigment.api.dao.IProductDao;
import by.intexsoft.vodmvi.assigment.api.dao.model.Product;
import by.intexsoft.vodmvi.assigment.api.service.IProductService;
import by.intexsoft.vodmvi.assigment.api.service.dto.ProductSimpleDto;
import by.intexsoft.vodmvi.assigment.service.mapper.ProductMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductService implements IProductService {
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);
    private static final String PRODUCT_CREATION_MESSAGE = "New Product has bean created. id = %s.";
    private static final String PRODUCT_UPDATE_MESSAGE = "Product has bean updated. id = %s.";
    private static final String PRODUCT_DELETE_MESSAGE = "Product has bean deleted. id = %s.";

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
    public ProductSimpleDto getProductByName(String name) {
        return productMapper.productToSimpleDto(productDao.getByName(name));
    }

    @Override
    public ProductSimpleDto createNewProduct(ProductSimpleDto dto) {
        ProductSimpleDto newDto = productMapper.productToSimpleDto(productDao.save(productMapper.simpleDtoToProduct(dto)));
        logger.info(String.format(PRODUCT_CREATION_MESSAGE, newDto.getId()));
        return newDto;
    }

    @Override
    public ProductSimpleDto updateProduct(ProductSimpleDto dto) {
        ProductSimpleDto newDto = productMapper.productToSimpleDto(productDao.update(productMapper.simpleDtoToProduct(dto)));
        logger.info(String.format(PRODUCT_UPDATE_MESSAGE, newDto.getId()));
        return newDto;
    }

    @Override
    public ProductSimpleDto updateProductIgnoreNull(ProductSimpleDto dto) {
        Product product = productDao.getById(dto.getId());
        product = productMapper.updateProductFromSimpleDtoIgnoreNull(dto, product);

        ProductSimpleDto newDto = productMapper.productToSimpleDto(product);
        logger.info(String.format(PRODUCT_UPDATE_MESSAGE, newDto.getId()));
        return newDto;
    }

    @Override
    public Boolean deleteProductById(Long id) {
        Boolean result = productDao.deleteById(id);

        if (result) {
            logger.info(String.format(PRODUCT_DELETE_MESSAGE, id));
        }
        return result;
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
