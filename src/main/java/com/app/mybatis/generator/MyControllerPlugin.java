/*
 * @Author: xinlu
 * @Email: 442559691@qq.com
 */

package com.app.mybatis.generator;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.GeneratedJavaFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.config.PropertyRegistry;

/**
 *
 * ServicePlugin
 * 
 */
public class MyControllerPlugin extends PluginAdapter {

	private List<TopLevelClass> services = new ArrayList<>();

	/**
	 * This plugin is always valid - no properties are required
	 */
	public boolean validate(List<String> warnings) {
		return true;
	}

	public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		String packageName = interfaze.getType().getPackageName();
		String shortName = interfaze.getType().getShortName();
		//String mapperName = interfaze.getType().getFullyQualifiedName();
		int idx = shortName.lastIndexOf("Mapper");
		if (shortName.endsWith("Mapper")) {
			idx = packageName.length();
			String servicePackage = packageName.substring(0, idx);
			String serviceName = shortName.substring(2, shortName.length() - 6);
			serviceName += "Controller";
			String fullName = servicePackage.replace("mybatis.mapper", "controller.admin") + "." + serviceName;

			TopLevelClass topLevelClazz = new TopLevelClass(fullName);
			topLevelClazz.setVisibility(JavaVisibility.PUBLIC);
			topLevelClazz.addImportedType("org.springframework.stereotype.Controller");
			topLevelClazz.addImportedType("com.app.common.BaseController");
			topLevelClazz.addAnnotation("@Controller");
			topLevelClazz.addImportedType("org.springframework.web.bind.annotation.RequestMapping");
			topLevelClazz.addAnnotation("@RequestMapping(value = \"\")");

			FullyQualifiedJavaType baseController = new FullyQualifiedJavaType("com.app.common.BaseController");
			topLevelClazz.setSuperClass(baseController);
			{
				// 增加备注信息
				topLevelClazz.addFileCommentLine("/*");
				topLevelClazz.addFileCommentLine("    this file generator by ControllerPlugin");
				topLevelClazz.addFileCommentLine("    @Author: lyn");
				topLevelClazz.addFileCommentLine("*/");
				topLevelClazz.addFileCommentLine("");
			}

			services.add(topLevelClazz);
		}
		return true;
	}

	public List<GeneratedJavaFile> contextGenerateAdditionalJavaFiles() {
		List<GeneratedJavaFile> listGjf = new ArrayList<>();
		for (TopLevelClass topLevelClazz : services) {
			GeneratedJavaFile gjf = new GeneratedJavaFile(topLevelClazz,
					context.getJavaClientGeneratorConfiguration().getTargetProject(),
					context.getProperty(PropertyRegistry.CONTEXT_JAVA_FILE_ENCODING), context.getJavaFormatter());
			listGjf.add(gjf);
		}
		return listGjf;
	}

	public List<GeneratedJavaFile> contextGenerateAdditionalJavaFiles(IntrospectedTable introspectedTable) {
		return contextGenerateAdditionalJavaFiles();
	}
}
