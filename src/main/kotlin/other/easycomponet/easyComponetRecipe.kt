package other.easycomponet

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.addAllKotlinDependencies
import com.android.tools.idea.wizard.template.impl.activities.common.generateManifest
import com.me.xsf.easycomponent.listeners.MyProjectManagerListener.Companion.projectInstance
import other.easycomponet.setup.simpleLayout
import other.easycomponet.setup.viewContract
import other.easycomponet.setup.viewTemp
import java.io.File

fun RecipeExecutor.easyComponentSetup(
    provider: WizardTemplateProviderImpl, data: ModuleTemplateData
) {

    addAllKotlinDependencies(data)

    //layout
    save(simpleLayout(provider), File(data.resDir, "layout/${provider.layoutName.value}.xml"))
    //view contract
    val contractFile = File(
        data.rootDir,
        "${fFmSlashedPackageName(provider.viewPackageName.value)}/I${provider.componentName.value}View.kt"
    )
    save(viewContract(provider), contractFile)
    //presenter
    val presenterFile = File(
        data.rootDir,
        "${fFmSlashedPackageName(provider.viewPackageName.value)}/${provider.componentName.value}View.kt"
    )
    save(viewTemp(provider), presenterFile)

}

fun fFmSlashedPackageName(oVar: String): String {

    return "src/main/java/${oVar.replace('.', '/')}"
}