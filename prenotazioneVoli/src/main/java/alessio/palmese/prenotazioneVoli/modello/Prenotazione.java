package alessio.palmese.prenotazioneVoli.modello;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate data;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Volo volo;
}
