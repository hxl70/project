package com.hxl.parser;

import com.hxl.parser.entity.Column;
import com.hxl.parser.entity.Table;
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

    public static List<Table> pdmParse(String filePath) {
        //read pdm
        Document doc = readPDM(filePath);

        //tables
        Iterator<?> it3 = doc.selectNodes("//c:Tables//o:Table").iterator();
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
            List columnElements = pdmColumns.elements("Column");
            Iterator<?> it4 = columnElements.iterator();
            List<Column> columns = new ArrayList<>(columnElements.size());
            //pk
            Element keys = t.element("Keys");
            String keys_key_id = "", keys_column_ref = "", keys_primarykey_ref_id = "";
            if (keys != null) {
                Element key = keys.element("Key");
                keys_key_id = key.attributeValue("Id");
                keys_column_ref = key.element("Key.Columns").element("Column").attributeValue("Ref");
                keys_primarykey_ref_id = t.element("PrimaryKey").element("Key").attributeValue("Ref");
            }
            while (it4.hasNext()) {
                Element c = (Element) it4.next();
                Column column = new Column();
                column.setTable(table);
                column.setCode(c.elementTextTrim("Code"));
                column.setName(c.elementTextTrim("Name"));
                column.setDefaultValue(c.elementTextTrim("DefaultValue"));
                String length = c.elementTextTrim("Length");
                column.setLength(length == null ? null : Integer.parseInt(length));
                String type = c.elementTextTrim("DataType");
                if (type.indexOf("(") > 0) {
                    column.setType(type.substring(0, type.indexOf("(")));
                } else {
                    column.setType(type);
                }
                String pkID = c.attributeValue("Id");
                if (keys_primarykey_ref_id.equals(keys_key_id) && keys_column_ref.equals(pkID)) {
                    column.setPkFlag(true);
//                            table.setIdField(column.getCode());
                    table.setPkColumn(column);
                } else {
                    column.setPkFlag(false);
                }
                columns.add(column);
            }
            table.setColumns(columns);
            tables.add(table);
        }
        return tables;
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

}
