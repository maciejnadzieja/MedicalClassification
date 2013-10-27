package pl.foxmed.med.classification.icd10.model;

import org.junit.Test;
import pl.foxmed.med.classification.icd10.model.ICD10;

import static org.fest.assertions.Assertions.assertThat;

public class ICD10Test {
    @Test
    public void shouldCreateICD10FromString() throws Exception {
        ICD10 icd10 = ICD10.fromString("code,some illness, with description");
        assertThat(icd10.getCode()).isEqualTo("code");
        assertThat(icd10.getTitle()).isEqualTo("some illness, with description");
    }
}
