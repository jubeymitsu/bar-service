package ru.rogov.barservice.dto;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Data
@Component
public class DrinkDTO {

    private String name;

    private String content;

    private MultipartFile photo;

    private String description;

    private boolean available;

}
