public class BreededKittenFactory implements KittenFactory{
    @Override
    public Kitten createKitten(String name) {
        System.out.println("A funny pure breeded " + name + " was added!:3");
        return new BreededKitten(name);
    }
}
