package load;

import static io.restassured.RestAssured.given;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import java.util.ArrayList;
import load.data.FinanceConditionDataLoader;
import org.junit.jupiter.api.Test;
import tech.claudioed.port.inputs.financecondition.NewFinanceCondition;

@QuarkusTest
public class LoadDataTest {

  @Test
  public void testHelloEndpoint() {
    var fcs = new ArrayList<NewFinanceCondition>();
    fcs.addAll(FinanceConditionDataLoader.loadProductFamilies());
    fcs.addAll(FinanceConditionDataLoader.loadProducts());
    fcs.addAll(FinanceConditionDataLoader.loadDealers());
    fcs.addAll(FinanceConditionDataLoader.loadCustomers());

    for (NewFinanceCondition cnd : fcs){
      given()
        .contentType(ContentType.JSON)
        .body(cnd)
      .when()
        .post("/finance-conditions")
      .then()
        .statusCode(200);
    }





//    given()
//        .when().get("/hello")
//        .then()
//        .statusCode(200)
//        .body(is("hello"));
  }

}
