/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management.system;

/**
 *
 * @author User
 */
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.design.JRDesignBand;
import net.sf.jasperreports.engine.design.JRDesignExpression;
import net.sf.jasperreports.engine.design.JRDesignField;
import net.sf.jasperreports.engine.design.JRDesignParameter;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JRDesignSection;
import net.sf.jasperreports.engine.design.JRDesignStaticText;
import net.sf.jasperreports.engine.design.JRDesignStyle;
import net.sf.jasperreports.engine.design.JRDesignTextField;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.type.HorizontalTextAlignEnum;

public class ReportBuilder {
    
    public JasperDesign build() throws JRException {
        
        JasperDesign jasDes = new JasperDesign();
        jasDes.setName("myreport");
        jasDes.setPageWidth(595);
        jasDes.setPageHeight(842);
        jasDes.setLeftMargin(20);
        jasDes.setRightMargin(20);
        jasDes.setTopMargin(20);
        jasDes.setBottomMargin(20);
        jasDes.setColumnWidth(555);

        // Style
        JRDesignStyle mystyle = new JRDesignStyle();
        mystyle.setName("mystyle");
        mystyle.setDefault(true);
        mystyle.setFontName("DejaVu Sans");
        mystyle.setFontSize((int) 22f);
        mystyle.setPdfFontName("Helvetica");
        mystyle.setPdfEncoding("UTF-8");
        jasDes.addStyle(mystyle);

        // Fields
        JRDesignField field1 = new JRDesignField();
        field1.setName("reg_id");
        field1.setValueClass(String.class);
        jasDes.addField(field1);

        JRDesignField field2 = new JRDesignField();
        field2.setName("uname");
        field2.setValueClass(String.class);
        jasDes.addField(field2);

        JRDesignField field3 = new JRDesignField();
        field3.setName("fname");
        field3.setValueClass(String.class);
        jasDes.addField(field3);

        // Parameter
        JRDesignParameter par = new JRDesignParameter();
        par.setName("CarPrice");
        par.setValueClass(Integer.class);
        jasDes.addParameter(par);

        // Query
        JRDesignQuery query = new JRDesignQuery();
        query.setText("SELECT * FROM Cars WHERE Price > $P{CarPrice}");
        jasDes.setQuery(query);

        // Title
        JRDesignBand titleBand = new JRDesignBand();
        titleBand.setHeight(50);

        JRDesignStaticText titleText = new JRDesignStaticText();
        titleText.setText("Expensive cars");
        titleText.setX(0);
        titleText.setY(10);
        titleText.setWidth(515);
        titleText.setHeight(30);
        //titleText.setHorizontalTextAlign(HorizontalTextAlignEnum.CENTER);
        titleText.setFontSize((int) 22f);
        titleBand.addElement(titleText);
        jasDes.setTitle(titleBand);

        // Detail
        JRDesignBand detailBand = new JRDesignBand();
        detailBand.setHeight(60);

        JRDesignTextField tf1 = new JRDesignTextField();
        tf1.setBlankWhenNull(true);
        tf1.setX(0);
        tf1.setY(10);
        tf1.setWidth(60);
        tf1.setHeight(30);
        tf1.setStyle(mystyle);
        JRDesignExpression jd=new JRDesignExpression("$F{id}");
        tf1.setExpression(jd);
        detailBand.addElement(tf1);

        JRDesignTextField tf2 = new JRDesignTextField();
        tf2.setBlankWhenNull(true);
        tf2.setX(80);
        tf2.setY(10);
        tf2.setWidth(120);
        tf2.setHeight(30);
        tf2.setHorizontalTextAlign(HorizontalTextAlignEnum.LEFT);
        tf2.setStyle(mystyle);
        tf2.setExpression(new JRDesignExpression("$F{name}"));
        detailBand.addElement(tf2);

        JRDesignTextField tf3 = new JRDesignTextField();
        tf3.setBlankWhenNull(true);
        tf3.setX(200);
        tf3.setY(10);
        tf3.setWidth(100);
        tf3.setHeight(30);
        tf3.setHorizontalTextAlign(HorizontalTextAlignEnum.RIGHT);
        tf3.setStyle(mystyle);
        tf3.setExpression(new JRDesignExpression("$F{price}"));
        detailBand.addElement(tf3);

        ((JRDesignSection) jasDes.getDetailSection()).addBand(detailBand);

        return jasDes;
    }
}
