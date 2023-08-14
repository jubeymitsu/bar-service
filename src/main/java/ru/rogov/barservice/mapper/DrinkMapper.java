package ru.rogov.barservice.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.rogov.barservice.dto.DrinkDTO;
import ru.rogov.barservice.entity.Drink;
import ru.rogov.barservice.entity.Photo;
import ru.rogov.barservice.storage.StorageService;

@Component
public class DrinkMapper {

    @Autowired
    StorageService storageService;

    public Drink DTOtoEntity(DrinkDTO drinkDTO) {
        Drink drink = new Drink();
        drink.setName(drinkDTO.getName());
        drink.setAvailable(true);
        drink.setDescription(drinkDTO.getDescription());
        drink.setContent(drinkDTO.getContent());

        String photoFileName = drinkDTO.getPhoto().getOriginalFilename();
        String photoUri = storageService // String photo URI to store in database
                .load(photoFileName)
                .toUri()
                .toString();

        Photo photo = new Photo();
        photo.setTitle(photoFileName);
        photo.setImageUri(photoUri);

        drink.setPhoto(photo);

        return drink;
    }
}
