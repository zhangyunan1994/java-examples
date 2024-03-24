package cc.dynamicscript;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.HashMap;
import java.util.Map;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@Warmup(iterations = 1)
@Measurement(iterations = 1)
@BenchmarkMode({Mode.Throughput, Mode.AverageTime})
@Fork(1)
public class DynamicScriptBenchmark {

  static Rule aviatorRule = new AviatorRule();
  static Rule emptyRule = new EmptyRule();
  static Rule groovyClassRule = new GroovyClassRule();
  static Rule groovyScriptRule = new GroovyScriptRule();
  static Rule javaRule = new JavaRule();

  static Map<String, Object> parameters = new HashMap<>();

  static {
    parameters.put("zhiMaScore", 700);
    parameters.put("age", 20);
    parameters.put("appList", Lists.newArrayList("wechat", "qq", "xxBank", "定位修改器"));
  }

  public static void main(String[] args) throws RunnerException {
    Options opt = new OptionsBuilder()
        .include(DynamicScriptBenchmark.class.getSimpleName())
        .forks(1)
        .build();
    new Runner(opt).run();
  }

  @Benchmark
  public void AviatorRule() {
    Preconditions.checkArgument(aviatorRule.execute(parameters), "AviatorRule");
  }

  @Benchmark
  public void EmptyRule() {
    Preconditions.checkArgument(emptyRule.execute(parameters), "EmptyRule");
  }

  @Benchmark
  public void GroovyClassRule() {
    Preconditions.checkArgument(groovyClassRule.execute(parameters), "GroovyClassRule");
  }

  @Benchmark
  public void GroovyScriptRule() {
    Preconditions.checkArgument(groovyScriptRule.execute(parameters), "GroovyScriptRule");
  }

  @Benchmark
  public void JavaRule() {
    Preconditions.checkArgument(javaRule.execute(parameters), "JavaRule");
  }
}
