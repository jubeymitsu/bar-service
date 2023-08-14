package ru.rogov.barservice.service.photo;

import ru.rogov.barservice.entity.Photo;

import java.util.List;

public interface PhotoService {

    List<Photo> findAllPhotos();
    Photo findPhotoById(Long id);
    Photo addPhoto(Photo photo);
    Photo updatePhoto(Long id, Photo photo);
    Photo deletePhoto(Long id);
}
