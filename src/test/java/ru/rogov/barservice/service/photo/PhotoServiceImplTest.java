package ru.rogov.barservice.service.photo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.rogov.barservice.entity.Photo;
import ru.rogov.barservice.repo.PhotoRepo;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class PhotoServiceImplTest {

    @InjectMocks
    private PhotoServiceImpl photoService;
    @Mock
    private PhotoRepo photoRepo;

    @Test
    void findAllPhotos() {
        Photo photo1 = new Photo();
        Photo photo2 = new Photo();
        Photo photo3 = new Photo();

        photo1.setTitle("photo1");
        photo2.setTitle("photo2");
        photo3.setTitle("photo3");


        Mockito.when(photoRepo.findAll()).thenReturn(List.of(photo1, photo2, photo3));

        List<Photo> allPhotos = photoService.findAllPhotos();

        assertEquals(3, allPhotos.size());
    }

    @Test
    void findPhotoById() {
    }

    @Test
    void addPhoto() {
    }

    @Test
    void updatePhoto() {
    }

    @Test
    void deletePhoto() {
    }
}