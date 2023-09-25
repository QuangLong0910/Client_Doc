package quanglong.ph27075.demo1212;

import java.util.Arrays;

public class NoiDung {
    private String url;

    public NoiDung(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "NoiDung{" +
                "url='" + url + '\'' +
                '}';
    }
}
