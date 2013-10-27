package pl.foxmed.med.classification.icd9cm.model;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;

public class ICD9CM {
    private String code;
    private String section;
    private String subSection;
    private String category;
    private String subCategory;

    public ICD9CM() {
    }

    public ICD9CM(String code, List<String> categories) {
        this.code = code;
        this.section = categories.get(0);
        this.subSection = categories.get(1);
        if (categories.size() > 2) {
            this.category = categories.get(2);
        }
        if (categories.size() > 3) {
            this.subCategory = categories.get(3);
        }
    }

    public static ICD9CM fromString(String s) {
        Iterator<String> codeAndDescription = Splitter.on(",").limit(2).trimResults().split(s).iterator();
        String code = codeAndDescription.next();
        Iterable<String> categories = Splitter.on("->").trimResults().limit(4).split(codeAndDescription.next());
        return new ICD9CM(code, Lists.newLinkedList(categories));
    }

    public String getSection() {
        return section;
    }

    public String getSubSection() {
        return subSection;
    }

    public String getCategory() {
        return category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public void setSubSection(String subSection) {
        this.subSection = subSection;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }
}
