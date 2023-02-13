package alessio.palmese.prenotazioneVoli;

import alessio.palmese.prenotazioneVoli.modello.Volo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoloRepository extends JpaRepository<Volo, Long> {
}
