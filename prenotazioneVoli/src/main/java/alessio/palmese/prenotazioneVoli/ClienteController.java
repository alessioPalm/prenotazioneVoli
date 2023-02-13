package alessio.palmese.prenotazioneVoli;

import alessio.palmese.prenotazioneVoli.dto.ClientePrenotazioneDTO;
import alessio.palmese.prenotazioneVoli.modello.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/cliente")
public class ClienteController {


    @Autowired
    private ClienteService clienteService;

    @PostMapping(path = "")
    public void inserimento(@RequestBody Cliente cliente){
        clienteService.inserimento(cliente);
    }

    @GetMapping(path = "")
    public List<Cliente> findAllAtleti(){
        return clienteService.findAllClienti();
    }

    @GetMapping (path = "/{id}")
    public Cliente findAtletaById(@RequestParam long id){
        return clienteService.findById(id);
    }

    @DeleteMapping (path = "/{id}")
    public void elimina(@RequestBody long id){
        clienteService.elimina(id);
    }

    @PutMapping (path = "/{id}")
    public void modifica(@RequestBody long id, String nome){
        clienteService.modifica(id, nome);
    }
    @PostMapping(path = "/aggiungiPrenotazione")
    public void aggiungiPrenotazione (@RequestBody @Valid ClientePrenotazioneDTO clientePrenotazioneDTO){
        clienteService.aggiungiPrenotazione(clientePrenotazioneDTO.getIdCliente(), clientePrenotazioneDTO.getIdPrenotazione());
    }

}
