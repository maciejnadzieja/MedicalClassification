package pl.foxmed.med.classification;

public interface MedicalClassificationRepository<T> {
    public T getByCode(String code);
    //public List<T> search(Query query);
}
