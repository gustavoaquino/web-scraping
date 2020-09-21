package BooksToScrape;

import java.util.UUID;

public class Books {

    private UUID uuid = UUID.randomUUID();
    private String titulo;
    private String preco;
    private Integer estrelas;

    public Books(String titulo, String preco, Integer estrelas) {
        this.uuid = uuid;
        this.titulo = titulo;
        this.preco = preco;
        this.estrelas = estrelas;
    }

    public Integer getEstrelas() {
        return estrelas;
    }

    public void setEstrelas(Integer estrelas) {
        this.estrelas = estrelas;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }
}
