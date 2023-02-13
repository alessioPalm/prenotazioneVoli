package alessio.palmese.prenotazioneVoli;

import alessio.palmese.prenotazioneVoli.modello.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
}
