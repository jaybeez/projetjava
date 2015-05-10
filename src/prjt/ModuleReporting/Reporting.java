/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prjt;
   
import java.sql.SQLException;
import java.util.Scanner;


/**
 *
 * @author Arthur
 */
public class Reporting {
    
    private Connexion conn;
    
    public Reporting(Connexion conn)
    {
        this.conn = conn;
    }
    
    public void RepartitionMedecinsSpecialites() throws SQLException // à changer de VOID à JFreeChart
    {
        int NbDocs;
        
        String Specialites[] = {"Anesthesiste",
                                "Cardiologue",
                                "Generaliste",
                                "Orthopediste",
                                "Pneumologue",
                                "Radiologue",
                                "Traumatologue"};
        int nbSpecialites[] = new int[7];
        
        Scanner sc = new Scanner(conn.remplirChampsRequete("SELECT COUNT(*) FROM docteur", "/").get(0));
        NbDocs = sc.nextInt();
        System.out.println("Nb doc : " + NbDocs);
        
        for (int i = 0; i < 7; i++)
        {
            String str = conn
                        .remplirChampsRequete("SELECT COUNT(numero) "
                        + "FROM docteur "
                        + "WHERE docteur.specialite = \"" + Specialites[i] + "\"", "/").get(0);
            sc = new Scanner(str);
            nbSpecialites[i] = sc.nextInt();
            System.out.println("Nb docteur " + Specialites[i] + " : " + nbSpecialites[i]);
        }
        
        sc.close();
        
        /*
        
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (int i = 0; i < 7; i++)
        {
            dataset.setValue(Specialites[i], nbSpecialites[i]);
        }
        
        JFreeChart chart = ChartFactory.createPieChart(
        "Repartitions des medecins par spécialitée",  // chart title
        dataset,             // data
        true,               // include legend
        true,
        false
        );
        
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
        plot.setNoDataMessage("No data available");
        plot.setCircular(false);
        plot.setLabelGap(0.02);
        return chart;
        
        
        */
        
        
    }
    
    public void RepartitionInfirmierService() throws SQLException // à changer de VOID à JFreeChart
    {
        int NbInfs;
        
        String Services[] = {"REA",
                             "CHG",
                             "CAR"};
        int nbServices[] = new int[3];
        
        Scanner sc = new Scanner(conn.remplirChampsRequete("SELECT COUNT(*) FROM infirmier", "/").get(0));
        NbInfs = sc.nextInt();
        System.out.println("Nb infirmiers : " + NbInfs);
        
        for (int i = 0; i < 3; i++)
        {
            String str = conn
                        .remplirChampsRequete("SELECT COUNT(numero) "
                        + "FROM infirmier "
                        + "WHERE infirmier.code_service = \"" + Services[i] + "\"", "/").get(0);
            sc = new Scanner(str);
            nbServices[i] = sc.nextInt();
            System.out.println("Nb infirmires " + Services[i] + " : " + nbServices[i]);
        }
        
        sc.close();
        
        /*
        
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (int i = 0; i < 3; i++)
        {
            dataset.setValue(Services[i], nbServices[i]);
        }
        
        JFreeChart chart = ChartFactory.createPieChart(
        "Repartitions des infirmiers par service",  // chart title
        dataset,             // data
        true,               // include legend
        true,
        false
        );
        
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
        plot.setNoDataMessage("No data available");
        plot.setCircular(false);
        plot.setLabelGap(0.02);
        return chart;
        
        
        */
        
        
    }
    
