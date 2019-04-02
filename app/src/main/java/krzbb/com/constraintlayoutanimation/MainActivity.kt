package krzbb.com.constraintlayoutanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.animation.AnticipateOvershootInterpolator
import androidx.constraintlayout.widget.ConstraintSet
import kotlinx.android.synthetic.main.activity_main_start.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_start)

        startAnim.setOnClickListener {
            startAnim(false)
        }

        button.setOnClickListener{
            startAnim(true)
        }
    }

    private fun startAnim(toInitLayout: Boolean) {
        var layoutId = if(toInitLayout) R.layout.activity_main_start else R.layout.activity_main_end

        var constraint = ConstraintSet()
        constraint.clone(this, layoutId)

        var transition = ChangeBounds()
        transition.interpolator = AnticipateOvershootInterpolator(1.0f)
        transition.setDuration(800)

        TransitionManager.beginDelayedTransition(root_view, transition)
        constraint.applyTo(root_view)
    }
}

