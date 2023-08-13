package ru.rogov.barservice.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rogov.barservice.entity.Drink;
import ru.rogov.barservice.entity.Photo;
import ru.rogov.barservice.service.photo.PhotoService;

import java.util.List;

@RestController
@RequestMapping("/photos")
public class PhotoController {

    private final PhotoService photoService;

    @Autowired
    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping("/all")
    public List<Photo> getAllPhotos() {
        return photoService.findAllPhotos();
    }

    @GetMapping("/{id}")
    public Photo getPhoto(@PathVariable Long id) {
        return photoService.findPhotoById(id);
    }

    @PostMapping("/add")
    public Photo addPhoto(@RequestBody @Valid Photo photo) {
        return photoService.addPhoto(photo);
    }

    @PutMapping("/{id}")
    public Photo updatePhoto(@PathVariable Long id,
                             @RequestBody Photo photo) {
        return photoService.updatePhoto(id, photo);
    }

    @DeleteMapping("/{id}")
    public Photo deletePhoto(@PathVariable Long id){
        return photoService.deletePhoto(id);
    }
}
