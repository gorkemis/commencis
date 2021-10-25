import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.Iterator;
import java.util.List;

public class WebForm extends PageObject {

    @FindBy(css = "span[class='river-byline__authors']")
    private List<WebElement> authors;
    @FindBy(css = "div[class='river river--homepage '] span[class='river-byline__authors']")
    private List<WebElement> articles;
    @FindBy(css = "div[class='river river--homepage '] img[src]")
    private List<WebElement> pictures;
    @FindBy(css = "header[class='post-block__header'] a[class='post-block__title__link']")
    private List<WebElement> first_article;
    @FindBy(css = "h1[class='article__title']")
    private WebElement article_title;
    @FindBy(css = "div[class='article-content'] a")
    private List<WebElement> links;

    public WebForm(WebDriver driver) {
        super(driver);
    }

    public int getAuthor() {
        int authorNumber = authors.size();
        return authorNumber;
    }

    public int getArticle() {
        int articleNumber = articles.size();
        return articleNumber;
    }

    public int getPicture() {
        int pictureNumber = pictures.size();
        return pictureNumber;
    }

    public void clickFirstArticle() {
        this.first_article.get(1).click();
    }

    public String getBrowserTitle() {
        String browserTitle = driver.getTitle();
        return browserTitle;
    }

    public String getArticleTitle() {
        return this.article_title.getText() + " | TechCrunch";
    }

    public int linkVerify() {
        String url="";
        int allLinkNumbers = links.size();
        int runningLinks = 0;
        int brokeLinks;
        Iterator<WebElement> iterator = links.iterator();
        while (iterator.hasNext()) {
            url = iterator.next().getText();
            runningLinks++;
        }
        brokeLinks = allLinkNumbers - runningLinks;
        return brokeLinks;
    }
}