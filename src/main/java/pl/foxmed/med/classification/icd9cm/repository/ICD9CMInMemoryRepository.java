package pl.foxmed.med.classification.icd9cm.repository;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import pl.foxmed.med.classification.icd9cm.model.ICD9CM;

import java.util.Collection;

public class ICD9CMInMemoryRepository implements ICD9CMRepository {

    private final Collection<ICD9CM> medicalProcedures;

    public ICD9CMInMemoryRepository(Collection<ICD9CM> medicalProcedures) {
        this.medicalProcedures = medicalProcedures;
    }

    @Override
    public ICD9CM getByCode(final String code) {
        Collection<ICD9CM> filteredByCode = Collections2.filter(medicalProcedures, new Predicate<ICD9CM>() {
            @Override
            public boolean apply(ICD9CM icd9CM) {
                return icd9CM.getCode().equals(code);
            }
        });

        if (filteredByCode.size() == 1) {
            return filteredByCode.iterator().next();
        }
        return null;
    }
}
