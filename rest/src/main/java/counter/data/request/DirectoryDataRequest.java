package counter.data.request;

import jakarta.validation.constraints.NotNull;

public class DirectoryDataRequest {

    @NotNull
    private String rootPath;

    public DirectoryDataRequest() {
    }

    public String getRootPath() {
        return rootPath;
    }

    public void setRootPath(String rootPath) {
        this.rootPath = rootPath;
    }
}
