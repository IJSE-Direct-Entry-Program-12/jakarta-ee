import jakarta.el.ExpressionFactory;
import jakarta.el.StandardELContext;
import jakarta.el.ValueExpression;

import java.util.List;
import java.util.Set;

public class SetWithEL {

    public static void main(String[] args) {
        ExpressionFactory ef = ExpressionFactory.newInstance();
        StandardELContext context = new StandardELContext(ef);
        ValueExpression ve = ef.createValueExpression(context, "${{1,2,3,4,2,5,2}}", Set.class);
        Set<Long> set = ve.getValue(context);
        set.forEach(System.out::println);
    }
}
