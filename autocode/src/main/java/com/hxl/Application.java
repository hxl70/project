package com.hxl;

import com.hxl.generator.Generator;
import com.hxl.parser.PdmParser;
import com.hxl.parser.entity.Table;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

/**
 * Created by hxl on 2016/9/8.
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class);
        application.setBannerMode(Banner.Mode.OFF);
        ConfigurableApplicationContext context = application.run(args);
        Generator generator = context.getBean(Generator.class);
        List<Table> tables = PdmParser.pdmParse("F:/portalmdb.pdm");
        generator.generator(tables);
    }
}
