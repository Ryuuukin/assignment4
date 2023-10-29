class StrayKittenFactory implements KittenFactory {
    @Override
    public Kitten createKitten(String name) {
        System.out.println("A funny stray kitten " + name + " was added!:3");
        return new StrayKitten(name);
    }
}