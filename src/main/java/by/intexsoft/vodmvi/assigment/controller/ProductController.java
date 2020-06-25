package by.intexsoft.vodmvi.assigment.controller;

import by.intexsoft.vodmvi.assigment.api.service.IProductService;
import by.intexsoft.vodmvi.assigment.api.service.dto.ProductSimpleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private IProductService productService;

    @GetMapping("{id}")
    public ProductSimpleDto getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("ids/{ids}")
    public List<ProductSimpleDto> getProductsByIds(@PathVariable Long[] ids,
                                                   @RequestParam(defaultValue = "0") Integer offset,
                                                   @RequestParam(defaultValue = "10") Integer limit) {
        return productService.getProductsByIds(offset, limit, ids);
    }

    @GetMapping
    public List<ProductSimpleDto> getAllProducts(@RequestParam(defaultValue = "0") Integer offset,
                                                 @RequestParam(defaultValue = "10") Integer limit) {
        return productService.getAllProducts(offset, limit);
    }

    @GetMapping("byName")
    public List<ProductSimpleDto> getProductsByName(@RequestParam(required = false) String name) {
        return productService.getProductsByName(name);
    }

    @PostMapping
    public ProductSimpleDto createNewProduct(@RequestBody ProductSimpleDto dto) {
        return productService.createNewProduct(dto);
    }

    @PutMapping
    public ProductSimpleDto updateProduct(@RequestBody ProductSimpleDto dto) {
        return productService.updateProduct(dto);
    }

    @PatchMapping
    public ProductSimpleDto updateProductIgnoreNull(@RequestBody ProductSimpleDto dto) {
        return productService.updateProductIgnoreNull(dto);
    }

    @DeleteMapping("{id}")
    public Boolean deleteProductById(@PathVariable Long id) {
        return productService.deleteProductById(id);
    }

    @Autowired
    public void setProductService(IProductService productService) {
        this.productService = productService;
    }
}
