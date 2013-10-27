package pl.foxmed.med.classification.icd9cm.repository;

import com.google.common.collect.Lists;
import org.junit.Test;
import pl.foxmed.med.classification.icd9cm.model.ICD9CM;

import static org.fest.assertions.Assertions.assertThat;

public class ICD9CMInMemoryRepositoryTest {
    @Test
    public void shouldReturnICD10ByCode() throws Exception {
        ICD9CM icd9 = new ICD9CM("some code", Lists.newArrayList("section", "subSection", "category", "subCategory"));
        assertThat(new ICD9CMInMemoryRepository(Lists.newArrayList(icd9)).getByCode("some code")).isEqualTo(icd9);
    }

    @Test
    public void shouldReturnNullWhenCodeNotFound() throws Exception {
        assertThat(new ICD9CMInMemoryRepository(Lists.<ICD9CM>newLinkedList()).getByCode("not existing code")).isEqualTo(null);
    }
}
