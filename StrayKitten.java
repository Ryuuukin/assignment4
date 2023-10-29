class StrayKitten implements Kitten {
    private String name;

    public StrayKitten(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return "A stray kitten named " + name;
    }
}