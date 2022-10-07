package example.enhance;

import org.concordion.cubano.template.driver.ui.google.EnhanceSearchPage;
import org.concordion.cubano.template.driver.ui.google.GoogleSearchPage;
import org.concordion.cubano.template.framework.CubanoDemoBrowserFixture;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

public class EnhanceFixture extends CubanoDemoBrowserFixture {
    // this will find a file will this class name exclude the last word part

    public void enhance(){
        EnhanceSearchPage.open(this).isExist();

    }
    
}

