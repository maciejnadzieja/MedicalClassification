package pl.foxmed.med.classification.icd10.repository;

import pl.foxmed.med.classification.MedicalClassificationRepository;
import pl.foxmed.med.classification.icd10.model.ICD10;

public interface ICD10Repository extends MedicalClassificationRepository<ICD10> {
    public ICD10 getByCode(String code);
}
