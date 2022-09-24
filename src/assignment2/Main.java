package assignment2;

public class Main {
    public static void main(String[] args) {

        // for testing purposes !
        
        Pokemon wigglytuff = new Pokemon("Wigglytuff", 130, "Normal");
        wigglytuff.learnSkill("Slam", 60, 35);

        Pokemon porygon = new Pokemon("Porygon", 120, "Normal");
        porygon.learnSkill("Hyper beam", 100, 50);

        System.out.println(porygon.attack(wigglytuff));
        System.out.println(wigglytuff.attack(wigglytuff));
        // System.out.println(porygon.attack(wigglytuff));
    }    
}
