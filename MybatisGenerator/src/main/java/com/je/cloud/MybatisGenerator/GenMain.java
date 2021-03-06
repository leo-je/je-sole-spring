package com.je.cloud.MybatisGenerator;

import java.io.File;
import java.net.URL;
import java.util.*;

import com.je.cloud.MybatisGenerator.generator.ServiceGenertor;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class GenMain {
    public static void main(String[] args) {
        List<String> warnings = new ArrayList<>();
        boolean overwrite = true;//如果已经生成过了是否进行覆盖
        String genCfg = "/config/generator.xml";//配置文件的路径:默认放到src/config下面
        URL url = GenMain.class.getResource(genCfg);
        String file = url.getFile();
        File configFile = new File(file);
        ConfigurationParser cfgParser = new ConfigurationParser(warnings);//配置文件解析器
        Configuration config = null;
        try {
            config = cfgParser.parseConfiguration(configFile);

            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator generator = new MyBatisGenerator(config, callback, warnings);
            generator.generate(null);
            System.out.println("mybatis 代码生成成功。。。");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            new ServiceGenertor().genCode();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}