package sn.faty.Formation_Spring.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import sn.faty.Formation_Spring.entities.FileDB;


public interface FilesStorageService {

    public void init() throws IOException;

    public void save(MultipartFile file);

    public Resource load(String filename);

    public void deleteAll();

    public Stream<Path> loadAll();



     FileDB store(MultipartFile file, String nom) throws IOException;

     FileDB getFileById(Long id);

     Stream<FileDB> getAllFille();

}
