package com.je.cloud.MybatisGenerator.generator;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class ServiceGenertor {

    private static String PROPFILENAME = "mybatis_generator.properties";

    public static void main(String[] strings) throws Exception {
        new ServiceGenertor().genCode();
    }

    public void genCode() {
        try {
            Properties prop = loadProperties();
            String serviceName = prop.getProperty("domainObjectName") + "Service";
            //---------------------构建Service模板参数
            Map<String, Object> data = new HashMap<>();
            data.put("date", new Date());
            data.put("author", prop.getProperty("author"));
            data.put("todo", "..");
            data.put("domainObjectName", prop.getProperty("domainObjectName"));
            data.put("mudolePath", prop.getProperty("mudolePath"));
            data.put("packagePath", prop.getProperty("mudolePath") + ".service");
            data.put("modelPackageSuffix", prop.getProperty("modelPackageSuffix"));
            data.put("daoMapperPackageSuffix", prop.getProperty("daoMapperPackageSuffix"));
            //---------------------获取主键类型
            data.put("primaryKey", getPrimaryKeyType(prop));
            //---------------------引入freemarker配置
            Configuration cfg = getConfig(prop);
            //---------------------生成service文件
            Template temp = cfg.getTemplate("service.ftl");
            String fileName = serviceName + ".java";
            String mp = prop.getProperty("mudolePath");
            String serviceDir = System.getProperty("user.dir") + "/" + prop.getProperty("targetProject") + "/"
                    + mp.replaceAll("\\.", "/") + "/service/";
            File file = new File(serviceDir + fileName);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            temp.process(data, bw);
            System.out.println("service 接口文件生成成功");

            //---------------------生成serviceimpl文件
            data.put("packagePath", data.get("packagePath") + ".impl");
            temp = cfg.getTemplate("serviceImpl.ftl");
            fileName = serviceName + "Impl.java";
            serviceDir = serviceDir + "impl/";
            file = new File(serviceDir + fileName);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            temp.process(data, bw);
            System.out.println("service 实现类文件生成成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    Configuration getConfig(Properties prop) throws Exception {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
        String basePath = this.getClass().getResource("/" + PROPFILENAME).getPath();
        basePath = basePath.substring(0, basePath.lastIndexOf("/"));
        String tpmlateDirPath = basePath + "/" + prop.getProperty("template.file.path");
        cfg.setDirectoryForTemplateLoading(new File(tpmlateDirPath));
        cfg.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_28));
        return cfg;
    }


    String getPrimaryKeyType(Properties prop) {
        Connection conn = null;
        try {
            conn = getConn(prop);
            String catalog = conn.getCatalog(); //数据库名称
            String schema = conn.getSchema();
            DatabaseMetaData dbmd = getDbmd(conn);
            ResultSet columns = dbmd.getColumns(catalog, "%", prop.getProperty("tableName"), "%");
            Map<String, String> cl = new HashMap<>();
            while (columns.next()) {
                cl.put(columns.getString("COLUMN_NAME"), columns.getString("TYPE_NAME"));
            }
            if (cl.size() <= 0) {
                return "String";
            }
            ResultSet primaryKeyResultSet = dbmd.getPrimaryKeys(catalog, schema, prop.getProperty("tableName"));
            String p_name = "";
            while (primaryKeyResultSet.next()) {
                p_name = primaryKeyResultSet.getString("COLUMN_NAME");
            }
            if (!"".equals(p_name)) {
                //if (cl.get(p_name) == null) return "String";
                String type = cl.get(p_name).toUpperCase();
                switch (type) {
                    case "VARCHAR":
                        return "String";
                    case "INT":
                        return "Integer";
                    default:
                        return "String";
                }
            }
            return "String";
        } catch (Exception e) {
            e.printStackTrace();
            return "String";
        }
    }


    public Connection getConn(Properties prop) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Properties props = new Properties();
        props.put("user", prop.getProperty("jdbc_username"));
        props.put("remarksReporting", "true");
        props.put("password", prop.getProperty("jdbc_password"));
        Driver driver = (Driver) Class.forName(prop.getProperty("jdbc_driver")).newInstance();
        return driver.connect(prop.getProperty("jdbc_url"), props);
    }

    public DatabaseMetaData getDbmd(Connection conn) throws SQLException {
        DatabaseMetaData dbmd = conn.getMetaData();
        return dbmd;
    }

    /**
     * 加载配置文件
     *
     * @return
     */
    public static Properties loadProperties() {
        Properties prop = null;
        try {
            prop = new Properties();
            InputStream in = ServiceGenertor.class.getClassLoader().getResourceAsStream(PROPFILENAME);
            prop.load(in);
        } catch (Exception e) {
            throw new RuntimeException("加载配置文件异常!", e);
        }
        return prop;
    }

}
