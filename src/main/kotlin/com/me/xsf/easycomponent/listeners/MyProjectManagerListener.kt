package com.me.xsf.easycomponent.listeners

import com.intellij.openapi.components.service
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ProjectManagerListener
import com.me.xsf.easycomponent.services.MyProjectService

internal class MyProjectManagerListener : ProjectManagerListener {

    companion object {
        var projectInstance: Project? = null
    }

    override fun projectOpened(project: Project) {
        projectInstance = project
        project.service<MyProjectService>()
    }

    override fun projectClosed(project: Project) {
        projectInstance = null
        super.projectClosed(project)
    }

}
