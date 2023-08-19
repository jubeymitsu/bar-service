package ru.rogov.barservice.storage;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class StoragePropertiesTest {

    @Test
    public void getLocation(){
        String location = "upload-dir";
        String actualResult = new StorageProperties().getLocation();
        assertThat(actualResult).isEqualTo(location);
    }

    @Test
    public void setLocation(){
        String newLocation = "another-dir";
        StorageProperties properties = new StorageProperties();
        properties.setLocation(newLocation);
        String actualResult = properties.getLocation();
        assertThat(actualResult).isEqualTo(newLocation);
    }

}