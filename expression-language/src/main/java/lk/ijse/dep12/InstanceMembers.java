package lk.ijse.dep12;

import jakarta.el.ExpressionFactory;
import jakarta.el.StandardELContext;

public class InstanceMembers {

    public static void main(String[] args) {
        ExpressionFactory ef = ExpressionFactory.newInstance();
        StandardELContext context = new StandardELContext(ef);
        context.getVariableMapper().setVariable("c1",
                        ef.createValueExpression(new Customer(1, "Kasun"), Customer.class));
        String value = ef.createValueExpression(context,
                "${c1['name']}", String.class).getValue(context);
        System.out.println(value);
    }

}