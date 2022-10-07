package example.google;

import org.concordion.cubano.template.driver.ui.google.EnhanceSearchPage;
import org.concordion.cubano.template.driver.ui.google.GoogleSearchPage;
import org.concordion.cubano.template.framework.CubanoDemoBrowserFixture;

public class SearchForConcordionFixture extends CubanoDemoBrowserFixture {
    public int a =1 ;
    public String google(String term, String site) {
        test1 t1 = new test1();
        System.out.println(t1.a + "1234567");
        return GoogleSearchPage.open(this)
                .searchFor(term)
                .getSearchResult(site);

    }

    public void enhance(){
        EnhanceSearchPage.open(this);
    }
}
