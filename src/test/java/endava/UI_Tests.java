package endava;

import endava.pages.DrumsPercussionPage;
import endava.pages.ResultsPage;
import endava.pages.SignUpPage;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class UI_Tests extends Hooks{

    @Test
    public void signUp(){
        SignUpPage signUp = landing.redirect();
        signUp.SignUp(props.getProperty("name"), props.getProperty("lastName"), props.getProperty("email"), props.getProperty("password"));
    }

    @Test
    public void searchItem(){
        String query = props.getProperty("searchItem");
        ResultsPage results = landing.search(query);
        assertThat(props.getProperty("wrongAssert"), results.getFilter(),equalTo(query));
    }

    @Test
    public void browseCategory(){
        DrumsPercussionPage category = landing.browseCategory();
        assertThat(props.getProperty("wrongAssert"), category.getTitle(), equalTo("Acoustic Drums"));
    }

    @Test
    public void filterPrice(){
        String query = props.getProperty("filterPrice");
        ResultsPage results = landing.search(query);
        String filteredPrice = results.pricerFilter("1,200", "2,300");
        // TO DO: Replace the hard-coded values. Find out why does not work when the xpaths are create with the parameters of the query
        assertThat(props.getProperty("wrongAssert"), filteredPrice, equalTo("$1,200 – $2,300"));
    }

    @Test
    public void highToLow(){
        String query = props.getProperty("highToLow");
        ResultsPage results = landing.search(query);
        results.highToLow();
        String criteria = driver.getCurrentUrl();
        assertThat("The order to see the items was not implemented", criteria.endsWith("price%7Cdesc"));
    }

}