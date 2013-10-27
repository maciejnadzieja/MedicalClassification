package pl.foxmed.med.classification.icd10.repository;

import com.google.common.collect.Lists;
import org.junit.Test;
import pl.foxmed.med.classification.icd10.model.ICD10;

import static org.fest.assertions.Assertions.assertThat;

public class ICD10InMemoryRepositoryTest {
    @Test
    public void shouldReturnICD10ByCode() throws Exception {
        ICD10 icd10 = new ICD10("some code", "some title");
        assertThat(new ICD10InMemoryRepository(Lists.newArrayList(icd10)).getByCode("some code")).isEqualTo(icd10);
    }

    @Test
    public void shouldReturnNullWhenCodeNotFound() throws Exception {
        assertThat(new ICD10InMemoryRepository(Lists.<ICD10>newLinkedList()).getByCode("not existing code")).isEqualTo(null);
    }
}