    public void RepartitionInfirmierRotation() throws SQLException // à changer de VOID à JFreeChart
    {
        int NbInfs;
        
        String Rotations[] = {"JOUR",
                             "NUIT"};
        int nbRotations[] = new int[2];
        
        Scanner sc = new Scanner(conn.remplirChampsRequete("SELECT COUNT(*) FROM infirmier", "/").get(0));
        NbInfs = sc.nextInt();
        System.out.println("Nb infirmiers : " + NbInfs);
        
        for (int i = 0; i < 2; i++)
        {
            String str = conn
                        .remplirChampsRequete("SELECT COUNT(numero) "
                        + "FROM infirmier "
                        + "WHERE infirmier.rotation = \"" + Rotations[i] + "\"", "/").get(0);
            sc = new Scanner(str);
            nbRotations[i] = sc.nextInt();
            System.out.println("Nb infirmires " + Rotations[i] + " : " + nbRotations[i]);
        }
        
        sc.close();
        
        /*
        
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (int i = 0; i < 2; i++)
        {
            dataset.setValue(Rotations[i], nbRotations[i]);
        }
        
        JFreeChart chart = ChartFactory.createPieChart(
        "Repartitions des infirmiers par rotation",  // chart title
        dataset,             // data
        true,               // include legend
        true,
        false
        );
        
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
        plot.setNoDataMessage("No data available");
        plot.setCircular(false);
        plot.setLabelGap(0.02);
        return chart;
        
        
        */
        
        
    }
    
    public void RepartitionMaladeMutuelle() throws SQLException // à changer de VOID à JFreeChart
    {
        int NbMalades;
        
        String Mutuelles[] = {  "AG2R",
                                "CCRVP",
                                "CNAMTS",
                                "LMDE",
                                "MAAF",
                                "MAS",
                                "MGEN",
                                "MGSP",
                                "MMA",
                                "MNAM",
                                "MNFTC",
                                "MNH"};
        int nbMutuelles[] = new int[12];
        
        Scanner sc = new Scanner(conn.remplirChampsRequete("SELECT COUNT(*) FROM malade", "/").get(0));
        NbMalades = sc.nextInt();
        System.out.println("Nb malades : " + NbMalades);
        
        for (int i = 0; i < 12; i++)
        {
            String str = conn
                        .remplirChampsRequete("SELECT COUNT(numero) "
                        + "FROM malade "
                        + "WHERE malade.mutuelle = \"" + Mutuelles[i] + "\"", "/").get(0);
            sc = new Scanner(str);
            nbMutuelles[i] = sc.nextInt();
            System.out.println("Nb malades " + Mutuelles[i] + " : " + nbMutuelles[i]);
        }
        
        sc.close();
        
        /*
        
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (int i = 0; i < 12; i++)
        {
            dataset.setValue(Mutuelles[i], nbMutuelles[i]);
        }
        
        JFreeChart chart = ChartFactory.createPieChart(
        "Repartitions des malades par mutuelle",  // chart title
        dataset,             // data
        true,               // include legend
        true,
        false
        );
        
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
        plot.setNoDataMessage("No data available");
        plot.setCircular(false);
        plot.setLabelGap(0.02);
        return chart;
        
        
        */
        
        
    }
    
    
    public void RepartitionEmplyes() throws SQLException // à changer de VOID à JFreeChart
    {
        int NbDocteurs, NbInfirmiers;
        
        Scanner sc = new Scanner(conn.remplirChampsRequete("SELECT COUNT(*) FROM docteur", "/").get(0));
        NbDocteurs = sc.nextInt();
        System.out.println("Nb docteurs : " + NbDocteurs);
        
        sc = new Scanner(conn.remplirChampsRequete("SELECT COUNT(*) FROM infirmier", "/").get(0));
        NbInfirmiers = sc.nextInt();
        System.out.println("Nb infirmier : " + NbInfirmiers);
        
        sc.close();
        
        /*
        
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Docteurs", NbDocteurs);
        dataset.setValue("Infirmiers", NbInfirmiers);
        
        
        JFreeChart chart = ChartFactory.createPieChart(
        "Repartitions des employés",  // chart title
        dataset,             // data
        true,               // include legend
        true,
        false
        );
        
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
        plot.setNoDataMessage("No data available");
        plot.setCircular(false);
        plot.setLabelGap(0.02);
        return chart;
        
        
        */
        
        
    }
    
    
    
}
