package tool.scraper.service.scraping.bookstoscrape;

import java.util.UUID;

public class Books {

    private final UUID uuid = UUID.randomUUID();
    private final String titulo;
    private final String preco;
    private final Integer estrelas;

    public Books(String titulo, String preco, Integer estrelas) {
        this.titulo = titulo;
        this.preco = preco;
        this.estrelas = estrelas;
    }

    public Integer getEstrelas() {
        return estrelas;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getPreco() {
        return preco;
    }

}
