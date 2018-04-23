package komal.crawling;

import java.io.IOException;
import java.sql.SQLException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;


public class Main {
//public static DB db = new DB();
public static void main(String[] args) throws SQLException, IOException {
//db.runSql2("TRUNCATE Record;");
processPage("https://www.fairprice.com.sg/" );
}
public static void processPage(String URL) throws SQLException, IOException{

Document doc = Jsoup.connect("https://www.fairprice.com.sg/" ).get();
Elements e = doc.getElementsByClass("essentials_category_menu");
Elements el = e.get(0).getElementsByTag("li");
for(Element r : el)
{
	String link = r.getElementsByTag("a").attr("href");
	Document docInner = Jsoup.connect(link).get();
	System.out.println(link);
	Elements ell = docInner.select("meta[name=pageId]");
    @SuppressWarnings("resource")
	final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_45);
	webClient.getOptions().setThrowExceptionOnScriptError(false);
	
		
        final HtmlPage page = webClient.getPage("https://www.fairprice.com.sg/baby-child/");
       
        webClient.getOptions().setTimeout(100000);
        
        final String pageXml = page.asXml(); 
        
        //webClient.getOptions().setTimeout(100000);
        
        System.out.println(pageXml);
        break;
        
}

}

}
