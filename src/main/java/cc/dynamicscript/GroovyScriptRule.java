package cc.dynamicscript;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import java.util.Map;

public class GroovyScriptRule implements Rule {

  String executeScript = "zhiMaScore > 650 && age >= 18 && age <= 60 && (appList.contains(\"模拟器\") || appList.contains(\"定位修改器\"))";

  @Override
  public boolean execute(Map<String, Object> parameters) {
    Binding binding = new Binding(parameters);
    GroovyShell shell = new GroovyShell(binding);
    return (boolean) shell.evaluate(executeScript);
  }
}
