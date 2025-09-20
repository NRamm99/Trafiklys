import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int timeOfDay;
        int trafficDensity;
        int areaType;
        int trafficLight;
        int emergency;
        boolean adgang = true;

        // Konstanter
        final int DAG = 1;
        final int AFTEN = 2;
        final int NAT = 3;

        final int HOJ = 1;
        final int LAV = 2;

        final int BOLIG = 1;
        final int ERHVERV = 2;
        final int BLANDET = 3;

        final int GRON = 1;
        final int GUL = 2;
        final int ROD = 3;

        final int EMERGENCY_JA = 1;
        final int EMERGENCY_NEJ = 2;

        Scanner input = new Scanner(System.in);

        // Valg af tid
        System.out.println("""
                - - - - - - - - - - - - - - - - - - - - - - - - -
                Vælg venligst tid på dagen.
                1 = Dag
                2 = Aften
                3 = Nat
                """);
        timeOfDay = input.nextInt();

        // Valg af høj eller lav trafik
        System.out.println("""
                - - - - - - - - - - - - - - - - - - - - - - - - -
                Vælg type trafik:
                1 = Høj trafik
                2 = Lav trafik
                """);
        trafficDensity = input.nextInt();

        // Valg af område
        System.out.println("""
                - - - - - - - - - - - - - - - - - - - - - - - - -
                Vælg venligst områdetype:
                1 = Boligområde
                2 = Erhvervsområde
                3 = Blandet
                """);
        areaType = input.nextInt();

        // Emergency?
        System.out.println("""
                - - - - - - - - - - - - - - - - - - - - - - - - -
                Er det en nødsituation?
                1 = Ja
                2 = Nej
                """);
        emergency = input.nextInt();


        // Grønt lys
        if ((timeOfDay == DAG) && (trafficDensity == LAV) || (emergency == EMERGENCY_JA)) {
            trafficLight = GRON;
        }

        //Gult lys
        else if ((timeOfDay == AFTEN) || (timeOfDay == NAT) && (trafficDensity == LAV)) {
            trafficLight = GUL;
        }

        //Rødt lys
        else if ((timeOfDay == NAT) && (trafficDensity == HOJ) || (areaType == BOLIG) && (trafficDensity == HOJ)) {
            trafficLight = ROD;
        } else {
            trafficLight = GUL;
        }

        // Natlukning check
        if ((areaType == BOLIG) && (timeOfDay == NAT) && (emergency == EMERGENCY_NEJ)) {
            adgang = false;
        }


        //  Final report print
        switch (trafficLight) {
            // GRØNT LYS
            case GRON:
                System.out.println("""
                        GRØNT LYS
                        (⬛)
                        (⬛)
                        (\uD83D\uDFE9)
                        """);
                break;
            // GULT LYS
            case GUL:
                System.out.println("""
                        GULT LYS
                        (⬛)
                        (\uD83D\uDFE8)
                        (⬛)
                        """);
                break;
            // RØDT LYS
            case ROD:
                System.out.println("""
                        RØDT LYS
                        (\uD83D\uDFE5)
                        (⬛)
                        (⬛)
                        """);
                break;
            // FEJLKODE
            default:
                System.out.println("""
                        GULT LYS
                        (⬛)
                        (\uD83D\uDFE8)
                        (⬛)
                        """);
                break;

        }
        if (!adgang) {
            System.out.println("""
                    ⛔ INGEN ADGANG ⛔
                    \uD83C\uDF03 Natlukning i boligområde. \uD83C\uDF03
                    """);
        } else if (trafficLight == ROD) {
            System.out.println("\uD83D\uDD14 DELVIS ADGANG \uD83D\uDD14");

        } else {
            System.out.println("✅ FRI ADGANG ✅");
        }
    }
}