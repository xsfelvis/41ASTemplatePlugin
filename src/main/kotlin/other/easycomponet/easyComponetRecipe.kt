package other.easycomponet

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.addAllKotlinDependencies
import com.android.tools.idea.wizard.template.impl.activities.common.generateManifest
import com.intellij.openapi.roots.ProjectRootManager
import com.intellij.psi.PsiDirectory
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.PsiManager
import com.me.xsf.easycomponent.listeners.MyProjectManagerListener.Companion.projectInstance
import org.jetbrains.kotlin.idea.KotlinLanguage
import other.easycomponet.setup.simpleLayout
import other.easycomponet.setup.someActivity
import other.easycomponet.setup.someActivityLayout
import java.io.File

fun RecipeExecutor.easyComponentSetup(
//    moduleData: ModuleTemplateData,
//    packageName: String,
//    entityName: String,
//    layoutName: String
    provider: WizardTemplateProviderImpl,data: ModuleTemplateData
) {
    val project = projectInstance ?: return

    addAllKotlinDependencies(data)

     val activityClass = "${provider.layoutName.value}sActivity"
    // This will generate new manifest (with activity) to merge it with existing
    generateManifest(
        data,
        activityClass,
        provider.packageName.value,
        isLauncher = false,
        hasNoActionBar = true,
        generateActivityTitle = true,
    )
    save(simpleLayout(provider), File(data.resDir,"layout/${provider.layoutName.value}.xml" ))


}