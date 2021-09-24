package com.cauldronjs.interop;

import com.caoccao.javet.enums.JSRuntimeType;
import com.caoccao.javet.exceptions.JavetException;
import com.caoccao.javet.interop.NodeRuntime;
import com.caoccao.javet.interop.converters.JavetProxyConverter;
import com.caoccao.javet.interop.engine.JavetEngine;
import com.caoccao.javet.interop.engine.JavetEnginePool;

public class CauldronEnginePool extends JavetEnginePool<NodeRuntime> {
  CauldronEnginePool() {

  }

  @Override
  protected JavetEngine<NodeRuntime> createEngine() throws JavetException {
    var engine = super.createEngine();
    engine.getConfig().setAllowEval(false);
    engine.getConfig().setGcBeforeEngineClose(true);
    engine.getConfig().setJSRuntimeType(JSRuntimeType.Node);

    engine.getV8Runtime().setConverter(new JavetProxyConverter());

    return engine;
  }
}
