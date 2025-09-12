import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int timeOfDay; // 1: dag | 2: aften | 3: nat
        int trafficDensity; // 1: høj | 2: lav
        int areaType; // 1: bolig | 2: erhverv | 3: blandet
        int trafficLight = 0; // 1: grønt || 2: Gult || 3: Rødt || 4: Ingen adgang
        int emergency;

        Scanner input = new Scanner(System.in);

        // Valg af tid
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("Vælg venligst tid på dagen.");
        System.out.println("1 = Dag");
        System.out.println("2 = Aften");
        System.out.println("3 = Nat");
        timeOfDay = input.nextInt();

        // Valg af høj eller lav trafik
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("Vælg type trafik:");
        System.out.println("1 = Høj trafik");
        System.out.println("2 = Lav trafik");
        trafficDensity = input.nextInt();

        // Valg af område
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("Vælg venligst områdetype:");
        System.out.println("1 = Boligområde");
        System.out.println("2 = Erhvervsområde");
        System.out.println("3 = Blandet");
        areaType = input.nextInt();

        // Emergency?
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("Er det en nødsituation?");
        System.out.println("1 = Ja");
        System.out.println("2 = Nej");
        emergency = input.nextInt();


        // Grønt lys
        if (timeOfDay == 1 && trafficDensity == 2 || emergency == 1) {
            trafficLight = 1;
        }

        //Gult lys
        else if (timeOfDay == 2 || timeOfDay == 3 && trafficDensity == 2) {
            trafficLight = 2;
        }

        //Rødt lys
        else if (timeOfDay == 3 && trafficDensity == 1 || areaType == 1 && trafficDensity == 1) {
            trafficLight = 3;
        } else {
            System.out.println("FEJL: Ingen if statement for trafficlight var mødt.");
        }

        // Natlukning check
        if (areaType == 1 && timeOfDay == 3 && emergency == 0) {
            trafficLight = 4;
        }


        //  Final report print
        switch (trafficLight) {
            // GRØNT LYS
            case 1:
                System.out.println("GRØNT LYS");
                System.out.println("(⬛)");
                System.out.println("(⬛)");
                System.out.println("(\uD83D\uDFE9)");
                break;
            // GULT LYS
            case 2:
                System.out.println("GULT LYS");
                System.out.println("(⬛)");
                System.out.println("(\uD83D\uDFE8)");
                System.out.println("(⬛)");
                break;
            // RØDT LYS
            case 3:
                System.out.println("RØDT LYS");
                System.out.println("(\uD83D\uDFE5)");
                System.out.println("(⬛)");
                System.out.println("(⬛)");
                break;
            // NO ENTRY
            case 4:
                System.out.println("⛔ INGEN ADGANG ⛔");
                System.out.println("\uD83C\uDF03 Natlukning i boligområde. \uD83C\uDF03");
                break;
            // FEJLKODE
            default:
                System.out.println("INTET LYS - FEJL I KODE!!!");
                break;

        }

    }
}