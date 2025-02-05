package calculatorService;

import calculatorEnum.MethodName;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class CalculatorMethodMap {
    private final Map<MethodName, Supplier<Double>> methodCalcMap = new HashMap<>();

    public CalculatorMethodMap(Calculator calculator) {
        methodCalcMap.put(MethodName.plus, calculator::plus);
        methodCalcMap.put(MethodName.minus, calculator::minus);
        methodCalcMap.put(MethodName.multiple, calculator::multiply);
        methodCalcMap.put(MethodName.divide, calculator::divide);
        if (calculator instanceof ScientificCalculator scientificCalculator) {
            methodCalcMap.put(MethodName.sin, scientificCalculator::sin);
            methodCalcMap.put(MethodName.cos, scientificCalculator::cos);
            methodCalcMap.put(MethodName.tan, scientificCalculator::tan);
        }
    }

    public Supplier<Double> getMethodCalc(MethodName methodName) {
        return methodCalcMap.get(methodName);
    }
}
