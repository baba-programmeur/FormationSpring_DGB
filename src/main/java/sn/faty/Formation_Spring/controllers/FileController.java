package sn.faty.Formation_Spring.controllers;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sn.faty.Formation_Spring.dtos.responses.ResponseMessage;
import sn.faty.Formation_Spring.entities.FileDB;
import sn.faty.Formation_Spring.services.FilesStorageService;

import java.io.IOException;

@RestController
@RequestMapping("/api/data")
@Data
public class FileController {
    private FilesStorageService filesStorageService ;

    @Autowired
    public FileController(FilesStorageService filesStorageService) {
        this.filesStorageService = filesStorageService;
    }

    @PostMapping("/upload")

    public ResponseEntity<ResponseMessage> addFile(@RequestParam("file") MultipartFile file, @RequestParam String nom ){

        String message="";

        try {

            filesStorageService.store(file,nom);

            message="fichier "  + file.getOriginalFilename()+ "charge avec sucès";

         return  ResponseEntity.status(HttpStatus.CREATED).body(new ResponseMessage(message));

        } catch (IOException e) {

            message="fichier" +file.getOriginalFilename()+ "non uploaded";

            return new ResponseEntity<>(new ResponseMessage(message), HttpStatus.EXPECTATION_FAILED);
        }

    }

    @GetMapping("/{id}")

    public ResponseEntity<?> getPhotoById(@PathVariable(name= "id") Long id){

     FileDB fileDB= filesStorageService.getFileById(id);

        if(fileDB != null){

            return ResponseEntity.status(HttpStatus.ACCEPTED).body(fileDB);
        }

         return ResponseEntity.notFound().build();

    }

}
