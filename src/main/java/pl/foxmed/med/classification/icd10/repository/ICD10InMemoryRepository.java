package pl.foxmed.med.classification.icd10.repository;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import pl.foxmed.med.classification.icd10.model.ICD10;
import pl.foxmed.med.classification.icd10.repository.search.ICD10Index;

import java.util.Collection;
import java.util.Collections;

public class ICD10InMemoryRepository implements ICD10Repository {

    private final Collection<ICD10> illnesses;
    private final ICD10Index index;

    public ICD10InMemoryRepository(Collection<ICD10> illnesses) {
        this.illnesses = Collections.unmodifiableCollection(illnesses);
        this.index = new ICD10Index(illnesses);
    }

    @Override
    public ICD10 getByCode(final String code) {
        Collection<ICD10> matchedByCode = Collections2.filter(illnesses, new Predicate<ICD10>() {
            @Override
            public boolean apply(ICD10 icd10) {
                return icd10.getCode().equals(code);
            }
        });

        if (matchedByCode.size() == 1) {
            return matchedByCode.iterator().next();
        }

        return null;
    }

}
