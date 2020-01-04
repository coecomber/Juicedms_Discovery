package com.Herwaarden.Discovery.Model;

public class Instance {
    public String name;
    public String url;
    public int port;

    public Instance() {
    }

    public Instance(String name, String url, int port) {
        this.name = name;
        this.url = url;
        this.port = port;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
