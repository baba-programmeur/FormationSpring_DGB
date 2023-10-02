package sn.faty.Formation_Spring.controllers;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.faty.Formation_Spring.dtos.requests.FournisseurRequest;
import sn.faty.Formation_Spring.dtos.responses.FournisseurResponse;
import sn.faty.Formation_Spring.services.FournisseurService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fournisseur")

public class FournisseurController {

    private FournisseurService fournisseurService ;

    @Autowired
    public FournisseurController(FournisseurService fournisseurService) {
        this.fournisseurService = fournisseurService;
    }

    @PostMapping("/add")
    public ResponseEntity<FournisseurResponse> add(@RequestBody FournisseurRequest fournisseur){

        return new ResponseEntity<>(fournisseurService.addFournisseur(fournisseur),HttpStatus.CREATED);

    }

    @GetMapping("/all")
    public ResponseEntity<Page<FournisseurResponse>>  getAllFournisseur(Pageable pageable){

        return ResponseEntity.ok().body(fournisseurService.allFournisseur(pageable));

    }

//    @GetMapping("/allByPage")
//    public ResponseEntity<Page<FournisseurResponse>>  getAllFournisseurByPage(Pageable pageable){
//
//        return ResponseEntity.ok().body(fournisseurService.allFournisseurByPage(pageable));
//
//    }


    @GetMapping("/{id}")

    public ResponseEntity<Optional<FournisseurResponse>> getAllFournisseurByPage(@PathVariable Long id){

        return
                ResponseEntity.ok().body(fournisseurService.getFournisseurById(id));

    }

    @DeleteMapping("/{id}")

    public void deleteFournisseurById(@PathVariable Long id){

         fournisseurService.deleteFournisseurById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<FournisseurResponse> updateFournisseur(@RequestBody FournisseurRequest fournisseurRequest,@PathVariable(name = "id") Long id ){

   return
           new ResponseEntity<>(fournisseurService.updateFournisseur(id,fournisseurRequest),HttpStatus.CREATED);

    }
}
