package com.example.Drones.persistance.model;


import com.example.Drones.web.dto.ImageDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.nio.charset.StandardCharsets;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImageModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String type;
    @Lob
    private byte[] image;

    public ImageModel(String originalFilename, String contentType, byte[] bytes) {

        this.name = originalFilename;
        this.type = contentType;
        this.image= bytes;
    }


    public ImageModel(ImageDto image){
        this.name = image.name();
        this.type = image.type();
        this.image = image.image().getBytes(StandardCharsets.UTF_8);
    }

}
