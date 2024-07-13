package org.example.first_api.dtos;

import lombok.Data;
import org.example.first_api.models.Category;
@Data
public class FakeProductServiceDto {
    private long id;
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;
}
