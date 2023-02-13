package alessio.palmese.prenotazioneVoli;

import alessio.palmese.prenotazioneVoli.VoloRepository;
import alessio.palmese.prenotazioneVoli.modello.Prenotazione;
import alessio.palmese.prenotazioneVoli.modello.Volo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VoloService {

    @Autowired
    private VoloRepository voloRepository;

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;


    public void inserimento (Volo volo){

        voloRepository.save(volo);
    }

    public List<Volo> findAllVolo(){
        return voloRepository.findAll();
    }

    public Volo findById (long id) {
        return voloRepository.findById(id).get();
    }

    public void elimina (long id){
        voloRepository.deleteById(id);
    }

    public void modifica (long id, String luogoPartenza, String luogoArrivo, LocalDateTime dataPartenza, LocalDateTime dataArrivo){
        Volo volo = voloRepository.findById(id).get();
        volo.setId(id);
        volo.setDataDiArrivo(dataArrivo);
        volo.setLuogoArrivo(luogoArrivo);
        volo.setDataDiPartenza(dataPartenza);
        volo.setLuogoPartenza(luogoPartenza);
        voloRepository.save(volo);
    }

    public void aggiungiPrenotazione(long id, long idPrenotazione){
        Prenotazione prenotazione = prenotazioneRepository.findById(idPrenotazione).get();
        Volo volo = voloRepository.findById(id).get();

        volo.getRelazioneVoloPrenotazione().add(prenotazione);
        voloRepository.save(volo);
    }
}
