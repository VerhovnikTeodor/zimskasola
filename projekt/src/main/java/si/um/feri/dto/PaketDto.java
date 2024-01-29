package si.um.feri.dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import si.um.feri.vao.Podvrsta;
import si.um.feri.vao.Vrsta;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public record PaketDto(Long id, Vrsta vrsta, Podvrsta podvrsta, String opis, int cena, int poraba) {

}
