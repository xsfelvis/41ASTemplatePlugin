package other.easycomponet

import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API

val mviSetupTemplate
    get() = template {
        name = "Easy Component with Activity"
        description = "Creates a new activity along layout file."
        minApi = MIN_API
        category = Category.Other // Check other categories
        formFactor = FormFactor.Mobile
        screens = listOf(WizardUiContext.FragmentGallery, WizardUiContext.MenuEntry,
            WizardUiContext.NewProject, WizardUiContext.NewModule)

        widgets(
            TextFieldWidget(entityName),
            TextFieldWidget(layoutName),
            PackageNameWidget(packageNameParam)
        )

        recipe = { data: TemplateData ->
            easyComponentSetup(
                data as ModuleTemplateData,
                packageNameParam.value,
                entityName.value,
                layoutName.value
            )
        }
    }

val packageNameParam = stringParameter {
    name = "Package name"
    visible = { !isNewModule }
    default = "com.mycompany.myapp"
    constraints = listOf(Constraint.PACKAGE)
    suggest = { packageName }
}

val entityName = stringParameter {
    name = "Entity Name"
    default = "Wurst"
    help = "The name of the entity class to create and use in Activity"
    constraints = listOf(Constraint.NONEMPTY)
}

val layoutName = stringParameter {
    name = "Layout Name"
    default = "my_act"
    help = "The name of the layout to create for the activity"
    constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
    suggest = { "${activityToLayout(entityName.value.toLowerCase())}s" }
}