package endava;

import endava.pages.CategoryPage;
import endava.pages.ResultsPage;
import endava.pages.SignInPage;
import endava.pages.SignUpPage;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UI_Tests extends Hooks{

    @Test
    public void signUp(){
        SignUpPage signUp = landing.singUpRedirect(props.getProperty("signUp"));
        assertThat("The user did not logged in",
                signUp.SignUp(props.getProperty("name"), props.getProperty("lastName"), props.getProperty("email"), props.getProperty("password")),
                equalTo(props.getProperty("email")));
    }

    @Test
    public void signIn(){
        SignInPage signIn = landing.signInRedirect(props.getProperty("signIn"));
        assertThat("The user did not logged in",
                signIn.signIn(props.getProperty("email"), props.getProperty("password")), equalTo(props.getProperty("email")));
    }

    @Test
    public void wrongSignIn(){
        SignInPage signIn = landing.signInRedirect(props.getProperty("signIn"));
        assertThat("The user did logged in",
                signIn.signIn(props.getProperty("email"), props.getProperty("notPassword")), equalTo(props.getProperty("wrongLogIn")));
    }

    @Test
    public void searchItem(){
        String query = props.getProperty("searchItem");
        ResultsPage results = landing.search(query);
        assertThat(props.getProperty("wrongAssert"), results.getFilter(),equalTo(query));
    }

    @Test
    public void browseCategory(){
        CategoryPage category = landing.browseCategory();
        assertThat(props.getProperty("wrongAssert"), category.getTitle(), equalTo("Acoustic Drums"));
    }

    @Test
    public void filterPrice(){
        String query = props.getProperty("filterPrice");
        ResultsPage results = landing.search(query);
        String filteredPrice = results.priceFilter("1,200", "2,300");
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