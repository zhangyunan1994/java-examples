以下代码示例中将使用不同的动态脚本方式，来实现下面的 3 个规则。其中

- 芝麻分 > 650
- 年龄在 18 到 60 之间
- 安装 [模拟器, 定位修改器] 任意一个 app

### Benchmark

> JMH version: 1.35  
> VM version: JDK 1.8.0_352, OpenJDK 64-Bit Server VM, 25.352-b08  
> VM invoker: java/8.0.352-amzn/jre/bin/java

```
Benchmark                                 Mode  Cnt           Score   Error  Units
DynamicScriptBenchmark.AviatorRule       thrpt          6117117.314          ops/s
DynamicScriptBenchmark.EmptyRule         thrpt       1535723637.650          ops/s
DynamicScriptBenchmark.GroovyClassRule   thrpt         38618876.653          ops/s
DynamicScriptBenchmark.GroovyScriptRule  thrpt              382.283          ops/s
DynamicScriptBenchmark.JavaRule          thrpt         70588877.720          ops/s
DynamicScriptBenchmark.AviatorRule        avgt               ≈ 10⁻⁷           s/op
DynamicScriptBenchmark.EmptyRule          avgt               ≈ 10⁻⁹           s/op
DynamicScriptBenchmark.GroovyClassRule    avgt               ≈ 10⁻⁸           s/op
DynamicScriptBenchmark.GroovyScriptRule   avgt                0.003           s/op
DynamicScriptBenchmark.JavaRule           avgt               ≈ 10⁻⁸           s/op
```