package cc.dynamicscript;

import groovy.lang.GroovyClassLoader;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.concurrent.ConcurrentHashMap;

public class GroovyCompiler {

  private static final GroovyCompiler compiler = new GroovyCompiler();

  public static GroovyCompiler getInstance() {
    return compiler;
  }

  private final GroovyClassLoader groovyClassLoader = new GroovyClassLoader();
  private final ConcurrentHashMap<String, Class<?>> CLASS_CACHE = new ConcurrentHashMap<>();

  public Rule loadNewInstance(String codeSource) throws Exception {
    if (codeSource != null && codeSource.trim().length() > 0) {
      Class<?> clazz = getCodeSourceClass(codeSource);
      if (clazz != null) {
        Object instance = clazz.newInstance();
        if (instance instanceof Rule) {
          return (Rule) instance;
        }
        else {
          throw new IllegalArgumentException("loadNewInstance error, "
              + "cannot convert from instance[" + instance.getClass() + "] to Rule");
        }
      }
    }
    throw new IllegalArgumentException("loadNewInstance error, instance is null");
  }

  private Class<?> getCodeSourceClass(String codeSource) {
    try {
      byte[] md5 = MessageDigest.getInstance("MD5").digest(codeSource.getBytes());
      String md5Str = new BigInteger(1, md5).toString(16);
      Class<?> clazz = CLASS_CACHE.get(md5Str);
      if (clazz == null) {
        clazz = groovyClassLoader.parseClass(codeSource);
        CLASS_CACHE.putIfAbsent(md5Str, clazz);
      }
      return clazz;
    }
    catch (Exception e) {
      return groovyClassLoader.parseClass(codeSource);
    }
  }
}
