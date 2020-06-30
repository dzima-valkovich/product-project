package by.intexsoft.vodmvi.assigment.api.service;

import by.intexsoft.vodmvi.assigment.api.service.dto.ProductSimpleDto;

import java.util.List;

public interface IProductService {
    List<ProductSimpleDto> getAllProducts();

    List<ProductSimpleDto> getAllProducts(int limit);

    List<ProductSimpleDto> getAllProducts(int offset, int limit);

    ProductSimpleDto getProductById(Long id);

    List<ProductSimpleDto> getProductsByIds(Long... ids);

    List<ProductSimpleDto> getProductsByIds(int limit, Long... ids);

    List<ProductSimpleDto> getProductsByIds(int offset, int limit, Long... ids);

    ProductSimpleDto getProductByName(String name);

    ProductSimpleDto createNewProduct(ProductSimpleDto dto);

    ProductSimpleDto updateProduct(ProductSimpleDto dto);

    ProductSimpleDto updateProductIgnoreNull(ProductSimpleDto dto);

    Boolean deleteProductById(Long id);

    Boolean deleteProductByName(String name);
}
