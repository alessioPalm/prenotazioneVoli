package alessio.palmese.prenotazioneVoli.modello;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Volo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String luogoPartenza;
    private String luogoArrivo;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataDiPartenza;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime dataDiArrivo;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "volo")
    private List<Prenotazione> relazioneVoloPrenotazione;


}
