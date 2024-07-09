import jakarta.el.ExpressionFactory;
import jakarta.el.StandardELContext;
import jakarta.el.ValueExpression;

public class ELOperators3 {

    public static void main(String[] args) {
        ExpressionFactory ef = ExpressionFactory.newInstance();
        StandardELContext context = new StandardELContext(ef);
        Student s1 = new Student(1, "Kasun", 95);
        Student s2 = new Student(2, "Nuwan", 55);
        Student s3 = new Student(3, "Ruwan", 30);
        context.getVariableMapper().setVariable("s1", ef.createValueExpression(s1, Student.class));
        context.getVariableMapper().setVariable("s2", ef.createValueExpression(s2, Student.class));
        context.getVariableMapper().setVariable("s3", ef.createValueExpression(s3, Student.class));
        String value = ef.createValueExpression(context,
                "#{([s1, s2, s3].stream().map(s -> s.marks).max((m1, m2) -> Integer.compare(m1, m2)).get() " +
                "gt s2.marks + s3.marks) and (s1.marks div 2 le s3.marks) ? " +
                "s1.id += '-' += s1.name.toUpperCase() += '-' += (s1.marks ge 75 ? 'A': 'B'): " +
                "s2.id += '-' += s2.name += '-' += (s2.marks ge 75 ? 'A': s2.marks >= 65 ? 'B': 'C')}",
                String.class).getValue(context);
        System.out.println(value);
    }
}