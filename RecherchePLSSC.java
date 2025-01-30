import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecherchePLSSC {

    // Recherche d'une PLSSC de 2 chaînes, naïf
    static String PLSSC(String S1, String S2) {

		if (S1.isEmpty() || S2.isEmpty()) {
			return "";
		}

		String new_S1 = (S1.length() > 1) ? S1.substring(1) : "";
		String new_S2 = (S2.length() > 1) ? S2.substring(1) : "";

		if ( S1.charAt(0) == S2.charAt(0) ) {
			StringBuilder subseq = new StringBuilder();
			subseq.append(S1.charAt(0));
			subseq.append(PLSSC(new_S1, new_S2));
			return subseq.toString();
		}

		String subseq1 = PLSSC(new_S1, S2);
		String subseq2 = PLSSC(S1, new_S2);

		return subseq1.length() > subseq2.length() ? subseq1 : subseq2;
    }

    // Recherche d'une PLSSC de 2 chaînes, prog. dyn.
    static String PLSSC_PD(String S1, String S2) {
        // à modifier
        return "";
    }


    public static void main(String args[]) {

        String S1;
        String S2;

        FileInputStream input;
        BufferedReader reader;

        for (int i = 0; i < args.length; i++) {
            try {
                // Ouverture du fichier passé en argument
                input = new FileInputStream(args[i]);
                reader = new BufferedReader(new InputStreamReader(input));

                // Lecture de S1
                S1 = reader.readLine();
                // Lecture S2
                S2 = reader.readLine();

                // date de début
                long startTime = System.nanoTime();

                String result = PLSSC(S1,S2);

                // date de fin pour le calcul du temps écoulé
                long endTime = System.nanoTime();

                System.out.println("S1: " + S1);
                System.out.println("S2: " + S2);
                System.out.println("PLSSC: " + result);

                // Impression de la longueur du S1 de S2 et du temps d'exécution
                System.out.println(S1.length() + "\t" + S2.length() + "\t" + ((endTime - startTime)/1.0E9));

            } catch (FileNotFoundException e) {
                System.err.println("Erreur lors de l'ouverture du fichier " + args[i]);
            } catch (IOException e) {
                System.err.println("Erreur de lecture dans le fichier");
            }
        }
    }
}




