public class Demo {

    public static void main(String[] args) {
        ServletRequest req = new HttpServletRequestImpl();
        ServletResponse res = new HttpServletResponseImpl();
        service(req, res);
    }

    public static void service(ServletRequest req, ServletResponse res){
        System.out.println("First Service Method");
        service(req, res);
    }

    public static void service(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("Came here");
    }
}
