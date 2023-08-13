package ru.rogov.barservice.service.photo;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rogov.barservice.entity.Photo;
import ru.rogov.barservice.repo.PhotoRepo;

import java.util.List;

@Service
public class PhotoServiceImpl implements PhotoService {

    private final PhotoRepo photoRepo;

    @Autowired
    public PhotoServiceImpl(PhotoRepo photoRepo) {
        this.photoRepo = photoRepo;
    }

    @Override
    public List<Photo> findAllPhotos() {
        return photoRepo.findAll();
    }

    //FIX ERROR
    @Override
    public Photo findPhotoById(Long id) {
        return photoRepo.findById(id).orElseThrow();
    }

    @Override
    public Photo addPhoto(Photo photo) {
        return photoRepo.save(photo);
    }

    @Override
    public Photo updatePhoto(Long id,Photo photo) {
        Photo photoFromDB = findPhotoById(id);
        BeanUtils.copyProperties(photo, photoFromDB, "id");
        return photoRepo.save(photoFromDB);
    }

    @Override
    public Photo deletePhoto(Long id) {
        Photo photoById = findPhotoById(id);
        photoRepo.deleteById(id);
        return photoById;
    }
}
