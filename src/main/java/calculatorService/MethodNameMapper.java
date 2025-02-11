package calculatorService;

import calculatorEnum.MethodName;

import java.util.HashMap;
import java.util.Map;

public class MethodNameMapper {
    private static final Map<String, MethodName> methodNameMap = new HashMap<>();

    static {
        methodNameMap.put("더하기", MethodName.plus);
        methodNameMap.put("빼기", MethodName.minus);
        methodNameMap.put("곱하기", MethodName.multiple);
        methodNameMap.put("나누기", MethodName.divide);
        methodNameMap.put("사인", MethodName.sin);
        methodNameMap.put("코사인", MethodName.cos);
        methodNameMap.put("탄젠트", MethodName.tan);
    }

    public static MethodName getMethodName(String methodName) {
        return methodNameMap.getOrDefault(methodName, null);
    }
}

