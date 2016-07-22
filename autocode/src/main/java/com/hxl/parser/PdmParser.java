package com.hxl.parser;

import com.hxl.entity.Column;
import com.hxl.entity.Diagram;
import com.hxl.entity.Model;
import com.hxl.entity.Table;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by hxl on 2016/7/18.
 * 解析PDM文件
 */
public class PdmParser {

    public static Model pdmParse(String filePath) {
        Model model = new Model();

        //read pdm
        Document doc = readPDM(filePath);
        //models
        Iterator<?> it = doc.selectNodes("//o:Model").iterator();
        if(it.hasNext()) {
            Element m = (Element) it.next();
            model.setCode(m.elementTextTrim("Code"));
            model.setName(m.elementTextTrim("Name"));
            //diagrams
            List<Diagram> diagrams = new ArrayList<>();
            Iterator<?> it2 = m.selectNodes("//c:PhysicalDiagrams//o:PhysicalDiagram").iterator();
            while (it2.hasNext()) {
                Element d = (Element) it2.next();
                Diagram diagram = new Diagram();
                diagram.setCode(d.elementTextTrim("Code"));
                diagram.setName(d.elementTextTrim("Name"));
                //tables
                Iterator<?> it3 = d.selectNodes("//c:Tables//o:Table").iterator();
                List<Table> tables = new ArrayList<>();
                while (it3.hasNext()) {
                    Table table = new Table();
                    Element t = (Element) it3.next();
                    table.setCode(t.elementTextTrim("Code"));
                    table.setName(t.elementTextTrim("Name"));
                    //columns
                    Element pdmColumns = t.element("Columns");
                    if (pdmColumns == null) {
                        continue;
                    }
                    Iterator<?> it4 = pdmColumns.elements("Column").iterator();
                    List<Column> columns = new ArrayList<>();
                    //pk
                    Element keys = t.element("Keys");
                    String keys_key_id = "",keys_column_ref = "",keys_primarykey_ref_id = "";
                    if(keys!=null){
                        Element key = keys.element("Key");
                        keys_key_id = key.attributeValue("Id");
                        keys_column_ref = key.element("Key.Columns").element("Column").attributeValue("Ref");
                        keys_primarykey_ref_id = t.element("PrimaryKey").element("Key").attributeValue("Ref");
                    }
                    while (it4.hasNext()) {
                        Element c = (Element) it4.next();
                        Column column = new Column();
                        column.setCode(c.elementTextTrim("Code"));
                        column.setName(c.elementTextTrim("Name"));
                        column.setDefaultValue(c.elementTextTrim("DefaultValue"));
                        String length = c.elementTextTrim("Length");
                        column.setLength(length == null ? null : Integer.parseInt(length));
                        String type = c.elementTextTrim("DataType");
                        if(type.indexOf("(") >0){
                            column.setType(type.substring(0, type.indexOf("(")));
                        }else {
                            column.setType(type);
                        }
                        String pkID = c.attributeValue("Id");
                        if (keys_primarykey_ref_id.equals(keys_key_id) && keys_column_ref.equals(pkID)) {
                            column.setPkFlag(true);
//                            table.setIdField(column.getCode());
                        }
                        columns.add(column);
                    }
                    table.setColumns(columns);
                    tables.add(table);
                }
                diagram.setTables(tables);
                diagrams.add(diagram);
            }
            model.setDiagrams(diagrams);
        }
        return model;
    }

    private static Document readPDM(String filePath) {
        Document doc = null;
        SAXReader sr = new SAXReader();
        try {
            doc = sr.read(new File(filePath));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return doc;
    }

    public static void main(String[] args) {
        String file = "F:/PhysicalDataModel_2.pdm";
        Model model = pdmParse(file);
        System.out.println(model.getName());
    }
}
