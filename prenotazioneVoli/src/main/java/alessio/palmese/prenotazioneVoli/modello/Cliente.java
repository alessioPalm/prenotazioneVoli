package alessio.palmese.prenotazioneVoli.modello;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity  @Data @NoArgsConstructor @AllArgsConstructor
public class Cliente {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "cliente", orphanRemoval = true)
    private List <Prenotazione> relazionePrenotazione;

}
