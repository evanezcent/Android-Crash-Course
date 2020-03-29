package id.kotlin.sa_second.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import dagger.android.AndroidInjection
import id.kotlin.sa_second.R
import id.kotlin.sa_second.data.Result
import kotlinx.android.synthetic.main.home.*
import javax.inject.Inject

class HomeActivity: AppCompatActivity(), HomeView {

    @Inject
    lateinit var presenter:HomePresenter

    override fun onShowLoading() {
        pb_home.visibility = View.VISIBLE
    }

    override fun onHideLoading() {
        pb_home.visibility = View.GONE
        rv_home.visibility = View.VISIBLE
    }

    override fun onResponse(res: List<Result>) {
        rv_home.addItemDecoration(DividerItemDecoration(this@HomeActivity, DividerItemDecoration.VERTICAL))
        rv_home.adapter = HomeAdapter(res)
    }

    override fun onFailure(err: Throwable) {
        Log.e(HomeActivity::class.java.simpleName,"${err.printStackTrace()}")
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDetach()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)
        AndroidInjection.inject(this)

        presenter.getMovie()
    }
}