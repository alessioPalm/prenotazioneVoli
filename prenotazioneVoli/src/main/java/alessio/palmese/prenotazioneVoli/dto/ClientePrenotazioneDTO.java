package alessio.palmese.prenotazioneVoli.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class ClientePrenotazioneDTO {

    private long idCliente;

    private long idPrenotazione;
}
