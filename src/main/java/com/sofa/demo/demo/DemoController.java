package com.sofa.demo.demo;

import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DemoController {

    //directUrl = http://www.baidu.cn is 302, change to http://www.tianya.cn is work fine 
    @SofaReference(jvmFirst = false, binding = @SofaReferenceBinding(bindingType = "rest", directUrl = "http://www.baidu.cn"))
    private SimpleApi simpleApi;

    @RequestMapping(value = "/rest", method = RequestMethod.GET)
    public String rest() {
        return "rest" + simpleApi.post();
    }

    @RequestMapping(value = "/hs", method = RequestMethod.GET)
    public String hs() {
        return "OK" ;
    }
}
