package other.easycomponet


import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API

class WizardTemplateProviderImpl  : WizardTemplateProvider() {

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
                WizardUiContext.NewProject, WizardUiContext.NewModule)

            widgets(
//                TextFieldWidget(componentViewContractName),
                TextFieldWidget(layoutName),
                PackageNameWidget(packageName)
            )

            recipe = { data: TemplateData ->
                easyComponentSetup(
                    this@WizardTemplateProviderImpl,
                    data as ModuleTemplateData
                )
            }
        }

    val packageName = stringParameter {
        name = "Package name"
        default = "com.mycompany.myapp"
        constraints = listOf(Constraint.PACKAGE)
        suggest = { packageName }
    }

    val layoutName = stringParameter {
        name = "Layout Name"
        default = "component_view"
        help = "The name of the layout to create for the View"
        constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
    }

//    val componentPackageName = stringParameter {
//        name = "Component Package Name"
//        constraints = listOf(Constraint.STRING)
//        suggest = { "${appPackageName.value}.componentX" }
//        default ="${appPackageName.value}.componentX"
//        help = "Component 将被输出到此包下,请认真核实此包名是否是你需要输出的目标包名"
//    }
//
//
//
//    val componentViewPackageName = stringParameter {
//        name = "View Package Name"
//        constraints = listOf(Constraint.STRING)
//        default ="${appPackageName.value}.view"
//        help = "Presenter 将被输出到此包下,请认真核实此包名是否是你需要输出的目标包名"
//    }
//
//    val componentViewContractName = stringParameter {
//        name = "View IViewName"
//        default = "IComponentView"
//        help = "The name of the View class to create and use in Component"
//        constraints = listOf(Constraint.NONEMPTY)
//    }
//
//
//    val componentViewName = stringParameter {
//        name = "View Name"
//        default = "ComponentView"
//        help = "The name of the View class to create and use in Component"
//        constraints = listOf(Constraint.STRING)
//    }
//
//    val componentPreseterPackageName = stringParameter {
//        name = "Presenetr Package Name"
//        constraints = listOf(Constraint.STRING)
//        default ="${appPackageName.value}.presenter"
//        help = "Presenter 将被输出到此包下,请认真核实此包名是否是你需要输出的目标包名"
//    }
//
//    val componentPresenterContractName = stringParameter {
//        name = "View IPresenter"
//        default = "IPresenter"
//        help = "The name of the View class to create and use in Component"
//        constraints = listOf(Constraint.STRING)
//    }
//
//
//    val componentPresenetrName = stringParameter {
//        name = "Presenter Name"
//        default = "ComponentView"
//        help = "The name of the View class to create and use in Component"
//        constraints = listOf(Constraint.STRING)
//    }
//
//
//    val appPackageName = stringParameter {
//        name = "Package name"
//        default = "com.mycompany.myapp"
//        constraints = listOf(Constraint.PACKAGE)
//
//    }



}




