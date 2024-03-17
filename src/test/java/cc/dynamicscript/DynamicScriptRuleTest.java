package cc.dynamicscript;

import com.google.common.collect.Lists;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DynamicScriptRuleTest {

  AviatorRule aviatorRule = new AviatorRule();

  JavaRule javaRule = new JavaRule();

  @Test
  void aviatorRule() {
    Map<String, Object> parameters = new HashMap<>();

    parameters.put("zhiMaScore", 700);
    parameters.put("age", 20);
    parameters.put("appList", Lists.newArrayList("wechat", "qq", "xxBank", "定位修改器"));

    Assertions.assertTrue(aviatorRule.execute(parameters));

    parameters.put("appList", Lists.newArrayList("wechat", "qq", "xxBank", "三国杀"));
    Assertions.assertFalse(aviatorRule.execute(parameters));
  }

  @Test
  void javaRule() {
    Map<String, Object> parameters = new HashMap<>();

    parameters.put("zhiMaScore", 700);
    parameters.put("age", 20);
    parameters.put("appList", Lists.newArrayList("wechat", "qq", "xxBank", "定位修改器"));

    Assertions.assertTrue(javaRule.execute(parameters));

    parameters.put("appList", Lists.newArrayList("wechat", "qq", "xxBank", "三国杀"));
    Assertions.assertFalse(javaRule.execute(parameters));
  }
}