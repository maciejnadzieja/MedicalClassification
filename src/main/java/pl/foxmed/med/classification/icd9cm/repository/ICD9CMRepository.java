package pl.foxmed.med.classification.icd9cm.repository;

import pl.foxmed.med.classification.MedicalClassificationRepository;
import pl.foxmed.med.classification.icd9cm.model.ICD9CM;

public interface ICD9CMRepository extends MedicalClassificationRepository<ICD9CM> {
    public ICD9CM getByCode(String code);
}
