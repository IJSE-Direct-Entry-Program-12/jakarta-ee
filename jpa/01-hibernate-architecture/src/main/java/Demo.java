public class Demo {

    public static void main(String[] args) {
        SessionImpl impl = new SessionImpl();
        Session session = impl;
        EntityManager entityManager = impl;
    }
}
