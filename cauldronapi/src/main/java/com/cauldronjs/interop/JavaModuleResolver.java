package com.cauldronjs.interop;

import com.caoccao.javet.exceptions.JavetException;
import com.caoccao.javet.interfaces.IV8ModuleResolver;
import com.caoccao.javet.interop.NodeRuntime;
import com.caoccao.javet.interop.V8Runtime;
import com.caoccao.javet.values.reference.IV8Module;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class JavaModuleResolver implements IV8ModuleResolver {
  static class JavaModule {

  }

  private static String MODULE_VARIABLE = "$$module";
  private final NodeRuntime runtime;
  private final Map<String, JavaModule> moduleMap = new HashMap<>();
  private final ReadWriteLock moduleMapLock = new ReentrantReadWriteLock();

  JavaModuleResolver(NodeRuntime runtime) {
    this.runtime = runtime;
  }

  @Override
  public IV8Module resolve(V8Runtime v8Runtime, String resourceName, IV8Module v8ModuleReferrer) throws JavetException {
    var readLock = this.moduleMapLock.readLock();

  }
}
