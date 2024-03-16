package cc.dynamicscript;

import com.google.common.collect.Lists;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AviatorRuleTest {

  AviatorRule rule = new AviatorRule();

  @Test
  void execute() {
    Map<String, Object> parameters = new HashMap<>();

    parameters.put("zhiMaScore", 700);
    parameters.put("age", 20);
    parameters.put("appList", Lists.newArrayList("wechat", "qq", "xxBank", "定位修改器"));

    Assertions.assertTrue(rule.execute(parameters));

    parameters.put("appList", Lists.newArrayList("wechat", "qq", "xxBank", "三国杀"));
    Assertions.assertFalse(rule.execute(parameters));

  }
}