package si.um.feri.vao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import si.um.feri.dto.PaketDto;


@Entity
@Data
@NoArgsConstructor
public class Paket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Vrsta vrsta;
    private Podvrsta podvrsta;

    private String opis;
    private int poraba, cena;

    public Paket(PaketDto dto){
        setVrsta(dto.vrsta());
        setPodvrsta(dto.podvrsta());
        setOpis(dto.opis());
        setPoraba(dto.poraba());
        setCena(dto.cena());
    }

    public void updateForm(PaketDto dto){
        setVrsta(dto.vrsta());
        setPodvrsta(dto.podvrsta());
        setOpis(dto.opis());
        setPoraba(dto.poraba());
        setCena(dto.cena());
    }

    public PaketDto toDto(){
        return new PaketDto(id, vrsta, podvrsta, opis, poraba, cena);
    }



}
