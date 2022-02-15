package tool.scraper.service.scraping.bookstoscrape;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author Gustavo Aquino
 * @since 20/09/2020
 *
 * Site: http://books.toscrape.com/
 */

public class BookToScraperScraping {

    private static final String URL = "http://books.toscrape.com";

    public static void main (String[]Args) throws Exception {

        //Conexão com o site
        Connection.Response response = Jsoup.connect(URL)
                .execute().bufferUp();

        //Transformar o response em um documento para trabalhar com o html
        Document document = response.parse();

        //Inicialização de uma lista de livros.
        List<Books> listaLivros = new ArrayList<>();

        int x = 0;

        while(x < 10) {

            //For que captura as informações para inserir no objeto.
            for (Element element : document.getElementsByClass("col-xs-6 col-sm-4 col-md-3 col-lg-3")) {

                final String titulo = element.getElementsByTag("h3").get(0).getElementsByAttribute("title").tagName("a").attr("title");

                final String preco = element.getElementsByClass("price_color").text().replace("£", "");

                final String tituloEstrela = element.getElementsByTag("p").get(0).attr("class");

                final Integer valorEstrela = retornarEstrelas(tituloEstrela);

                listaLivros.add(new Books(titulo, preco, valorEstrela));
            }

            final String urlNovaPagina = montarUrlProximaPagina(document);

            document = Jsoup.connect(urlNovaPagina).get();

            x++;
        }

        //Mostrar os dados capturados no console.
        System.out.println("Total de itens capturados: " + listaLivros.size());
        for(Books book : listaLivros){
            System.out.println("Hash: " + book.getUuid() +  " Titulo: " + book.getTitulo() + " Preço: " + book.getPreco() + " Estrelas: " + book.getEstrelas());
        }
    }

    //Método para retornar o valor da quantidade de estrelas que o livro tem. *de 1 a 5.*
    private static Integer retornarEstrelas(String nomeClass) {

        Map<String, Integer>  listaRating = new HashMap<String, Integer>(5);

        listaRating.put("star-rating One", 1);
        listaRating.put("star-rating Two", 2);
        listaRating.put("star-rating Three", 3);
        listaRating.put("star-rating Four", 4);
        listaRating.put("star-rating Five", 5);

        return listaRating.get(nomeClass);

    }

    private static String montarUrlProximaPagina(Document document){

        String urnProximaPagina =  document.getElementsByClass("next").get(0).getElementsByTag("a").attr("href").replace("/", "");

        if(urnProximaPagina.contains("catalogue")){
            urnProximaPagina = urnProximaPagina.replace("catalogue", "");
        }

        return URL.concat("/catalogue/").concat(urnProximaPagina);
    }

}
