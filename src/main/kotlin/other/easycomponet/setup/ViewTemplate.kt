package other.easycomponet.setup

import other.easycomponet.WizardTemplateProviderImpl


fun viewTemp(provider: WizardTemplateProviderImpl) = """
package ${provider.viewPackageName.value}


import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import com.dev.me.xsf.R

class ${provider.componentName.value}View constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0):
FrameLayout(context, attrs, defStyleAttr),
I${provider.componentName.value}View {
    constructor(context: Context, viewGroup: ViewGroup?, id: String) : this(context, null, 0) {
        initView(context, viewGroup, id)
    }

    fun initView(context: Context, viewGroup: ViewGroup?, id: String) {
        inflate(context, R.layout.${provider.layoutName.value}, this)

    }
    
    override fun getComponentView(): View {
        return this
    }

}    
"""
