package alessio.palmese.prenotazioneVoli;

import alessio.palmese.prenotazioneVoli.modello.Prenotazione;
import alessio.palmese.prenotazioneVoli.modello.Volo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping(path = "/prenotazione")
public class PrenotazioneController {

    @Autowired
    private PrenotazioneService prenotazioneService;

    @PostMapping(path = "")
    public void inserimento(@RequestBody Prenotazione prenotazione){
        prenotazioneService.inserimento(prenotazione);
    }

    @GetMapping(path = "")
    public List<Prenotazione> findAllVolo(){
        return prenotazioneService.findAllPrenotazione();
    }

    @GetMapping (path = "/{id}")
    public Prenotazione findVoloById(@RequestParam long id){
        return prenotazioneService.findById(id);
    }

    @DeleteMapping(path = "/{id}")
    public void elimina(@RequestBody long id){
        prenotazioneService.elimina(id);
    }

    @PutMapping (path = "/{id}")
    public void modifica(@RequestBody int id, LocalDate data){

        prenotazioneService.modifica(id, data);
    }

}
