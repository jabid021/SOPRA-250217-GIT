package fr.formation.api.response;

public class HelloResponse {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public HelloResponse(String content) {
        this.content = content;
    }
}
