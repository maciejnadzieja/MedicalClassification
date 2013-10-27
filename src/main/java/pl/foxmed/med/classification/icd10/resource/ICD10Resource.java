package pl.foxmed.med.classification.icd10.resource;

import pl.foxmed.med.classification.icd10.model.ICD10;
import pl.foxmed.med.classification.icd10.repository.ICD10Repository;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("ICD10/")
@Singleton
public class ICD10Resource {

    @Inject
    public ICD10Resource(ICD10Repository icd10Repository) {
        this.icd10Repository = icd10Repository;
    }

    private final ICD10Repository icd10Repository;

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Path("{code}")
    public ICD10 getICD10(@PathParam("code") String code) {
        ICD10 icd10 = icd10Repository.getByCode(code);
        if (icd10 == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        return icd10;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "International Statistical Classification of Diseases and Related Health Problems";
    }
}
