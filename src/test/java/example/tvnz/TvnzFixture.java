package example.tvnz;

import org.concordion.cubano.template.driver.ui.google.EnhanceSearchPage;
import org.concordion.cubano.template.driver.ui.google.TvnzLoginPage;
import org.concordion.cubano.template.driver.ui.google.TvnzMainPage;
import org.concordion.cubano.template.framework.CubanoDemoBrowserFixture;

public class TvnzFixture extends CubanoDemoBrowserFixture {
    // this will find a file will this class name exclude the last word part

    protected static TvnzLoginPage loginPage;
    protected static TvnzMainPage mainPage;

    public void navigate(){
        mainPage = TvnzMainPage.open(this);
        loginPage = mainPage.clickLogin(this);
    }
    public void login(String userName, String password){
        loginPage.login(this,userName,password);
    }


}

