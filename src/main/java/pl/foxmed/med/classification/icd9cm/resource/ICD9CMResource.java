package pl.foxmed.med.classification.icd9cm.resource;

import pl.foxmed.med.classification.icd9cm.model.ICD9CM;
import pl.foxmed.med.classification.icd9cm.repository.ICD9CMRepository;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("ICD9CM/")
@Singleton
public class ICD9CMResource {
    private final ICD9CMRepository icd9cmRepository;

    @Inject
    public ICD9CMResource(ICD9CMRepository icd9cmRepository) {
        this.icd9cmRepository = icd9cmRepository;
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Path("{code}")
    public ICD9CM getICD9CM(@PathParam("code") String code) {
        ICD9CM byCode = icd9cmRepository.getByCode(code);
        if (byCode == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return byCode;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "International Statistical Classification of Diseases and Related Health Problems";
    }
}
