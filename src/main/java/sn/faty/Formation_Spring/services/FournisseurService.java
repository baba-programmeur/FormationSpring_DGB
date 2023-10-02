package sn.faty.Formation_Spring.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sn.faty.Formation_Spring.dtos.requests.FournisseurRequest;
import sn.faty.Formation_Spring.dtos.responses.FournisseurResponse;

import java.util.List;
import java.util.Optional;

public interface FournisseurService {

    FournisseurResponse addFournisseur(FournisseurRequest fournisseur);

    Page<FournisseurResponse> allFournisseur(Pageable pageable);

    Page<FournisseurResponse> allFournisseurByPage(Pageable pageable);

    FournisseurResponse  updateFournisseur(Long id, FournisseurRequest fournisseurRequest);

Optional<FournisseurResponse> getFournisseurById(Long id);

     void deleteFournisseurById(Long id);
}
