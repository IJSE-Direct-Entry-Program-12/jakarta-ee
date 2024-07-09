package lk.ijse.dep12;

import jakarta.el.ExpressionFactory;
import jakarta.el.StandardELContext;

public class StaticMembers {

    public static void main(String[] args) {
        ExpressionFactory ef = ExpressionFactory.newInstance();
        StandardELContext context = new StandardELContext(ef);
        context.getImportHandler().importPackage("lk.ijse.dep12");
        var value = ef.createValueExpression(context,
                "${StaticMembers.add(10,20)}", int.class)
                .getValue(context);
        System.out.println(value);
    }

    public static int add(int x, int y){
        return x + y;
    }
}