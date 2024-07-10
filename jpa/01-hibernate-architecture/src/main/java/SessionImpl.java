public class SessionImpl implements Session{
    @Override
    public void save() {
        System.out.println("Save");
    }

    @Override
    public void saveAndUpdate() {
        System.out.println("SaveAndUpdate");
    }

    @Override
    public void delete() {
        System.out.println("Delete");
    }

    @Override
    public void persist() {
        System.out.println("Persist");
    }

    @Override
    public void remove() {
        System.out.println("Remove");
    }

    @Override
    public void refresh() {
        System.out.println("Refresh");
    }
}
