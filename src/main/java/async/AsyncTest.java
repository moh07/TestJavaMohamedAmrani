package async;

import io.vavr.collection.List;
import io.vavr.*;
import io.vavr.control.Option;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


/**
 * You should complete the function in this class
 */
class AsyncTest {

  private static List<Enterprise> enterprises = List.of(
      new Enterprise("ent_1", "Google", "ceo_2"),
      new Enterprise("ent_2", "Facebook", "ceo_1")
  );

  private static List<Ceo> ceos = List.of(
      new Ceo("ceo_1", "Mark"),
      new Ceo("ceo_2", "Sundar"),
      new Ceo("ceo_3", "Bill")
  );

  public static CompletableFuture<Option<Ceo>> getCeoById(String ceo_id) {

    CompletableFuture<Option<Ceo>> completableFuture = new CompletableFuture<Option<Ceo>>();

    for (Ceo ceo : ceos) {
			if (ceo.id.equals(ceo_id)) {
        Option<Ceo> ceoRes = Option.of(ceo); 
				completableFuture.complete(ceoRes) ;
			}
		}

    return completableFuture;
  }

  public static CompletableFuture<Option<Enterprise>> getEnterpriseByCeoId(String ceo_id) {

    CompletableFuture<Option<Enterprise>> completableFuture = new CompletableFuture<Option<Enterprise>>();

    for (Enterprise enterprise : enterprises) {
			if (enterprise.ceo_id.equals(ceo_id)) {
        Option<Enterprise> enterpriseRes = Option.of(enterprise); 
				completableFuture.complete(enterpriseRes) ;
			}
		}

    return completableFuture;
  }

  public static CompletableFuture<Tuple2<Option<Ceo>, Option<Enterprise>>> getCEOAndEnterprise(String ceo_id) throws ExecutionException,InterruptedException{

    CompletableFuture<Tuple2<Option<Ceo>, Option<Enterprise>>> completableFuture = new CompletableFuture<Tuple2<Option<Ceo>, Option<Enterprise>>>();
    // I used the function getCeoById and getEnterpriseByCeoId
    Tuple2<Option<Ceo>, Option<Enterprise>> myTuple = Tuple.of(getCeoById(ceo_id).get(),getEnterpriseByCeoId(ceo_id).get()); 
		completableFuture.complete(myTuple) ;

    return completableFuture;
  }

}
