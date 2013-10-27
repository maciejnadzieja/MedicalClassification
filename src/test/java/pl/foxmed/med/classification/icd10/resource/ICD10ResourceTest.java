package pl.foxmed.med.classification.icd10.resource;

import org.junit.Test;
import pl.foxmed.med.classification.icd10.model.ICD10;
import pl.foxmed.med.classification.icd10.repository.ICD10Repository;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import static junit.framework.TestCase.fail;
import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ICD10ResourceTest {
    @Test
    public void should_Throw_404_When_ICD10_Is_Null() throws Exception {
        ICD10Repository icd10Repository = mock(ICD10Repository.class);
        when(icd10Repository.getByCode(anyString())).thenReturn(null);

        ICD10Resource icd10Resource = new ICD10Resource(icd10Repository);

        try {
            icd10Resource.getICD10("some icd10 code");
            fail("should throw exception");
        } catch (WebApplicationException e) {
            assertThat(e.getResponse().getStatus()).isEqualTo(Response.Status.NOT_FOUND.getStatusCode());
        }
    }

    @Test
    public void should_Return_ICD10_When_Found_ByCode() throws Exception {
        ICD10Repository icd10Repository = mock(ICD10Repository.class);
        ICD10 icd10 = new ICD10("some code", "some illness title");
        when(icd10Repository.getByCode(anyString())).thenReturn(icd10);

        ICD10Resource icd10Resource = new ICD10Resource(icd10Repository);

        assertThat(icd10).isEqualTo(icd10Resource.getICD10("some code"));
    }

}
