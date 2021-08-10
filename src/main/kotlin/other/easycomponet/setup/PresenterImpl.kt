package other.easycomponet.setup

import other.easycomponet.WizardTemplateProviderImpl


fun presenterImpl(provider: WizardTemplateProviderImpl) = """
package ${provider.presenterPackageName.value}

import android.os.Bundle
import android.content.Context
import ${provider.appPackageName.value}.component${provider.componentName.value}.view.I${provider.componentName.value}View
import com.dev.xsf.easycomponent.IPresenter

class ${provider.componentName.value}Presenter(context: Context?):
    IPresenter<I${provider.componentName.value}View>(context),I${provider.componentName.value}Presenter{
    
    override fun onCreatePage(arguments: Bundle?) {
        super.onCreatePage(arguments)
    }



    override fun onResumePage() {
        super.onResumePage()
    }

    override fun onPausePage() {
        super.onPausePage()
    }

    override fun onStopPage() {
        super.onStopPage()
    }

    override fun onDestroyPage() {
        super.onDestroyPage()
    }

    override fun onLowMemory() {
        super.onLowMemory()
    }
   
}
  
  
"""
