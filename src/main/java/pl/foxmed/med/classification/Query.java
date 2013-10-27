package pl.foxmed.med.classification;

public class Query {
    private final String query;
    private final int limit;
    private final int page;

    public Query(String query, int limit, int page) {
        this.query = query;
        this.limit = limit;
        this.page = page;
    }

    public String getQuery() {
        return query;
    }

    public int getLimit() {
        return limit;
    }

    public int getPage() {
        return page;
    }
}
