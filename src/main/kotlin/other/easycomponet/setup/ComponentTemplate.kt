package other.easycomponet.setup

import other.easycomponet.WizardTemplateProviderImpl


fun componentTemp(provider: WizardTemplateProviderImpl) = """
package ${provider.viewPackageName.value}


import android.content.Context
import android.view.ViewGroup
import com.dev.xsf.easycomponent.BaseComponent

import  ${provider.appPackageName.value}.component${provider.componentName.value}.presenter.${provider.componentName.value}Presenter
import ${provider.appPackageName.value}.component${provider.componentName.value}.view.I${provider.componentName.value}View
import ${provider.appPackageName.value}.component${provider.componentName.value}.view.${provider.componentName.value}View

class ${provider.componentName.value}Component: BaseComponent<I${provider.componentName.value}View, ${provider.componentName.value}Presenter>() {
    override fun onCreateView(context: Context, container: ViewGroup?, sid: String): ${provider.componentName.value}View {
        return ${provider.componentName.value}View(context, null, "${provider.componentName.value}View")
    }

    override fun onCreatePresenter(context: Context, sid: String): ${provider.componentName.value}Presenter {
        return ${provider.componentName.value}Presenter(context)
    }

    override fun bind(view: I${provider.componentName.value}View?, presenter: ${provider.componentName.value}Presenter?) {
    }

}    
"""
