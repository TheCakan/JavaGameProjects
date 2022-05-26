public class Stuff {
    private String name;
    private int weight;

    public Stuff(String name, int weight){
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return name;
    }
}
