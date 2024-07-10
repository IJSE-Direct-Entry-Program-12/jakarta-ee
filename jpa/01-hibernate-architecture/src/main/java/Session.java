public interface Session extends EntityManager {
    void save();

    void saveAndUpdate();

    void delete();
}
