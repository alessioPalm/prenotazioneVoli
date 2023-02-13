package alessio.palmese.prenotazioneVoli;

import alessio.palmese.prenotazioneVoli.dto.VoloPrenotazioneDTO;
import alessio.palmese.prenotazioneVoli.modello.Cliente;
import alessio.palmese.prenotazioneVoli.modello.Volo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
@RestController
@RequestMapping(path = "/volo")
public class VoloController {

    @Autowired
    private VoloService voloService;

    @PostMapping(path = "")
    public void inserimento(@RequestBody Volo volo){
        voloService.inserimento(volo);
    }

    @GetMapping(path = "")
    public List<Volo> findAllVolo(){
        return voloService.findAllVolo();
    }

    @GetMapping (path = "/{id}")
    public Volo findVoloById(@RequestParam long id){
        return voloService.findById(id);
    }

    @DeleteMapping(path = "/{id}")
    public void elimina(@RequestBody long id){
        voloService.elimina(id);
    }

    @PutMapping (path = "/{id}")
    public void modifica(@RequestBody int id, String luogoPartenza, String luogoArrivo, LocalDateTime dataPartenza, LocalDateTime dataArrivo){

        voloService.modifica(id, luogoPartenza, luogoArrivo, dataPartenza, dataArrivo);
    }

    @PostMapping(path = "/aggiungiPrenotazione")
    public void aggiungiPrenotazione(@RequestBody @Valid VoloPrenotazioneDTO voloPrenotazioneDTO){
        voloService.aggiungiPrenotazione(voloPrenotazioneDTO.getIdVolo(), voloPrenotazioneDTO.getIdPrenotazione());
    }
}
