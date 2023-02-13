package alessio.palmese.prenotazioneVoli;

import alessio.palmese.prenotazioneVoli.modello.Prenotazione;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrenotazioneService {
    
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;


    public void inserimento (Prenotazione prenotazione){

        prenotazioneRepository.save(prenotazione);
    }

    public List<Prenotazione> findAllPrenotazione(){
        return prenotazioneRepository.findAll();
    }

    public Prenotazione findById (long id) {
        return prenotazioneRepository.findById(id).get();
    }

    public void elimina (long id){
        prenotazioneRepository.deleteById(id);
    }

    public void modifica (long id, LocalDate data){
        Prenotazione prenotazione = prenotazioneRepository.findById(id).get();
        prenotazione.setData(data);
        prenotazioneRepository.save(prenotazione);
    }
}
