package com.granium.docs.configuration;

import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.google.common.base.Optional;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ModelPropertyBuilder;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.schema.ModelPropertyBuilderPlugin;
import springfox.documentation.spi.schema.contexts.ModelPropertyContext;

import javax.validation.constraints.NotNull;

/**
 * Created by Sasha.Chepurnoi on 10.02.17.
 */
@Component
public class SwaggerPlugin implements ModelPropertyBuilderPlugin {

    @Override
    public boolean supports(DocumentationType delimiter) {
        // we simply support all documentationTypes!
        return true;
    }

    @Override
    public void apply(ModelPropertyContext context) {
        ModelPropertyBuilder mybuilder = context.getBuilder();

        Optional<BeanPropertyDefinition> beanPropDef = context.getBeanPropertyDefinition();
        BeanPropertyDefinition beanDef = beanPropDef.get();
        // get the field so we can check its annotations
        AnnotatedField field = beanDef.getField();
        if (field!=null) {
            // if @NotNull is present, we make this field required!
            NotNull myNotNull = field.getAnnotation(NotNull.class);
            if (myNotNull!=null) {
                mybuilder.required(true);
            }
        }

    }
}
