import jakarta.el.ExpressionFactory;
import jakarta.el.StandardELContext;
import jakarta.el.ValueExpression;

import java.util.List;

public class ListWithEL2 {

    public static void main(String[] args) {
        ExpressionFactory ef = ExpressionFactory.newInstance();
        StandardELContext context = new StandardELContext(ef);
        ValueExpression ve = ef.createValueExpression(context,
                "${['dep','cmjd','gdse'].get(1).toUpperCase()}",
                String.class);
        String value = ve.getValue(context);
        System.out.println(value);
    }
}
