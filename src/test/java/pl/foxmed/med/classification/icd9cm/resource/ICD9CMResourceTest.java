package pl.foxmed.med.classification.icd9cm.resource;

import com.google.common.collect.Lists;
import org.junit.Test;
import pl.foxmed.med.classification.icd9cm.model.ICD9CM;
import pl.foxmed.med.classification.icd9cm.repository.ICD9CMRepository;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import static junit.framework.Assert.fail;
import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ICD9CMResourceTest {
    @Test
    public void shouldThrow404WhenICD9CMIsNull() throws Exception {
        ICD9CMRepository icd9CMRepository = mock(ICD9CMRepository.class);
        when(icd9CMRepository.getByCode(anyString())).thenReturn(null);

        ICD9CMResource icd9CMResource = new ICD9CMResource(icd9CMRepository);

        try {
            icd9CMResource.getICD9CM("some icd9cm code");
            fail("should throw exception");
        } catch (WebApplicationException e) {
            assertThat(e.getResponse().getStatus()).isEqualTo(Response.Status.NOT_FOUND.getStatusCode());
        }
    }

    @Test
    public void shouldReturnICD9WhenFoundByCode() throws Exception {
        ICD9CMRepository icd9CMRepository = mock(ICD9CMRepository.class);
        ICD9CM icd9 = new ICD9CM("some code", Lists.newArrayList("a", "b", "c", "d"));
        when(icd9CMRepository.getByCode(anyString())).thenReturn(icd9);

        ICD9CMResource icd9CMResource = new ICD9CMResource(icd9CMRepository);

        assertThat(icd9).isEqualTo(icd9CMResource.getICD9CM("some code"));
    }
}
