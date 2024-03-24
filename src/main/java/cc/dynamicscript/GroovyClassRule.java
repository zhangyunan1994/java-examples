package cc.dynamicscript;

import java.util.Map;
import lombok.SneakyThrows;

public class GroovyClassRule implements Rule {

  Rule rule = null;

  String classText = "package cc.dynamicscript;\n"
      + "\n"
      + "import java.util.List;\n"
      + "import java.util.Map;\n"
      + "\n"
      + "public class GroovyDD123Rule implements Rule {\n"
      + "\n"
      + "  @Override\n"
      + "  public boolean execute(Map<String, Object> parameters) {\n"
      + "    Integer zhiMaScore = (Integer) parameters.get(\"zhiMaScore\");\n"
      + "    Integer age = (Integer) parameters.get(\"age\");\n"
      + "    List<String> appList = (List<String>) parameters.get(\"appList\");\n"
      + "\n"
      + "    return zhiMaScore > 650\n"
      + "        && age >= 18 && age <= 60\n"
      + "        && (appList.contains(\"模拟器\") || appList.contains(\"定位修改器\"));\n"
      + "  }\n"
      + "}";

  @SneakyThrows
  public GroovyClassRule() {
    rule = GroovyCompiler.getInstance().loadNewInstance(classText);
  }

  @Override
  public boolean execute(Map<String, Object> parameters) {
    return rule.execute(parameters);
  }

}
