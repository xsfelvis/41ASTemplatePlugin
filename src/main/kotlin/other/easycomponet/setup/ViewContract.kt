package other.easycomponet.setup

import other.easycomponet.WizardTemplateProviderImpl


fun viewContract(provider: WizardTemplateProviderImpl) = """
package ${provider.contractPackageName.value}


import com.dev.xsf.easycomponent.IView


interface ${provider.componentName.value}:IView{
    

}    
"""
