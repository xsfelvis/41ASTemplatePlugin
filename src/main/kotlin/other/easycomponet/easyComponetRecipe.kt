package other.easycomponet

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.addAllKotlinDependencies
import other.easycomponet.setup.*
import java.io.File

fun RecipeExecutor.easyComponentSetup(
    provider: WizardTemplateProviderImpl, data: ModuleTemplateData
) {

    addAllKotlinDependencies(data)

    //layout
    save(simpleLayout(provider), File(data.resDir, "layout/${provider.layoutName.value}.xml"))
    //view interface
    val contractFile = File(
        data.rootDir,
        "${fFmSlashedPackageName(provider.viewPackageName.value)}/I${provider.componentName.value}View.kt"
    )
    save(viewInterface(provider), contractFile)
    //view impl
    val viewImplFile = File(
        data.rootDir,
        "${fFmSlashedPackageName(provider.viewPackageName.value)}/${provider.componentName.value}View.kt"
    )
    save(viewTemp(provider), viewImplFile)

    //presenter interface
    val presenterInterfaceFile = File(
        data.rootDir,
        "${fFmSlashedPackageName(provider.presenterPackageName.value)}/I${provider.componentName.value}Presenter.kt"
    )
    save(presenterInterface(provider), presenterInterfaceFile)

    //presenterImpl
    val presenterImplFile = File(
        data.rootDir,
        "${fFmSlashedPackageName(provider.presenterPackageName.value)}/${provider.componentName.value}Presenter.kt"
    )
    save(presenterImpl(provider), presenterImplFile)

}

fun fFmSlashedPackageName(oVar: String): String {

    return "src/main/java/${oVar.replace('.', '/')}"
}