package alessio.palmese.prenotazioneVoli;

import alessio.palmese.prenotazioneVoli.modello.Cliente;
import alessio.palmese.prenotazioneVoli.modello.Prenotazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public void inserimento (Cliente cliente){

        clienteRepository.save(cliente);
    }

    public List<Cliente> findAllClienti(){
        return clienteRepository.findAll();
    }

    public Cliente findById (long id) {
        return clienteRepository.findById(id).get();
    }

    public void elimina (long id){
        clienteRepository.deleteById(id);
    }

    public void modifica (long id, String nome){
        Cliente cliente = clienteRepository.findById(id).get();
        cliente.setNome(nome);
        clienteRepository.save(cliente);
    }

    public void aggiungiPrenotazione (long id, long idPrenotazione){
        Cliente cliente = clienteRepository.findById(id).get();
        Prenotazione prenotazione = prenotazioneRepository.findById(idPrenotazione).get();

        cliente.getRelazionePrenotazione().add(prenotazione);
        clienteRepository.save(cliente);
    }
}
