package other.easycomponet


import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API

class WizardTemplateProviderImpl : WizardTemplateProvider() {

    override fun getTemplates(): List<Template> = listOf(mviSetupTemplate)

    private val mviSetupTemplate
        get() = template {
            name = "Easy Component with Activity"
            description = "Creates a new activity along layout file."
            minApi = MIN_API
            category = Category.Other // Check other categories
            formFactor = FormFactor.Mobile
            screens = listOf(
                WizardUiContext.FragmentGallery, WizardUiContext.MenuEntry,
                WizardUiContext.NewProject, WizardUiContext.NewModule
            )

            widgets(
                PackageNameWidget(appPackageName),
                TextFieldWidget(appPackageName),
                TextFieldWidget(contractPackageName),
                TextFieldWidget(presenterPackageName),
                TextFieldWidget(componentName),
                TextFieldWidget(layoutName),
                //TextFieldWidget(componentViewContractName),

            )

            recipe = { data: TemplateData ->
                easyComponentSetup(
                    this@WizardTemplateProviderImpl,
                    data as ModuleTemplateData
                )
            }
        }

    val appPackageName = stringParameter {
        name = "Package name"
        default = "com.mycompany.myapp"
        constraints = listOf(Constraint.PACKAGE)
        help = "请填写你的项目包名,请认真核实此包名是否是正确的项目包名,不能包含子包,正确的格式如:me.dev.xsf"
    }

    val layoutName = stringParameter {
        name = "Layout Name"
        default = "component_view"
        help = "The name of the layout to create for the View"
        constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
    }

    //新建组件名称
    val componentName = stringParameter {
        name = "Component Name"
        constraints = listOf(Constraint.UNIQUE, Constraint.NONEMPTY, Constraint.STRING)
        default = "One"
        help = "请填写页面名,如填写 One,会自动生成 OneView, OnePresenter 等文件"
    }

    val contractPackageName = stringParameter {
        name = "Contract Package Name"
        constraints = listOf(Constraint.STRING)
        default = "${appPackageName.value}.component${componentName.value}.contract"
        suggest = { "${appPackageName.value}.component${componentName.value}.contract" }
        help = "Contract 将被输出到此包下,请认真核实此包名是否是你需要输出的目标包名"
    }

    val presenterPackageName = stringParameter {
        name = "Presenter Package Name"
        constraints = listOf(Constraint.STRING)
        default = "${appPackageName.value}.component${componentName.value}.presenter"
        suggest = { "${appPackageName.value}.component${componentName.value}.presenter" }
        help = "Preseenter 将被输出到此包下,请认真核实此包名是否是你需要输出的目标包名"
    }


}




