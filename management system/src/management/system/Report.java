/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management.system;

/**
 *
 * @author usr
 */
import java.awt.Container;
import java.sql.Connection;
import java.util.HashMap;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;
import management.system.Database;
public class Report extends JFrame {
 
    HashMap hm = null;
    Connection con = null;
    String reportName;
   // ="C://Users/user/Documents/NetBeansProjects/management system/src/management/system/Report/report1.jasper"
    public Report() {
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
 
    }
    public Report(HashMap map) {
        this.hm = map;
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
 
    }
    public Report(HashMap map, Connection con) {
        this.hm = map;
        this.con = con;
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Report Viewer");
    }
    public void setReportName(String rptName) {
        this.reportName = rptName;
    }
 
    public void callReport() {
        JasperPrint jasperPrint = generateReport();
        JRViewer viewer = new JRViewer(jasperPrint);
        Container c = getContentPane();
        c.add(viewer);
        this.setVisible(true);
    }
 
    public void callConnectionLessReport() {
        JasperPrint jasperPrint = generateEmptyDataSourceReport();
        JRViewer viewer = new JRViewer(jasperPrint);
        Container c = getContentPane();
        c.add(viewer);
        this.setVisible(true);
    }
 
    public void closeReport() {
        //jasperViewer.setVisible(false);
    }
 
    /** THIS METHOD WILL CALL THE REPORT FROM DATA SOURCE*/
    public JasperPrint generateReport() {
        try {
            if (con == null) {
                try {
                    con = Database.getConnection();
 
                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.out.println("Exception Occured..!!");
                }
            }
            JasperPrint jasperPrint = null;
            if (hm == null) {
                hm = new HashMap();
            }
            try {
                /**You can also test this line if you want to display 
                 * report from any absolute path other than the project root path*/
                //jasperPrint = JasperFillManager.fillReport("F:/testreport/"+reportName+".jasper",hm, con);
                
               jasperPrint= JasperFillManager.fillReport("C://Users/user/Documents/NetBeansProjects/management system/src/management/system/Report/"+reportName+".jasper",hm, con);
                //jasperPrint = JasperFillManager.fillReport(reportName + ".jasper", hm, con);
            } catch (JRException e) {
                e.printStackTrace();
                System.out.println("JRException Occured..!!");
            }
            return jasperPrint;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("JRException Occured..!!");
            return null;
        }
 
    }
 
    /** call this method when your report has an empty data source*/
    public JasperPrint generateEmptyDataSourceReport() {
        try {
            JasperPrint jasperPrint = null;
            if (hm == null) {
                hm = new HashMap();
            }
            try {
                jasperPrint = JasperFillManager.fillReport(reportName + ".jasper", hm, new JREmptyDataSource());
            } catch (JRException e) {
                e.printStackTrace();
                System.out.println("JRException Occured..!!");
            }
            return jasperPrint;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("JRException Occured..!!");
            return null;
        }
 
    }
}
