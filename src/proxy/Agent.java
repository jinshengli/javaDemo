package proxy;

public class Agent implements Person {

    private Actor actor;
    private String before;
    private String after;

    public Agent(String before, Actor actor, String after){

        this.before = before;
        this.actor = actor;
        this.after = after;

    }

    @Override
    public String speak() {

        System.out.println("before：" + before );
        System.out.println("Actor "+ actor.speak());
        System.out.println("after " + after);
        return "";
    }

    public static void main(String[] args) {
        Actor actor = new Actor();
        Agent agent = new Agent("xxx", actor, "xxxxxxxxxxxxx");
        agent.speak();
    }
}
