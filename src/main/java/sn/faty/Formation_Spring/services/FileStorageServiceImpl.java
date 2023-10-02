package sn.faty.Formation_Spring.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import sn.faty.Formation_Spring.entities.FileDB;
import sn.faty.Formation_Spring.repositories.FileDbRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.UUID;
import java.util.stream.Stream;


@Service
@Data
@AllArgsConstructor

public class FileStorageServiceImpl implements FilesStorageService{
    private FileDbRepository fileDbRepository ;


    @Value("${upload.dir}")

    private  String  pathDirectory ;

    @Autowired
    public FileStorageServiceImpl(FileDbRepository fileDbRepository) {
        this.fileDbRepository = fileDbRepository;
    }

    public FileStorageServiceImpl() {

    }

    private final Path root= Paths.get("uploads");

    /**
     *
     */
    @Override
    public void init()  {
   try
        {

            Files.createDirectories(root);

        }
   catch (IOException ioException){

       throw new RuntimeException("");
   }
    }

    /**
     * @param file
     */
    @Override
    public void save(MultipartFile file) {

        try {

            Files.copy(file.getInputStream(),this.root.resolve(file.getOriginalFilename()));
        }
           catch (IOException e) {

            if(e instanceof FileAlreadyExistsException){

                 throw new RuntimeException("un fichier de ce type existe deja");
            }

             throw new RuntimeException(e.getMessage());
        }

    }

    /**
     * @param filename
     * @return
     */
    @Override
    public Resource load(String filename) {
        return null;
    }

    /**
     *
     */
    @Override
    public void deleteAll() {

        FileSystemUtils.deleteRecursively(root.toFile());
    }

    /**
     * @return
     */
    @Override
    public Stream<Path> loadAll() {
        return null;
    }

    /**
     * @param file
     * @return
     */
    @Override
    public FileDB store(MultipartFile file,String nom) throws IOException {

        File directory=new File(pathDirectory);

          if(!directory.exists()){

              directory.mkdirs();
          }

          // Generation d'un nom de fichier unique

          String fileName= UUID.randomUUID() + "-" + file.getOriginalFilename();

          Path path=Paths.get(pathDirectory, fileName);

          Files.copy(file.getInputStream(),path);

          //Enregistrement de l'url dans la base

          String url = "/uploads" + fileName ;

          FileDB fileDB= new FileDB();

          fileDB.setUrl(url);

          fileDB.setName(nom);

           return  fileDbRepository.save(fileDB);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public FileDB getFileById(Long id) {

        return fileDbRepository.findById(id).orElse(null);

    }

    /**
     * @return
     */
    @Override
    public Stream<FileDB> getAllFille() {
        return null;
    }
}
