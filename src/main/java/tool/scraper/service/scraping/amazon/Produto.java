package tool.scraper.service.scraping.amazon;

public class Produto {

    private String categoria;
    private String nomeProduto;

    public Produto(String categoria, String nomeProduto) {
        this.categoria = categoria;
        this.nomeProduto = nomeProduto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
}
