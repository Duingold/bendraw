package com.lvtuben.bendraw.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @Description:
 * @author: Bryce
 * @date: 2019/6/12
 * @version: 1.0
 */
@Configuration
public class Swagger2 {

    private  static  boolean  isDebug;

    static {
        //isDebug= PropertiesUtils.getValueByKey("debug").equals("true")?true:false;
    }
    @Bean
    public Docket createRestApi() {


        //List<Parameter> pars = new ArrayList<Parameter>();
        //ParameterBuilder ticketPar = new ParameterBuilder();
        //ticketPar.name("token").description("user token")
        //        .modelRef(new ModelRef("string"))
        //        .parameterType("header")
        //        .required(false).defaultValue("").build();//required表示是否必填，defaultvalue表示默认值
        //
        //
        //pars.add(ticketPar.build());
        //ParameterBuilder ticketPar1 = new ParameterBuilder();
        //ticketPar1.name("versionCode").description("app version")
        //        .modelRef(new ModelRef("string"))
        //        .parameterType("header")
        //        .required(false).defaultValue("52").build();//required表示是否必填，defaultvalue表示默认值
        //pars.add(ticketPar1.build());

        return new Docket(DocumentationType.SWAGGER_2).enable(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.lvtuben.bendraw.controller"))
                .paths(PathSelectors.any())
                .build()//.globalOperationParameters(pars)
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("springboot利用swagger构建api文档")
                .description("简单优雅的restfun风格，http://localhost:8080/swagger-ui.html")
                .termsOfServiceUrl("http://localhost:8080/swagger-ui.html")
                .version("1.0")
                .build();
    }
}

