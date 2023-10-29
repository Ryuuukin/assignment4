class BreededKitten implements Kitten {
    private String name;

    public BreededKitten(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    @Override
    public String getDescription() {
        return "A purebred kitten";
    }
}