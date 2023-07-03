package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Train;
import tn.esprit.spring.entities.Voyage;
import tn.esprit.spring.repository.TrainRepository;
import tn.esprit.spring.repository.VoyageRepository;

import java.util.List;

@Service
public class VoyageServiceImpl implements IVoyageService {
    @Autowired
    VoyageRepository voyageRepository;
    @Autowired
    TrainRepository trainRepository;
    @Override
    public void ajouterVoyage(Voyage v) {
        voyageRepository.save(v);
    }

    @Override
    public void modifierVoyage(Voyage v) {
		voyageRepository.save(v);
    }


 public void affecterTrainAVoyage(Long idTrain, Long idVoyage) {
    Optional<Train> optionalTrain = trainRepository.findById(idTrain);
    Optional<Voyage> optionalVoyage = voyageRepository.findById(idVoyage);

    if (optionalTrain.isPresent() && optionalVoyage.isPresent()) {
        Train t = optionalTrain.get();
        Voyage v = optionalVoyage.get();
        v.setTrain(t);
        voyageRepository.save(v);
    } else {
        // Handle the case when the optional values are not present (e.g., throw an exception or log an error)
    }
}


    @Override
    public List<Voyage> recupererAll() {
        List<Voyage> list = (List<Voyage>) voyageRepository.findAll();
        return list;
    }

    @Override
    public Voyage recupererVoyageParId(long idVoyage) {
        Voyage v = voyageRepository.findById(idVoyage).orElse(null);
        return v;
    }

    @Override
    public void supprimerVoyage(Voyage v) {
        //TODO method
    }

}
