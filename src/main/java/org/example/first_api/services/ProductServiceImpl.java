package org.example.first_api.services;

import org.example.first_api.dtos.FakeProductServiceDto;
import org.example.first_api.models.Category;
import org.example.first_api.models.Product;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{
private final WebClient webClient;
     public ProductServiceImpl(WebClient.Builder webClientBuilder) {
         this.webClient = webClientBuilder.baseUrl("https://fakestoreapi.com/")
                 .build();
     }
    public static Product mapToProduct(FakeProductServiceDto productServiceDto) {
        Product product = new Product();
        product.setId(productServiceDto.getId());
        product.setTitle(productServiceDto.getTitle());
        product.setPrice(productServiceDto.getPrice());
        product.setDescription(productServiceDto.getDescription());
        product.setImage(productServiceDto.getImage());
        Category category = new Category();
        category.setName(productServiceDto.getCategory());
        product.setCategory(category);
        return product;
    }
    @Override
    public Product getProduct(long id) {
        System.out.println("getting data");
    FakeProductServiceDto productServiceDto =webClient.get()
            .uri("/products/{id}", id)
            .retrieve()
            .bodyToMono(FakeProductServiceDto.class)
            .block();
        System.out.println("got data");

    return mapToProduct(productServiceDto);

    }
    @Override
    public List<Product> getProducts() {
        Mono<FakeProductServiceDto[]> response = webClient.get().uri("/products")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(FakeProductServiceDto[].class).log();
        FakeProductServiceDto[] readers = response.block();
        return Arrays.stream(readers)
                .map(ProductServiceImpl::mapToProduct)
                .collect(Collectors.toList());
//        return Arrays.asList(readers);
    }
}
