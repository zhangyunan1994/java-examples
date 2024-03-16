package cc.dynamicscript;

import java.util.Map;

public class EmptyRule implements Rule {

  @Override
  public boolean execute(Map<String, Object> parameters) {
    return true;
  }
}
