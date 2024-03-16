package cc.dynamicscript;

import java.util.Map;

public interface Rule {

  boolean execute(Map<String, Object> parameters);

}
