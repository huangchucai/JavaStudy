package com.hcc.hotel;

public class ServletConfiguration {
    public ServletConfiguration(String urlPattern, String servletClass, Integer loadOnStartup) {
        this.urlPattern = urlPattern;
        this.servletClass = servletClass;
        this.loadOnStartup = loadOnStartup;
    }

    private String urlPattern;

    private String servletClass;

    private Integer loadOnStartup;


    public String getUrlPattern() {
        return urlPattern;
    }

    public void setUrlPattern(String urlPattern) {
        this.urlPattern = urlPattern;
    }

    public String getServletClass() {
        return servletClass;
    }

    public void setServletClass(String servletClass) {
        this.servletClass = servletClass;
    }

    public Integer getLoadOnStartup() {
        return loadOnStartup;
    }

    public void setLoadOnStartup(Integer loadOnStartup) {
        this.loadOnStartup = loadOnStartup;
    }
}
