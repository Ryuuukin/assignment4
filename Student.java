class Student implements Observer {
    private String name;
    private double budget;
    private Kitten adoptedKitten;

    public Student(String name, double budget) {
        this.name = name;
        this.budget = budget;
    }
    public String getName() {
        return name;
    }

    public double getBudget() {
        return budget;
    }
    public Kitten getAdoptedKitten() {
        return adoptedKitten;
    }


    @Override
    public void update(Kitten kitten) {
        if (kitten instanceof StrayKitten) {
            if (adoptedKitten == null) {
                adoptedKitten = kitten;
                System.out.println(name + " adopted a stray kitten and named it: " + kitten.getDescription());
                System.out.println(name + " has this budget: " + budget);
            } else {
                System.out.println(name + " already has a kitten and cannot adopt another one.");
            }
        } else if (kitten instanceof BreededKitten) {
            if (budget >= 50000) {
                budget -= 50000;
                System.out.println(name + " bought a breeded kitten: " + kitten.getDescription());
                System.out.println(name + " has this budget: " + budget);
            } else {
                System.out.println(name + " doesn't have enough budget to buy the breeded kitten.");
            }
        }
    }
}