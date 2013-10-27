package pl.foxmed.med.classification.icd10.resource;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.io.Files;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import pl.foxmed.med.classification.icd10.model.ICD10;
import pl.foxmed.med.classification.icd10.repository.ICD10InMemoryRepository;
import pl.foxmed.med.classification.icd10.repository.ICD10Repository;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.List;

public class ICD10InjectionModule extends AbstractBinder {

    @Override
    protected void configure() {
        try {
            Collection<ICD10> icd10Illnesses = getIcd10Illnesses("/icd10_pl_000.csv");
            bind(new ICD10InMemoryRepository(icd10Illnesses)).to(ICD10Repository.class);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private Collection<ICD10> getIcd10Illnesses(String resourceName) throws IOException, URISyntaxException {
        URL icd10Csv = this.getClass().getResource("/icd10_pl_000.csv");
        List<String> icd10Strings = Files.readLines(new File(icd10Csv.toURI()), Charset.forName("UTF-8"));
        return Collections2.transform(icd10Strings, new Function<String, ICD10>() {
            @Override
            public ICD10 apply(String s) {
                return ICD10.fromString(s);
            }
        });
    }

}
