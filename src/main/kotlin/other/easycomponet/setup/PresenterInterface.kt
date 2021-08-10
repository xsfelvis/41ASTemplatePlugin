package other.easycomponet.setup

import other.easycomponet.WizardTemplateProviderImpl


fun presenterInterface(provider: WizardTemplateProviderImpl) = """
package ${provider.presenterPackageName.value}

interface I${provider.componentName.value}Presenter {
    

}    
"""
