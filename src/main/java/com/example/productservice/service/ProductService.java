package com.example.productservice.service;

import com.example.productservice.VO.ResponseTemplateVO;
import com.example.productservice.VO.Users;
import com.example.productservice.entity.Product;
import com.example.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RestTemplate restTemplate;
    public Product saveProduct(Product product) {

        return productRepository.save(product);
    }

    public ResponseTemplateVO getProductWithUsers(Long productId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Product product = productRepository.findByProductId(productId);
        Users user = restTemplate.getForObject("http://localhost:3001/user/"+product.getUserId(),Users.class);
        vo.setProduct(product);
        vo.setUsers(user);
        return vo;
    }
}
