package counter.data;

public class DirectoryData {

    private int documentCount;
    private int pageSum;

    public DirectoryData() {
    }

    public DirectoryData(int documentCount, int pageSum) {
        this.documentCount = documentCount;
        this.pageSum = pageSum;
    }

    public int getDocumentCount() {
        return documentCount;
    }

    public void setDocumentCount(int documentCount) {
        this.documentCount = documentCount;
    }

    public int getPageSum() {
        return pageSum;
    }

    public void setPageSum(int pageSum) {
        this.pageSum = pageSum;
    }
}
