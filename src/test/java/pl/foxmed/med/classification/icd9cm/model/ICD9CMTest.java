package pl.foxmed.med.classification.icd9cm.model;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class ICD9CMTest {
    @Test
    public void shouldCreateICD9CMFromString() throws Exception {
        ICD9CM procedure = ICD9CM.fromString("code, section -> subSection -> category -> subCategory");

        assertICD9CM(procedure, "code", "section", "subSection", "category", "subCategory");
    }

    @Test
    public void shouldCreateICD9CMFromStringWithoutSubCategory() throws Exception {
        ICD9CM procedure = ICD9CM.fromString("code, section -> subSection -> category");

        assertICD9CM(procedure, "code", "section", "subSection", "category", null);
    }

    @Test
    public void shouldCreateICD9CMFromStringWithoutCategory() throws Exception {
        ICD9CM procedure = ICD9CM.fromString("code, section -> subSection");

        assertICD9CM(procedure, "code", "section", "subSection", null, null);
    }

    @Test
    public void shouldHandleCommaInSectionName() throws Exception {
        ICD9CM procedure = ICD9CM.fromString("code, section, section -> subSection -> category -> subCategory");

        assertICD9CM(procedure, "code", "section, section", "subSection", "category", "subCategory");
    }

    private void assertICD9CM(ICD9CM procedure, String code, String section, String subSection, String category, String subCategory) {
        assertThat(procedure.getSection()).isEqualTo(section);
        assertThat(procedure.getSubSection()).isEqualTo(subSection);
        assertThat(procedure.getCategory()).isEqualTo(category);
        assertThat(procedure.getSubCategory()).isEqualTo(subCategory);
        assertThat(procedure.getCode()).isEqualTo(code);
    }

}
