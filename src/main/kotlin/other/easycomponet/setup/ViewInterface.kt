package other.easycomponet.setup

import other.easycomponet.WizardTemplateProviderImpl


fun viewInterface(provider: WizardTemplateProviderImpl) = """
package ${provider.viewPackageName.value}


import com.dev.xsf.easycomponent.IView


interface I${provider.componentName.value}View:IView{
    

}    
"""
