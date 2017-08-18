
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/alexgalays/Documents/workspace/alex/poc-http-aggregation/conf/routes
// @DATE:Tue Aug 15 12:27:37 CEST 2017

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseApiAggregation ApiAggregation = new controllers.ReverseApiAggregation(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseApplication Application = new controllers.ReverseApplication(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseApiAggregation ApiAggregation = new controllers.javascript.ReverseApiAggregation(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseApplication Application = new controllers.javascript.ReverseApplication(RoutesPrefix.byNamePrefix());
  }

}
