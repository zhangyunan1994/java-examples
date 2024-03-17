package cc.dynamicscript;

import java.util.List;
import java.util.Map;

public class JavaRule implements Rule {

  @Override
  public boolean execute(Map<String, Object> parameters) {
    Integer zhiMaScore = (Integer) parameters.get("zhiMaScore");
    Integer age = (Integer) parameters.get("age");
    List<String> appList = (List<String>) parameters.get("appList");

    return zhiMaScore > 650
        && age >= 18 && age <= 60
        && (appList.contains("模拟器") || appList.contains("定位修改器"));
  }
}
