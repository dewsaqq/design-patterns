package prototype;

import java.util.HashMap;
import java.util.Map;

public class ComputationPrototypeManager {
    private final Map<ComputationType, ComputationPrototype> prototypeMap = new HashMap() {{
        put(ComputationType.SIN, new ComputationSin());
        put(ComputationType.COS, new ComputationCos());
        put(ComputationType.TAN, new ComputationTan());
    }};

    public ComputationPrototype getPrototype(ComputationType computationType) {
        return prototypeMap.get(computationType).clone();
    }
}
