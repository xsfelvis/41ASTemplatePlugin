package com.me.xsf.easycomponent.services

import com.intellij.openapi.project.Project
import com.me.xsf.easycomponent.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
