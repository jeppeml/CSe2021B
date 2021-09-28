public class Main {
    public static void main(String[] args){
        Wombat wombo = new Wombat("Wumbo".toUpperCase(), 78);
        printWombatData(wombo);
        for(int i=0;i<15;i++) {
            wombo.live();
        }
        printWombatData(wombo);

    }

    public static void printWombatData(Wombat w){
        System.out.println(
                w.getName()+
                        "s health: " +
                        w.getHealth());
    }
}
