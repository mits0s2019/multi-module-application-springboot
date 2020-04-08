package com.module;

import com.module.model.CoronaVirus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Date;

@Service
public class MailContentBuilder {

    private TemplateEngine templateEngine;

    @Autowired
    public MailContentBuilder(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public String build(CoronaVirus coronaVirus) {
        Context context = new Context();
        context.setVariable("corona", coronaVirus);
        context.setVariable("date", new Date());
        return templateEngine.process("emailTemplate", context);
    }

}
