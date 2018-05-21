package br.pessoal.main;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

public class Main {

	public static void main(String[] args) {

		// Menu menu = new Menu();
		// menu.telaInicial();

		StringWriter writer = new StringWriter();        
		VelocityContext context = new VelocityContext();
        VelocityEngine ve = new VelocityEngine();
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        ve.init();

        context.put("nome", "lol");
        context.put("aqui", "lol1");
        context.put("lol", "lol2");
        
        
        Template t = ve.getTemplate("br\\pessoal\\resources\\lol\\new.txt");

        t.merge(context, writer);
        
        System.out.println(writer.toString());
	}

}
