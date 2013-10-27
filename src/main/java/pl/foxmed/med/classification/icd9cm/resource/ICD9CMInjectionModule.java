package pl.foxmed.med.classification.icd9cm.resource;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.io.Files;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import pl.foxmed.med.classification.icd9cm.model.ICD9CM;
import pl.foxmed.med.classification.icd9cm.repository.ICD9CMInMemoryRepository;
import pl.foxmed.med.classification.icd9cm.repository.ICD9CMRepository;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.List;

public class ICD9CMInjectionModule extends AbstractBinder {

    @Override
    protected void configure() {
        try {
            Collection<ICD9CM> medicalProcedures = getIcd9CMProcedures("/icd9_pl_519.csv");
            bind(new ICD9CMInMemoryRepository(medicalProcedures)).to(ICD9CMRepository.class);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private Collection<ICD9CM> getIcd9CMProcedures(String resourceName) throws IOException, URISyntaxException {
        URL icd9Csv = this.getClass().getResource(resourceName);
        List<String> icd9Strings = Files.readLines(new File(icd9Csv.toURI()), Charset.forName("UTF-8"));
        return Collections2.transform(icd9Strings, new Function<String, ICD9CM>() {
            @Override
            public ICD9CM apply(String s) {
                return ICD9CM.fromString(s);
            }
        });
    }
}
