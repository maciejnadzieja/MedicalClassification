package pl.foxmed.med.classification.icd10.model;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

import java.util.List;

public class ICD10 {
    private String code;
    private String title;

    public ICD10() {
    }

    public ICD10(String code, String title) {
        this.code = code;
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static ICD10 fromString(String s) {
        List<String> split = Lists.newLinkedList(Splitter.on(",").limit(2).trimResults().split(s));
        return new ICD10(split.get(0), split.get(1));
    }

    @Override
    public String toString() {
        return String.format("ICD10{code='%s', title='%s'}", code, title);
    }
}
