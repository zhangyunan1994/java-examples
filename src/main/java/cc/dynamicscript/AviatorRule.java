package cc.dynamicscript;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import java.util.Map;

public class AviatorRule implements Rule {

  Expression executeExpression;

  private static final String executeScript = "zhiMaScore > 650 "
      + "&& age >= 18 && age <= 60 "
      + "&& ( include(appList, \"模拟器\") || include(appList, \"定位修改器\") ) ";

  public AviatorRule() {
    executeExpression = AviatorEvaluator.compile(executeScript);
  }

  @Override
  public boolean execute(Map<String, Object> parameters) {
    return (boolean) executeExpression.execute(parameters);
  }
}
