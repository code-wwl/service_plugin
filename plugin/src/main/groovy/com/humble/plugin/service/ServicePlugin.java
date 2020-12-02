package com.humble.plugin.service;

import com.android.build.gradle.BaseExtension;

import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

/**
 * @author wenlong wang
 * @date 2020/12/2 14:23
 */
public class ServicePlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        final BaseExtension extension = project.getExtensions().findByType(BaseExtension.class);
        extension.registerTransform(new InjectCodeTransform());
        project.afterEvaluate(new Action<Project>() {
            @Override
            public void execute(Project project) {
                System.out.println(extension);
            }
        });
    }
}
