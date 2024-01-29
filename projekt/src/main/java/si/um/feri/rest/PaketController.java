package si.um.feri.rest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import si.um.feri.dao.PaketRepository;
import si.um.feri.dto.PaketDto;
import si.um.feri.vao.Paket;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;


@Path("/paketi")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PaketController {

    private static final Logger log = Logger.getLogger(PaketController.class.getName());

    @Inject
    PaketRepository paketRepository;

    @GET
    public List<PaketDto> vseOsebe() {
        return paketRepository.listAll()
                .stream()
                .map(Paket::toDto)
                .collect(Collectors.toList());
    }


    @POST
    @Transactional
    public Response postOseba(PaketDto dto) {
        Paket paket = new Paket(dto);
        paketRepository.persist(paket);
        return Response.ok(paket.toDto()).status(Response.Status.CREATED).build();
    }


}
