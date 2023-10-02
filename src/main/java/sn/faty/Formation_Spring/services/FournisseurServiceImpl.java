package sn.faty.Formation_Spring.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.faty.Formation_Spring.dtos.requests.FournisseurRequest;
import sn.faty.Formation_Spring.dtos.responses.FournisseurResponse;
import sn.faty.Formation_Spring.entities.Fournisseur;
import sn.faty.Formation_Spring.repositories.FournisseurRepository;

import java.util.Optional;


@Data
@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class FournisseurServiceImpl implements  FournisseurService{

    private FournisseurRepository fournisseurRepository ;

    /**
     * @param fournisseur
     * @return
     */
    @Override
    public FournisseurResponse addFournisseur(FournisseurRequest fournisseur) {

        return
                FournisseurResponse.toDto(fournisseurRepository.save(FournisseurRequest.toEntity(fournisseur)));
    }

    /**
     * @return
     */
    @Override
    public Page<FournisseurResponse> allFournisseur(Pageable pageable) {

        return
                fournisseurRepository.findAllByEtat_True(pageable).map(FournisseurResponse::toDto);

    }

    /**
     * @param pageable
     * @return
     */
    @Override
    public Page<FournisseurResponse> allFournisseurByPage(Pageable pageable) {

           return  fournisseurRepository.findAll(pageable).map(FournisseurResponse::toDto) ;
    }

    /**
     * @param fournisseurRequest
     * @return
     */
    @Override
    public FournisseurResponse updateFournisseur(Long id,FournisseurRequest fournisseurRequest) {

        Fournisseur fournisseur= FournisseurRequest.toEntity(fournisseurRequest);

        //   log.debug("fournisseur {}", fournisseur);

        Optional<Fournisseur> fournisseurExistant= fournisseurRepository.findById(id);

               if(fournisseurExistant.isEmpty()){

                   throw  new RuntimeException("fournisseur non existant");
               }

               Fournisseur fournisseur1= fournisseurExistant.get() ;

               fournisseur1.setZone(fournisseurRequest.getZone());

               fournisseur1.setNom(fournisseurRequest.getNom());

          return
                  FournisseurResponse.toDto(fournisseurRepository.save(fournisseur1));
    }

    /**
     * @param id
     * @return
     */
    @Override
    @Transactional
    public Optional<FournisseurResponse> getFournisseurById(Long id) {

      return fournisseurRepository.findById(id).map(FournisseurResponse::toDto);

    }

    /**
     * @param id
     */
    @Override
    public void deleteFournisseurById(Long id) {

        Optional<Fournisseur> fournisseur= fournisseurRepository.findById(id);

        if (fournisseur.isEmpty()){

            throw new RuntimeException("Cet id nexiste pas ");
        }

        fournisseur.get().setEtat(false);

        fournisseurRepository.save(fournisseur.get());

    }
}
