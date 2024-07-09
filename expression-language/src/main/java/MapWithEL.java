import jakarta.el.ExpressionFactory;
import jakarta.el.StandardELContext;
import jakarta.el.ValueExpression;

import java.util.Map;
import java.util.Set;

public class MapWithEL {

    public static void main(String[] args) {
        ExpressionFactory ef = ExpressionFactory.newInstance();
        StandardELContext context = new StandardELContext(ef);
        ValueExpression ve = ef.createValueExpression(context,
                "${{'key1': 10, 'key2': 20, 'key1': 30}}", Map.class);
        Map<String, Long> myMap = ve.getValue(context);
        System.out.println(myMap);
    }
}
